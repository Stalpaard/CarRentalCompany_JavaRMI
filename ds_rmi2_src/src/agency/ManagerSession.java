package agency;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import company.CarType;

public interface ManagerSession extends GenericSession {
	
	/**
	 * Register a new company in the agency
	 * @param companyName name of the new company
	 * @param url location of the remote company object in the company's rmiregistry
	 * @throws RemoteException
	 */
	public void registerCompany(String companyName, String url) throws RemoteException;
	
	/**
	 * Unregister a company in the agency
	 * @param companyName name of the company
	 * @throws RemoteException
	 */
	public void unregisterCompany(String companyName) throws RemoteException;
	
	/**
	 * Get the name of all registered companies
	 * @return a set containing the names of all registered companies
	 * @throws RemoteException
	 */
	public Set<String> getCompanies() throws RemoteException;
	
	/**
	 * Get all car types a car rental company provides
	 * @param companyName name of the company
	 * @return a list of CarType 
	 * @throws RemoteException
	 */
	public List<CarType> getCompanyCarTypes(String companyName) throws RemoteException;
	
	/**
	 * Retrieve the number of reservations for a car type
	 * @param carRentalName name of the company
	 * @param carType name of the car type
	 * @return number of reservations for the car type
	 * @throws RemoteException
	 */
	public int getNumberOfReservationsForCarType(String carRentalName, String carType) throws RemoteException;
	
	/**
	 * Get the names of the best clients (clients with the most reservations)
	 * @return a Set containing the names of the best clients
	 * @throws RemoteException
	 */
	public Set<String> getBestClients() throws RemoteException;
	
	/**
	 * Retrieve the number of reservations for a renter
	 * @param clientName name of the renter
	 * @return the number of reservations made (in the agency) by the renter
	 * @throws RemoteException
	 */
	public int getNumberOfReservationsByRenter(String clientName) throws RemoteException;

	/**
	 * Get the most popular car type in a car rental company during a calendar year
	 * @param crcName name of the company
	 * @param year calenday year
	 * @return tbe most popular car type
	 * @throws RemoteException
	 */
	public CarType getMostPopularCarTypeInCRC(String crcName, int year) throws RemoteException;

}
