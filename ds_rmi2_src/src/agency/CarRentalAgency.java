package agency;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import company.*;
import exception.ReservationException;
import company.ICarRentalCompany;

public class CarRentalAgency implements SessionAgency {

	private static final String sessionManagerName = "sessionmanager";
	
	private Map<String, Integer> clientRecord = new HashMap<>();
	
	private CompanyNamingService namingService = new CompanyNamingService();
	
	private SessionManager sessionManager = new SessionManager(this);
	
	public CarRentalAgency() throws RemoteException
	{
		ISessionManager sessionStub = (ISessionManager) UnicastRemoteObject.exportObject(sessionManager,0);
		LocateRegistry.getRegistry().rebind(sessionManagerName, sessionStub);
	}
	
	private void incrementRecord(String clientName)
	{
		if(clientRecord.get(clientName) == null) clientRecord.put(clientName, 1);
		else clientRecord.replace(clientName, clientRecord.get(clientName) + 1);
	}
	
	@Override
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws RemoteException, ReservationException, IllegalArgumentException {
		try {
			for(String s : namingService.getCompanies())
			{
				ICarRentalCompany company = namingService.getCompany(s);
				try
				{
					Quote quote = company.createQuote(constraints, clientName);
					return quote;
				}
				catch(ReservationException | IllegalArgumentException e)
				{
					//Can happen in case quote isn't possible
				}
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		throw new ReservationException("No quotes possible with given constraints");
	}

	@Override
	public Reservation confirmQuote(Quote quote) throws RemoteException, ReservationException {
		try {
			ICarRentalCompany company = namingService.getCompany(quote.getRentalCompany());
			Reservation reservation = company.confirmQuote(quote);
			if(reservation != null) incrementRecord(quote.getCarRenter());
			return reservation;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public Set<CarType> getAvailableCarTypes(String companyName, Date start, Date end) throws RemoteException, IllegalArgumentException {
		try {
			ICarRentalCompany company = namingService.getCompany(companyName);
			return company.getAvailableCarTypes(start, end);
		}
		catch(IllegalArgumentException e) {
			throw e;
		}
	}

	@Override
	public void cancelReservation(Reservation reservation) throws RemoteException, IllegalArgumentException {
		try {
			ICarRentalCompany company = namingService.getCompany(reservation.getRentalCompany());
			company.cancelReservation(reservation);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public Map<String, Integer> getClientRecord() throws RemoteException {
		return clientRecord;
	}

	@Override
	public Set<String> getCompanies() throws IllegalStateException {
		try {
			return namingService.getCompanies();	
		}
		catch(IllegalStateException e)
		{
			throw e;
		}
	}

	@Override
	public Collection<CarType> getCarTypesByCompany(String companyName) throws RemoteException {
		try {
			ICarRentalCompany company = namingService.getCompany(companyName);
			return company.getAllCarTypes();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public List<Reservation> getReservationsByRenter(String renterName) throws RemoteException, IllegalArgumentException {
		try {
			List<Reservation> reservations = new ArrayList<>();
			for(String s : namingService.getCompanies())
			{
				ICarRentalCompany company = namingService.getCompany(s);
				try {
					reservations.addAll(company.getReservationsByRenter(renterName));
				}
				catch(IllegalArgumentException e) 
				{
					//can happen
				}
			}
			if(reservations.isEmpty()) throw new IllegalArgumentException("No reservations were made by renter: " + renterName);
			return reservations;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public int getNumberOfReservationsForCarType(String crc, String carType) throws RemoteException, IllegalArgumentException {
		try {
			ICarRentalCompany company = namingService.getCompany(crc);
			return company.getNumberOfReservationsForCarType(carType);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public CarType getMostPopularCarType(String companyName, Date start, Date end) throws RemoteException, IllegalArgumentException {
		try {
			ICarRentalCompany company = namingService.getCompany(companyName);
			return company.getMostPopularCarType(start, end);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public void registerCompany(String companyName, String companyUrl) throws RemoteException, IllegalArgumentException {
		try {
			ICarRentalCompany companyStub = (ICarRentalCompany)Naming.lookup(companyUrl);
			namingService.addCompany(companyName, companyStub);
		}
		catch(IllegalArgumentException | RemoteException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw new RemoteException(e.getMessage());
		}
		
	}

	@Override
	public void unregisterCompany(String companyName) throws RemoteException, IllegalArgumentException {
		try {
			namingService.removeCompany(companyName);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	@Override
	public void closeSession(ConcreteGenericSession session) throws RemoteException, IllegalArgumentException {
		try
		{
			sessionManager.removeSession(session);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	
}
