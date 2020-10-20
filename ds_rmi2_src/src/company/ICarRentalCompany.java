package company;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ICarRentalCompany extends Remote {
	
	/**
	 * Get the name of the rental company
	 * 
	 * @return region name
	 * @throws RemoteException
	 */
	public String getName() throws RemoteException;
	
	/**
	 * Get a collection containing the CarType of all rental cars
	 * 
	 * @return Collection containing the CarType of all rental cars
	 * @throws RemoteException
	 */
	public Collection<CarType> getAllCarTypes() throws RemoteException;
	
	/**
	 * Check whether there's a Car with the given CarType available for a certain period of time
	 * 
	 * @param carTypeName name of the CarType
	 * @param start start date of period
	 * @param end end date of period
	 * @return true if Car is available, false otherwise
	 * @throws RemoteException
	 */
	public boolean isAvailable(String carTypeName, Date start, Date end) throws RemoteException;
	
	/**
	 * Get the CarType of all available Cars for the specified period
	 * 
	 * @param start start date of period
	 * @param end end date of period
	 * @return Set of CarType of all available Cars
	 * @throws RemoteException
	 */
	public Set<CarType> getAvailableCarTypes(Date start, Date end) throws RemoteException;
	
	/**
	 * Get the operating regions of the rental company
	 * 
	 * @return A list containing strings with region names
	 * @throws RemoteException
	 */
	public List<String> getRegions() throws RemoteException;
	
	/**
	 * Check whether a rental company operates in a specified region
	 * 
	 * @param region region name
	 * @return true if the company operates in the region, false otherwise
	 * @throws RemoteException
	 */
	public boolean operatesInRegion(String region) throws RemoteException;
	
	/**
	 * Create quote from given details
	 * 
	 * @param constraints details of the Quote
	 * @param client name of the car renter
	 * @return Quote Quote made with provided details
	 * @throws RemoteException
	 * @throws ReservationException
	 */
	public Quote createQuote(ReservationConstraints constraints, String client) throws RemoteException, ReservationException;

	/**
	 * Try to confirm a tentative reservation
	 * 
	 * @param quote Quote of tentative reservation
	 * @return Reservation made using Quote
	 * @throws RemoteException
	 * @throws ReservationException
	 */
	public Reservation confirmQuote(Quote quote) throws RemoteException, ReservationException;
	
	/**
	 * Cancel a made reservation
	 * 
	 * @param res the reservation we want to cancel
	 * @throws RemoteException
	 */
	public void cancelReservation(Reservation res) throws RemoteException;
	
	/**
	 * Get the reservations of a specified renter
	 * 
	 * @param renterName name of the renter
	 * @return List containing the reservations of the renter
	 * @throws RemoteException
	 */
	public List<Reservation> getReservationsByRenter(String renterName) throws RemoteException;
	
	/**
	 * Get number of reservations for a specified CarType
	 * 
	 * @param carType Name of the CarType
	 * @return number of reservations
	 * @throws RemoteException
	 */
	public int getNumberOfReservationsForCarType(String carType) throws RemoteException;
}