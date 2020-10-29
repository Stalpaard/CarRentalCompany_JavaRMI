package agency;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import company.*;

public interface ReservationSession extends GenericSession {
	
	public void createQuote(Date start, Date end, String carType, String region) throws RemoteException;
	
	public List<Quote> getCurrentQuotes() throws RemoteException;
	
	public List<Reservation> confirmQuotes() throws RemoteException;
	
	public List<CarType> getAvailableCarTypes(Date start, Date end) throws RemoteException;
	
	public String getCheapestCarType(Date start, Date end, String region) throws RemoteException;
	
	public List<Reservation> getReservations() throws RemoteException;
	
	public void cancelReservation(String company, Reservation reservation) throws RemoteException;
}
