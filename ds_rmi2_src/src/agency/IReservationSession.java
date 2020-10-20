package agency;

import java.rmi.Remote;
import java.util.List;

import company.CarType;
import company.Quote;

public interface IReservationSession extends Remote {
	
	public void createQuote();
	
	public List<Quote> getCurrentQuotes();
	
	public void confirmQuotes();
	
	public List<CarType> getAvailableCarTypes();
	
	public CarType getCheapestCarType();
	
	public void closeReservation();
}
