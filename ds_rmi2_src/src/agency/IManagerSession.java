package agency;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import company.CarRentalCompany;
import company.CarType;
import company.ICarRentalCompany;

public interface IManagerSession extends Remote {
	

	public void registerCompany(String companyName, String url) throws RemoteException;
	
	public void unregisterCompany(String companyName) throws RemoteException;

	public Set<String> getCompanies() throws Exception;
	
	public List<CarType> getCompanyCarTypes(String companyName) throws RemoteException;
	
	public int getNumberOfReservationsForCarType(String carRentalName, String carType) throws RemoteException;
	
	public Set<String> getBestClients() throws RemoteException;
	
	public int getNumberOfReservationsByRenter(String clientName) throws RemoteException;
	
	public CarType getMostPopularCarTypeInCRC(String crcName, int year) throws RemoteException;
}
