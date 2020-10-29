package agency;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import company.CarType;

public interface ManagerSession extends GenericSession {
	
	
	public void registerCompany(String companyName, String url) throws RemoteException;
	
	public void unregisterCompany(String companyName) throws RemoteException;
	
	public Set<String> getCompanies() throws RemoteException;
	
	public List<CarType> getCompanyCarTypes(String companyName) throws RemoteException;
	
	public int getNumberOfReservationsForCarType(String carRentalName, String carType) throws RemoteException;
	
	public Set<String> getBestClients() throws RemoteException;
	
	public int getNumberOfReservationsByRenter(String clientName) throws RemoteException;

	public CarType getMostPopularCarTypeInCRC(String crcName, int year) throws RemoteException;

}
