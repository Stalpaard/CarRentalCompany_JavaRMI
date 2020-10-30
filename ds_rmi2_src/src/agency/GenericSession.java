package agency;

import java.rmi.Remote;

public interface GenericSession extends Remote {
	/**
	 * Closes session
	 * @throws Exception
	 */
	public void closeSession() throws Exception;
}
