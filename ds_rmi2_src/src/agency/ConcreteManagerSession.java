package agency;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import company.CarType;

public class ConcreteManagerSession extends ConcreteGenericSession implements ManagerSession {
	
	public ConcreteManagerSession(SessionAgency agency, String name)
	{
		super(agency, name);
	}
	
	public void registerCompany(String companyName, String url) throws RemoteException
	{
		try {
			cra.registerCompany(companyName, url);
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
	
	public void unregisterCompany(String companyName) throws RemoteException
	{
		try {
			cra.unregisterCompany(companyName);
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
	
	public Set<String> getCompanies() throws RemoteException
	{ 
		try {
			Set<String> companies = cra.getCompanies();
			return companies;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
	
	public List<CarType> getCompanyCarTypes(String companyName) throws RemoteException { 
		
		try {
			ArrayList<CarType> carTypes = (ArrayList<CarType>) cra.getCarTypesByCompany(companyName);
			return carTypes;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
	
	public int getNumberOfReservationsForCarType(String carRentalName, String carType) throws RemoteException {
		try {
			int number = cra.getNumberOfReservationsForCarType(carRentalName, carType);
			return number;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
	
	public Set<String> getBestClients() throws RemoteException { 
		try {
			Map<String, Integer> clients = cra.getClientRecord();
			Set<String> bestClients = new HashSet<String>();
			String bestClient = Collections.max(clients.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
			int max = clients.remove(bestClient);
			bestClients.add(bestClient);
			
			for(String key : clients.keySet())
			{
				if(max == clients.get(key)) 
				{
					bestClients.add(key);
				}
			}
			return bestClients;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
		}
	
	public int getNumberOfReservationsByRenter(String clientName) throws RemoteException {
		try {
			int number = cra.getReservationsByRenter(clientName).size();
			return number;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
	
	@Override
	public CarType getMostPopularCarTypeInCRC(String crcName, int year) throws RemoteException {
		try {
			CarType cartype = cra.getMostPopularCarType(crcName, new Date(year,1,1), new Date(year,11,31));
			return cartype;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

}
