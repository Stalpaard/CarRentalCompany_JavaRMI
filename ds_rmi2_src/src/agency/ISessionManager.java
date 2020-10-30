package agency;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISessionManager extends Remote{
	
	/**
	 * Create a new ReservationSession
	 * @param name name of the renter
	 * @return remote reference to a ReservationSession object
	 * @throws RemoteException
	 */
	ReservationSession createReservationSession(String name) throws RemoteException;
	
	/**
	 * Create a new ManagerSession
	 * @param name name of the manager
	 * @return remote reference to a ManagerSession object
	 * @throws RemoteException
	 */
	ManagerSession createManagerSession(String name) throws RemoteException;
}
