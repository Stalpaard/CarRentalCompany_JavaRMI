package agency;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import company.*;
import exception.*;

public interface SessionAgency {
	

	/**
	 * Close a session
	 * @param session the session to be closed
	 * @throws RemoteException
	 * @throws IllegalArgumentException
	 */
	public void closeSession(ConcreteGenericSession session) throws RemoteException, IllegalArgumentException;
	
	/**
	 * Try to create a quote with the given constraints in one of the registered companies
	 * @param clientName name of the renter
	 * @param constraints reservation constraints
	 * @return the quote made with the given constraints
	 * @throws RemoteException
	 * @throws ReservationException
	 * @throws IllegalArgumentException
	 */
	public Quote createQuote(String clientName, ReservationConstraints constraints) throws RemoteException, ReservationException, IllegalArgumentException;
	
	/**
	 * Try to confirm a quote (make a reservation) in a rental company
	 * @param quote the quote to be confirmed
	 * @return the made reservation
	 * @throws RemoteException
	 * @throws ReservationException
	 */
	public Reservation confirmQuote(Quote quote) throws RemoteException, ReservationException;
	
	/**
	 * Get the available car types in a company during a given period
	 * @param company name of the company
	 * @param start start date
	 * @param end end date
	 * @return a set containing the available car types
	 * @throws RemoteException
	 * @throws IllegalArgumentException
	 */
	public Set<CarType> getAvailableCarTypes(String company, Date start, Date end) throws RemoteException, IllegalArgumentException;
	
	/**
	 * Cancel a reservation with a rental company
	 * @param reservation the reservation to be cancelled
	 * @throws RemoteException
	 * @throws IllegalArgumentException
	 */
	public void cancelReservation(Reservation reservation) throws RemoteException, IllegalArgumentException;
	
	
	/**
	 * Get the client record
	 * @return a key-value map containing the number of reservations for a client (key is name of client)
	 * @throws RemoteException
	 */
	public Map<String, Integer> getClientRecord() throws RemoteException;
	
	/**
	 * Get the name of all registered companies
	 * @return a Set containing the names of all registered companies
	 * @throws RemoteException
	 * @throws IllegalStateException
	 */
	public Set<String> getCompanies() throws RemoteException, IllegalStateException;
	
	/**
	 * Get the car types of a given company
	 * @param company
	 * @return a Collection containing the car types available at the company
	 * @throws RemoteException
	 */
	public Collection<CarType> getCarTypesByCompany(String company) throws RemoteException;
	
	/**
	 * Get the reservations of a specific renter
	 * @param renterName name of the renter
	 * @return a list containing the reservations of the renter
	 * @throws RemoteException
	 * @throws IllegalArgumentException
	 */
	public List<Reservation> getReservationsByRenter(String renterName) throws RemoteException, IllegalArgumentException;
	
	/**
	 * Get the number of reservatios for a specific car type within a given company
	 * @param crc name of the company
	 * @param carType car type
	 * @return the number of reservations for the car type in the company
	 * @throws RemoteException
	 * @throws IllegalArgumentException
	 */
	public int getNumberOfReservationsForCarType(String crc, String carType) throws RemoteException, IllegalArgumentException;
	
	/**
	* Return the most popular car type in a company within a period
    * @param company the name of the company
    * @param start the start date
    * @param end the end date
    * @return the most popular car type
    * @throws RemoteException
    * @throws IllegalArgumentException
    */
   public CarType getMostPopularCarType(String company, Date start, Date end) throws RemoteException, IllegalArgumentException;
   
   /** 
    * Try to register the given company
    * @param companyName the name of the company
    * @param companyUrl the URL associated with the company
    * @throws RemoteException
    * @throws IllegalArgumentException
    */
   public void registerCompany(String companyName, String companyUrl) throws RemoteException, IllegalArgumentException;
   /** 
    * Try to unregister the company from the agency
    * @param companyName the name of the company
    * @throws RemoteException
    * @throws IllegalArgumentException
    */
   public void unregisterCompany(String companyName) throws RemoteException, IllegalArgumentException;
}
