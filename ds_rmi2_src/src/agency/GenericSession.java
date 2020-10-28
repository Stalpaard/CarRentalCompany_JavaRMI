package agency;

public class GenericSession {

	protected LocalCarRentalAgency cra;
	
	public GenericSession(LocalCarRentalAgency cra) {
		this.cra = cra;
	}
	
	public void closeSession() {
		
	}
}
