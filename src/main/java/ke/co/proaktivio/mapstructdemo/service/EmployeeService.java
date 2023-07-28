package ke.co.proaktivio.mapstructdemo.service;

import java.util.List;

import ke.co.proaktivio.mapstructdemo.domain.Employee;


public interface EmployeeService {
	Employee create(Long companyId, Employee employee);
	Employee findByCompanyId(Long companyId, Long employeeId);
	List<Employee> findAllByCompanyId(Long companyId);
	Employee update(Long companyId, Long employeeId, Employee employee);
	void delete(Long companyId, Long employeeId);

}
