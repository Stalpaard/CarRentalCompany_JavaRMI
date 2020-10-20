package agency;

import java.util.Date;
import java.util.List;

import company.CarRentalCompany;
import company.CarType;
import company.ICarRentalCompany;

public class ManagerSession {
	
	public ManagerSession(ICarRentalCompany crc)
	{
		
	}
	
	public void registerCompany() {}
	
	public void unregisterCompany() {}
	
	public List<CarRentalCompany> getCompanies(){ return null; }
	
	public List<CarType> getCompanyCarTypes() { return  null; }
	
	public int getNumberOfReservationsForCarType(CarType carType, ICarRentalCompany company) {return 0;}
	
	public List<String> getBestRenters() { return null; }
	
	public int getNumberOfReservationsByRenter(String renter) { return 0; }
	
	public CarType getMostPopularCarTypeInYear(Date year) { return null; }
	
}
