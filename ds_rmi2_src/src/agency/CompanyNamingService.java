package agency;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import company.ICarRentalCompany;

class CompanyNamingService {

	private Map<String, ICarRentalCompany> companyBook = new HashMap<>();
	
	protected ICarRentalCompany getCompany(String companyName) throws IllegalArgumentException
	{
		ICarRentalCompany company = companyBook.get(companyName);
		if (company == null) throw new IllegalArgumentException("Company not registered to agency");
		return companyBook.get(companyName);
	}
	
	protected void addCompany(String companyName, ICarRentalCompany companyStub) throws Exception
	{
		if(companyBook.containsKey(companyName)) throw new Exception("There is already a company registered with name: " + companyName);
		companyBook.put(companyName, companyStub);
	}
	
	protected void removeCompany(String companyName) throws Exception
	{
		if(companyBook.remove(companyName) == null) throw new Exception("There is no company registered with name: " + companyName);
	}
	
	protected Set<String> getCompanies() throws IllegalStateException
	{
		if(companyBook.isEmpty()) throw new IllegalStateException("No companies registered to agency");
		return companyBook.keySet();
	}
}
