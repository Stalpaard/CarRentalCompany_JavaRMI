package agency;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import company.*;

public class CarRentalAgency implements LocalCarRentalAgency {

	private List<ICarRentalCompany> companies;
	private List<ReservationSession> reservationSessions;
	private List<ManagerSession> managerSessions;
	
	public CarRentalAgency()
	{
		
	}
	
	
	protected synchronized void addCompany(ICarRentalCompany company) throws Exception
	{
		if(companies.contains(company)) throw new Exception("Registration failed: Company already registered to agency");
		getCompanies().add(company);
	}
	
	protected synchronized void removeCompany(ICarRentalCompany company) throws Exception
	{
		if(companies.remove(company) == false) throw new Exception("Unregistration failed: Company not registered to agency");
	}

	@Override
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmQuote(Quote quote) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<CarType> getAvailableCarTypes(String company, Date start, Date end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelReservation(Reservation reservation) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Integer> getCustomerRecord() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarType> getCarTypesByCompany(String company) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfReservationsForCarTypeInCompany(String company, CarType carType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CarType getMostPopularCarType(String company, Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerCompany(String companyName, String companyUrl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterCompany(String companyName) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<String> getCompanies() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
