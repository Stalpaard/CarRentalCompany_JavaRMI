package agency;

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
	public void closeSession(ConcreteGenericSession session) throws Exception;
	
	//ReservationSession
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws RemoteException, ReservationException, IllegalArgumentException;
	
	public Reservation confirmQuote(Quote quote) throws Exception;
	
	public Set<CarType> getAvailableCarTypes(String company, Date start, Date end) throws RemoteException, IllegalArgumentException;
	
	public void cancelReservation(Reservation reservation) throws Exception;
	
	
	//ManagerSession
	public Map<String, Integer> getClientRecord() throws Exception;
	
	public Set<String> getCompanies() throws IllegalStateException;
	
	public Collection<CarType> getCarTypesByCompany(String company) throws Exception;
	
	public List<Reservation> getReservationsByRenter(String renterName) throws Exception;
	
	public int getNumberOfReservationsForCarType(String crc, String carType) throws Exception;
	
	public CarType getMostPopularCarType(String company, Date start, Date end) throws Exception;
	
	public void registerCompany(String companyName, String companyUrl) throws Exception;
	
	public void unregisterCompany(String companyName) throws Exception;
}
