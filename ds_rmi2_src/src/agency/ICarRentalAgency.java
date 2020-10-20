package agency;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarRentalAgency extends Remote {

	public IReservationSession createReservationSession() throws RemoteException;
	
	public IManagerSession createManagerSession() throws RemoteException;
	
	public void closeReservationSession(IReservationSession session) throws RemoteException;
	
	public void closeManagerSession(IManagerSession session) throws RemoteException;
}
