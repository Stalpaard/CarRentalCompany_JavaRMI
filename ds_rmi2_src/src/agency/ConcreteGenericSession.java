package agency;


public class ConcreteGenericSession {

	protected SessionAgency cra;
	String name;
	
	public ConcreteGenericSession(SessionAgency cra, String name) {
		this.cra = cra;
		this.name = name;
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
