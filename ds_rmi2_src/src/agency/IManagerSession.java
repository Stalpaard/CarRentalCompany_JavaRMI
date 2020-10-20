package agency;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import company.CarRentalCompany;
import company.CarType;
import company.ICarRentalCompany;

public interface IManagerSession extends Remote {
	

	public void registerCompany(ICarRentalCompany crc) throws RemoteException;
	
	public void unregisterCompany(ICarRentalCompany crc) throws RemoteException;

	public List<ICarRentalCompany> getCompanies() throws RemoteException;
	
	public List<CarType> getCompanyCarTypes() throws RemoteException;
	
	public int getNumberOfReservationsForCarType(CarType carType, ICarRentalCompany company) throws RemoteException;
	
	public List<String> getBestRenters() throws RemoteException;
	
	public int getNumberOfReservationsByRenter(String renter) throws RemoteException;
	
	public CarType getMostPopularCarTypeInYear(Date year) throws RemoteException;
}
