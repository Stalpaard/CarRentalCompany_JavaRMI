package agency;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import company.*;

public interface LocalCarRentalAgency {
	
	//GenericSession
	public void closeSession(GenericSession session) throws Exception;
	
	//ReservationSession
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws Exception;
	
	public Reservation confirmQuote(Quote quote) throws Exception;
	
	public Set<CarType> getAvailableCarTypes(String company, Date start, Date end) throws Exception;
	
	public void cancelReservation(Reservation reservation) throws Exception;
	
	
	//ManagerSession
	public Map<String, Integer> getClientRecord() throws Exception;
	
	public Set<String> getCompanies() throws Exception;
	
	public Collection<CarType> getCarTypesByCompany(String company) throws Exception;
	
	public List<Reservation> getReservationsByRenter(String renterName) throws Exception;
	
	public int getNumberOfReservationsForCarType(String crc, String carType) throws Exception;
	
	public CarType getMostPopularCarType(String company, Date start, Date end) throws Exception;
	
	public void registerCompany(String companyName, String companyUrl) throws Exception;
	
	public void unregisterCompany(String companyName) throws Exception;
}
