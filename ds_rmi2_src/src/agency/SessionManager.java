package agency;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SessionManager implements ISessionManager {
	
	LocalCarRentalAgency cra;
	List<GenericSession> sessions;
	
	public SessionManager(LocalCarRentalAgency cra)
	{
		this.cra = cra;
	}
	
	public IReservationSession createReservationSession() throws RemoteException {
		ReservationSession newSession = new ReservationSession(cra);
		this.sessions.add(newSession);
		IReservationSession stub;
		try {
			stub = (IReservationSession) UnicastRemoteObject.exportObject(newSession,0);
			return stub;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	
	public IManagerSession createManagerSession() throws RemoteException {
		ManagerSession newSession = new ManagerSession(cra);
		this.sessions.add(newSession);
		IManagerSession stub;
		try {
			stub = (IManagerSession) UnicastRemoteObject.exportObject(newSession,0);
			return stub;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	
}
