package agency;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import company.*;
import exception.*;

public class ConcreteReservationSession extends ConcreteGenericSession implements ReservationSession {
	
	List<Quote> quotes = new ArrayList<>();
	
	public ConcreteReservationSession(SessionAgency agency, String name) {
		super(agency, name);
	}
	
	@Override
	public void createQuote(Date start, Date end, String carType, String region) throws RemoteException, ReservationException, IllegalArgumentException {
		try
		{
			Quote quote = cra.createQuote(name, new ReservationConstraints(start, end, carType, region));
			quotes.add(quote);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Override
	public List<Quote> getCurrentQuotes() {
		return quotes;
	}
	
	@Override
	public List<Reservation> confirmQuotes() throws RemoteException {
		List<Reservation> reservations = new ArrayList<>();
		try
		{
			for(Quote q : quotes)
			{
				reservations.add(cra.confirmQuote(q));
			}
			return reservations;
		}
		catch(Exception e)
		{
			try
			{
				for(Reservation r : reservations)
				{
					cra.cancelReservation(r);
				}
			}
			catch(Exception e2) {
				System.out.println("An error occurred while rolling back reservations");
			}
			throw new RemoteException("An error occurred, all quotes & reservations are deleted");
		}
	}
	
	@Override
	public List<CarType> getAvailableCarTypes(Date start, Date end) throws RemoteException, IllegalArgumentException, IllegalStateException {
		Set<CarType> carTypes = new HashSet<>();
		try
		{
			for(String c : cra.getCompanies())
				for(CarType type : cra.getAvailableCarTypes(c, start, end))
					carTypes.add(type);
			
			return new ArrayList<>(carTypes);
		}
		catch(RemoteException e)
		{
			throw e;
		}
		catch(IllegalArgumentException e)
		{
			throw e;
		}
		catch(IllegalStateException e)
		{
			throw e;
		}
		
	}
	
	@Override
	public String getCheapestCarType(Date start, Date end, String region) throws RemoteException {
		CarType cheapestCarType = null;
		try {
			for(String c : cra.getCompanies())
			{
				for(CarType type : cra.getAvailableCarTypes(c, start, end))
				{
					if(cheapestCarType == null) cheapestCarType = type;
					else
					{
						if(type.getRentalPricePerDay() < cheapestCarType.getRentalPricePerDay())
							cheapestCarType = type;
					}
					
				}
			}
			if(cheapestCarType == null) throw new RemoteException("No cars available");
			else return cheapestCarType.getName();
		}
		catch(Exception e)
		{
			throw new RemoteException(e.getMessage());
		}
		
	}
	@Override
	public List<Reservation> getReservations() throws RemoteException{
		try {
			return cra.getReservationsByRenter(name);
		}
		catch(Exception e)
		{
			throw new RemoteException(e.getMessage());
		}
	}
	@Override
	public void cancelReservation(String company, Reservation reservation) throws RemoteException{
		try {
			cra.cancelReservation(reservation);
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
		
	}
	
}
