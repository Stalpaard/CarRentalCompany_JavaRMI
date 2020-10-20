package agency;

import java.util.Date;
import java.util.List;

import company.CarRentalCompany;
import company.CarType;
import company.ICarRentalCompany;

public class ManagerSession implements IManagerSession {
	
	private CarRentalAgency agency;
	
	public ManagerSession(CarRentalAgency agency)
	{
		this.agency = agency;
	}
	
	public void registerCompany(ICarRentalCompany crc) 
	{
		agency.addCompany(crc);
	}
	
	public void unregisterCompany(ICarRentalCompany crc) 
	{
		//remove company
	}
	
	public List<ICarRentalCompany> getCompanies()
	{ 
		return agency.getCompanies();
	}
	
	public List<CarType> getCompanyCarTypes() { return  null; }
	
	public int getNumberOfReservationsForCarType(CarType carType, ICarRentalCompany company) {return 0;}
	
	public List<String> getBestRenters() { return null; }
	
	public int getNumberOfReservationsByRenter(String renter) { return 0; }
	
	public CarType getMostPopularCarTypeInYear(Date year) { return null; }
	
}
