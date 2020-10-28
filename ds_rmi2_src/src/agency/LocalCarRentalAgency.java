package agency;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import company.*;

public interface LocalCarRentalAgency {
	
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws Exception;
	
	public void confirmQuote(Quote quote) throws Exception;
	
	public Set<CarType> getAvailableCarTypes(String company, Date start, Date end) throws Exception;
	
	public void cancelReservation(Reservation reservation) throws Exception;
	
	
	
	
	public Map<String, Integer> getCustomerRecord() throws Exception;
	
	public List<String> getCompanies() throws Exception;
	
	public List<CarType> getCarTypesByCompany(String company) throws Exception;
	
	public int getNumberOfReservations(String company, CarType carType);
	
	public CarType getMostPopularCarType(String company, Date start, Date end);
	
	public void registerCompany(String companyName, String companyUrl);
	
	public void unregisterCompany(String companyName);
}
