package agency;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

import company.CarType;
import company.Quote;
import company.Reservation;

public interface IReservationSession extends Remote {
	
	public void createQuote(Date start, Date end, String carType, String region);
	
	public List<Quote> getCurrentQuotes();
	
	public List<Reservation> confirmQuotes();
	
	public List<CarType> getAvailableCarTypes(Date start, Date end);
	
	public String getCheapestCarType(Date start, Date end, String region);
	
	public List<Reservation> getReservations();
	
	public void cancelReservation(String company, Reservation reservation);
}
