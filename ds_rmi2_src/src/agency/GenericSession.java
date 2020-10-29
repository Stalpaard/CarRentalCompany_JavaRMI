package agency;

public class GenericSession {

	protected LocalCarRentalAgency cra;
	
	public GenericSession(LocalCarRentalAgency cra) {
		this.cra = cra;
	}
	
	public void closeSession() throws Exception {
		try
		{
			cra.closeSession(this);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
