package ke.co.proaktivio.mapstructdemo.service;

import java.util.List;

import ke.co.proaktivio.mapstructdemo.domain.Company;

public interface CompanyService {
	Company create(Company company);
	Company findById(Long companyId);
	List<Company> findAll();
	Company update(Long companyId, Company company);
	void delete(Long companyId); 
}
