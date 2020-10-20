package agency;

import java.util.List;

import company.*;

public class CarRentalAgency {

	private List<ICarRentalCompany> companies;
	private List<ReservationSession> reservationSessions;
	private List<ManagerSession> managerSessions;
	
	public CarRentalAgency()
	{
		
	}
	
	protected synchronized List<ICarRentalCompany> getCompanies()
	{
		return companies;
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
}
