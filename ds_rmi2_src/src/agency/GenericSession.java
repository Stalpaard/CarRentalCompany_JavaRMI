package agency;

import java.rmi.Remote;

public interface GenericSession extends Remote {
	public void closeSession() throws Exception;
}
