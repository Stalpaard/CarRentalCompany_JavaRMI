package agency;

import java.util.Date;
import java.util.List;

import company.*;

public class ReservationSession extends GenericSession implements IReservationSession {
	
	List<Quote> quotes;
	String name;
	
	public ReservationSession(LocalCarRentalAgency agency) {
		super(agency);
	}
	
	@Override
	public void createQuote(Date start, Date end, String carType, String region) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Quote> getCurrentQuotes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Reservation> confirmQuotes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CarType> getAvailableCarTypes(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getCheapestCarType(Date start, Date end, String region) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Reservation> getReservations() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void cancelReservation(String company, Reservation reservation) {
		// TODO Auto-generated method stub
		
	}
	
}
