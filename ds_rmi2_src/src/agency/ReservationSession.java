package agency;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import company.*;

public interface ReservationSession extends GenericSession {
	
	/**
	 * Try to create a new quote with the given constraints
	 * @param start start date
	 * @param end end date
	 * @param carType car type
	 * @param region region
	 * @throws RemoteException
	 */
	public void createQuote(Date start, Date end, String carType, String region) throws RemoteException;
	
	/**
	 * Get the current quotes associated with the session
	 * @return a list containing quotes
	 * @throws RemoteException
	 */
	public List<Quote> getCurrentQuotes() throws RemoteException;
	
	/**
	 * Try to confirm all quotes associated with the session
	 * @return a list of made reservations
	 * @throws RemoteException
	 */
	public List<Reservation> confirmQuotes() throws RemoteException;
	
	/**
	 * Get all available car types in a given period
	 * @param start start date
	 * @param end end date
	 * @return a list containing the available car types
	 * @throws RemoteException
	 */
	public List<CarType> getAvailableCarTypes(Date start, Date end) throws RemoteException;
	
	/**
	 * Get the cheapest car type in a given period and region
	 * @param start start date
	 * @param end end date
	 * @param region region
	 * @return the cheapest car type
	 * @throws RemoteException
	 */
	public String getCheapestCarType(Date start, Date end, String region) throws RemoteException;
	
	/**
	 * Gete the reservations of the renter linked to the session
	 * @return a list of reservations by the renter
	 * @throws RemoteException
	 */
	public List<Reservation> getReservations() throws RemoteException;
	
	/**
	 * Cancel a reservation made by the renter in a company
	 * @param company rental company where reservation was made
	 * @param reservation the reservation to be cancelled
	 * @throws RemoteException
	 */
	public void cancelReservation(String company, Reservation reservation) throws RemoteException;
}
