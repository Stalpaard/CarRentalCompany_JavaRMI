package agency;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

import company.CarRentalCompany;
import company.CarType;
import company.ICarRentalCompany;

public interface IManagerSession extends Remote {
	

	public void registerCompany();
	
	public void unregisterCompany();

	public List<CarRentalCompany> getCompanies();
	
	public List<CarType> getCompanyCarTypes();
	
	public int getNumberOfReservationsForCarType(CarType carType, ICarRentalCompany company);
	
	public List<String> getBestRenters();
	
	public int getNumberOfReservationsByRenter(String renter);
	
	public CarType getMostPopularCarTypeInYear(Date year);
}
