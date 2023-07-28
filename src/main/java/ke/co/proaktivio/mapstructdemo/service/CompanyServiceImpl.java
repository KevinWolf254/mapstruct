package ke.co.proaktivio.mapstructdemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ke.co.proaktivio.mapstructdemo.domain.Company;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
	private HashMap<Long, Company> companiesMap = new HashMap<>();

	@Override
	public Company create(Company company) {
		Long companyId = company.getId();
		if(companiesMap.containsKey(companyId))
			throw new RuntimeException("Company with id " + companyId + " already exists!");
		
		companiesMap.put(companyId, company);
		
		EmployeeServiceImpl.companyEmployeesMap.put(companyId, new HashMap<>());
		
		return companiesMap.get(companyId);
	}

	@Override
	public Company findById(Long companyId) {
		if(!companiesMap.containsKey(companyId))
			throw new RuntimeException("Company with id " + companyId + " does not exist!");
		return companiesMap.get(companyId);
	}

	@Override
	public List<Company> findAll() {
		return companiesMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Company update(Long companyId, Company company) {
		if(!companiesMap.containsKey(companyId))
			throw new RuntimeException("Company with id " + companyId + " does not exist!");
		company.setId(companyId);
		companiesMap.put(companyId, company);
		return companiesMap.get(companyId);
	}

	@Override
	public void delete(Long companyId) {
		companiesMap.remove(companyId);		
	}

}
