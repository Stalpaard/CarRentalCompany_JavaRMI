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

	private Map<String, Integer> clientRecord = new HashMap<>();
	
	private CompanyNamingService namingService = new CompanyNamingService();
	
	private SessionManager sessionManager = new SessionManager(this);
	
	public CarRentalAgency() throws RemoteException
	{
		ISessionManager sessionStub = (ISessionManager) UnicastRemoteObject.exportObject(sessionManager,0);
		LocateRegistry.getRegistry().rebind("sessionmanager", sessionStub);
	}
	
	private void incrementRecord(String clientName)
	{
		if(clientRecord.get(clientName) == null) clientRecord.put(clientName, 1);
		else clientRecord.replace(clientName, clientRecord.get(clientName) + 1);
	}
	
	@Override
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws Exception {
		try {
			for(String s : namingService.getCompanies())
			{
				ICarRentalCompany company = namingService.getCompany(s);
				try
				{
					Quote quote = company.createQuote(constraints, clientName);
					return quote;
				}
				catch(ReservationException e)
				{
					//Can happen in case quote isn't possible
				}
			}
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		throw new ReservationException("No quotes possible with given constraints");
	}

	@Override
	public Reservation confirmQuote(Quote quote) throws Exception {
		try {
			ICarRentalCompany company = namingService.getCompany(quote.getRentalCompany());
			Reservation reservation = company.confirmQuote(quote);
			if(reservation != null) incrementRecord(quote.getCarRenter());
			return reservation;
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}

	@Override
	public Set<CarType> getAvailableCarTypes(String companyName, Date start, Date end) throws Exception {
		try {
			ICarRentalCompany company = namingService.getCompany(companyName);
			return company.getAvailableCarTypes(start, end);
		}
		catch(Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public void cancelReservation(Reservation reservation) throws Exception {
		try {
			ICarRentalCompany company = namingService.getCompany(reservation.getRentalCompany());
			company.cancelReservation(reservation);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}

	@Override
	public Map<String, Integer> getClientRecord() throws Exception {
		return clientRecord;
	}

	@Override
	public Set<String> getCompanies() throws Exception {
		return namingService.getCompanies();
	}

	@Override
	public Collection<CarType> getCarTypesByCompany(String companyName) throws Exception {
		try {
			ICarRentalCompany company = namingService.getCompany(companyName);
			return company.getAllCarTypes();
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}

	@Override
	public List<Reservation> getReservationsByRenter(String renterName) throws Exception {
		try {
			List<Reservation> reservations = new ArrayList<>();
			for(String s : namingService.getCompanies())
			{
				ICarRentalCompany company = namingService.getCompany(s);
				reservations.addAll(company.getReservationsByRenter(renterName));
			}
			return reservations;
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}

	@Override
	public int getNumberOfReservationsForCarType(String crc, String carType) throws Exception {
		try {
			ICarRentalCompany company = namingService.getCompany(crc);
			return company.getNumberOfReservationsForCarType(carType);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}

	@Override
	public CarType getMostPopularCarType(String companyName, Date start, Date end) throws Exception {
		try {
			ICarRentalCompany company = namingService.getCompany(companyName);
			return company.getMostPopularCarType(start, end);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}

	@Override
	public void registerCompany(String companyName, String companyUrl) throws Exception {
		try {
			ICarRentalCompany companyStub = (ICarRentalCompany)Naming.lookup(companyUrl);
			namingService.addCompany(companyName, companyStub);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		
	}

	@Override
	public void unregisterCompany(String companyName) throws Exception {
		try {
			namingService.removeCompany(companyName);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		
	}

	@Override
	public void closeSession(ConcreteGenericSession session) throws Exception {
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
