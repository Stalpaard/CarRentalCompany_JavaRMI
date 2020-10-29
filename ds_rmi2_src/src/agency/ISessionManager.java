package agency;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISessionManager extends Remote{
	
	ReservationSession createReservationSession(String name) throws RemoteException;
	
	ManagerSession createManagerSession(String name) throws RemoteException;
}
