package agency;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import company.CarRentalCompany;
import company.CarType;
import company.ICarRentalCompany;

public class ManagerSession extends GenericSession implements IManagerSession {
	
	private SessionAgency agency;
	
	public ManagerSession(SessionAgency agency)
	{
		super(agency);
	}
	
	public void registerCompany(String companyName, String url) 
	{
		// TODO replace with agency add company
		agency.reg(companyName);
	}
	
	public void unregisterCompany(String companyName) 
	{
		//remove company
	}
	
	public List<String> getCompanies() throws Exception
	{ 
		try {
			List<String> companies = agency.getCompanies();
			return companies;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}
	
	public List<CarType> getCompanyCarTypes() { return  null; }
	
	public int getNumberOfReservationsForCarType(String carRentalName, String carType) {return 0;}
	
	public Set<String> getBestClients() { return null; }
	
	public int getNumberOfReservationsByRenter(String clientName) { return 0; }
	
	public CarType getMostPopularCarTypeInYear(String crcName, int year) { return null; }

	@Override
	public CarType getMostPopularCarTypeInCRC(String crcName, int year) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
