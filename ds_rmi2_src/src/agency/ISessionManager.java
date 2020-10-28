package agency;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISessionManager extends Remote{
	
	IReservationSession createReservationSession() throws RemoteException;
	
	IManagerSession createManagerSession() throws RemoteException;
}
