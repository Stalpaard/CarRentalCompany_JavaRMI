package agency;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import company.*;
import exception.*;

public interface SessionAgency {
	
	//GenericSession
	public void closeSession(ConcreteGenericSession session) throws RemoteException, IllegalArgumentException;
	
	//ReservationSession
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws RemoteException, ReservationException, IllegalArgumentException;
	
	public Reservation confirmQuote(Quote quote) throws RemoteException, ReservationException;
	
	public Set<CarType> getAvailableCarTypes(String company, Date start, Date end) throws RemoteException, IllegalArgumentException;
	
	public void cancelReservation(Reservation reservation) throws RemoteException, IllegalArgumentException;
	
	
	//ManagerSession
	public Map<String, Integer> getClientRecord() throws RemoteException;
	
	public Set<String> getCompanies() throws RemoteException, IllegalStateException;
	
	public Collection<CarType> getCarTypesByCompany(String company) throws RemoteException;
	
	public List<Reservation> getReservationsByRenter(String renterName) throws RemoteException, IllegalArgumentException;
	
	public int getNumberOfReservationsForCarType(String crc, String carType) throws RemoteException, IllegalArgumentException;
	
	public CarType getMostPopularCarType(String company, Date start, Date end) throws RemoteException, IllegalArgumentException;
	
	public void registerCompany(String companyName, String companyUrl) throws RemoteException, IllegalArgumentException;
	
	public void unregisterCompany(String companyName) throws RemoteException, IllegalArgumentException;
}
