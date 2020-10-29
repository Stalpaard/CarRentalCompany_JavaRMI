package client;

import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.List;
import java.util.Set;

import agency.*;
import company.*;

public class Client extends AbstractTestManagement<ReservationSession, ManagerSession> {
	
	/********
	 * MAIN *
	 ********/

	private ISessionManager sessionManager;
	
	private final static int LOCAL = 0;
	private final static int REMOTE = 1;

	/**
	 * The `main` method is used to launch the client application and run the test
	 * script.
	 */
	public static void main(String[] args) throws Exception {
		// The first argument passed to the `main` method (if present)
		// indicates whether the application is run on the remote setup or not.
		int localOrRemote = (args.length == 1 && args[0].equals("REMOTE")) ? REMOTE : LOCAL;

		
		try {
			// An example reservation scenario on car rental company 'Hertz' would be...
			Client client = new Client("trips", localOrRemote);
			client.run();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/***************
	 * CONSTRUCTOR 
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws AccessException *
	 ***************/

	public Client(String scriptFile, int localOrRemote) throws AccessException, RemoteException, NotBoundException {
		super(scriptFile);
		
		//Retrieve remote reference to ICarRentalCompany
		if(localOrRemote == LOCAL)
		{
			sessionManager = (ISessionManager) LocateRegistry.getRegistry().lookup("sessionmanager");
		}
		else
		{
			sessionManager = (ISessionManager) LocateRegistry.getRegistry("10.10.10.100").lookup("sessionmanager");
		}
	}

	@Override
	protected Set<String> getBestClients(ManagerSession ms) throws Exception {
		try {
			return ms.getBestClients();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	protected String getCheapestCarType(ReservationSession session, Date start, Date end, String region)
			throws Exception {
		try {
			return session.getCheapestCarType(start, end, region);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	protected CarType getMostPopularCarTypeInCRC(ManagerSession ms, String carRentalCompanyName, int year)
			throws Exception {
		try {
			return ms.getMostPopularCarTypeInCRC(carRentalCompanyName, year);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	protected ReservationSession getNewReservationSession(String name) throws Exception {
		try {
			System.out.println("fiks die sessie nuuuuu");
			return sessionManager.createReservationSession(name);
		}
		catch(Exception e)
		{
			throw e;
		}	
	}

	@Override
	protected ManagerSession getNewManagerSession(String name) throws Exception {
		try {
			return sessionManager.createManagerSession(name);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	protected void checkForAvailableCarTypes(ReservationSession session, Date start, Date end) throws Exception {
		try {
			List<CarType> availableTypes = session.getAvailableCarTypes(start, end);
			for(CarType c : availableTypes)
				System.out.println("Available: " + c.toString());
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	protected void addQuoteToSession(ReservationSession session, String name, Date start, Date end, String carType,
			String region) throws Exception {
		try {
			session.createQuote(start, end, carType, region);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	protected List<Reservation> confirmQuotes(ReservationSession session, String name) throws Exception {
		return session.confirmQuotes();
	}

	@Override
	protected int getNumberOfReservationsByRenter(ManagerSession ms, String clientName) throws Exception {
		try {
			return ms.getNumberOfReservationsByRenter(clientName);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	protected int getNumberOfReservationsForCarType(ManagerSession ms, String carRentalName, String carType)
			throws Exception {
		try {
			return ms.getNumberOfReservationsForCarType(carRentalName, carType);
		}
		catch(Exception e) {
			throw e;
		}
		
	}


	
}