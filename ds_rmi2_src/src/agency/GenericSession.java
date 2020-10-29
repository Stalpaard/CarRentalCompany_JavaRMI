package agency;

public class GenericSession {

	protected SessionAgency cra;
	
	public GenericSession(SessionAgency cra) {
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
