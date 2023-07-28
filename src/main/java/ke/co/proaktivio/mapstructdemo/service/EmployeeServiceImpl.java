package ke.co.proaktivio.mapstructdemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ke.co.proaktivio.mapstructdemo.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	public static HashMap<Long, HashMap<Long, Employee>> companyEmployeesMap = new HashMap<>();
	
	@Override
	public Employee create(Long companyId, Employee employee) {
		if(!companyEmployeesMap.containsKey(companyId)) {
			throw new RuntimeException("Company with id " + companyId + " does not exist!");
		}
		HashMap<Long, Employee> employeesMap = companyEmployeesMap.get(companyId);
		
		if(employeesMap == null) {
			employeesMap = new HashMap<>();
		}
		
		var employeeId = employee.getId();
		if(employeesMap.containsKey(employeeId)) {
			throw new RuntimeException("Employee with id " + employeeId + " already exists!");
		}
		employee.setCompanyId(companyId);
		employeesMap.put(employeeId, employee);
		companyEmployeesMap.put(companyId, employeesMap);
		
		
		return employee;
	}

	@Override
	public Employee findByCompanyId(Long companyId, Long employeeId) {
		if(!companyEmployeesMap.containsKey(companyId)) {
			throw new RuntimeException("Company with id " + companyId + " does not exist!");
		}
		HashMap<Long, Employee> employeesMap = companyEmployeesMap.get(companyId);

		if(employeesMap == null) {
			employeesMap = new HashMap<>();
		}
		
		if(employeesMap.containsKey(employeeId)) {
			throw new RuntimeException("Employee with id " + employeeId + " already exists!");
		}
		
		return employeesMap.get(employeeId);
	}

	@Override
	public List<Employee> findAllByCompanyId(Long companyId) {
		if(!companyEmployeesMap.containsKey(companyId)) {
			throw new RuntimeException("Company with id " + companyId + " does not exist!");
		}
		HashMap<Long, Employee> employeesMap = companyEmployeesMap.get(companyId);

		if(employeesMap == null) {
			employeesMap = new HashMap<>();
		}
		
		return employeesMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Employee update(Long companyId, Long employeeId, Employee employee) {
		if(!companyEmployeesMap.containsKey(companyId)) {
			throw new RuntimeException("Company with id " + companyId + " does not exist!");
		}
		HashMap<Long, Employee> employeesMap = companyEmployeesMap.get(companyId);
		
		if(employeesMap == null) {
			employeesMap = new HashMap<>();
		}
		
		if(!employeesMap.containsKey(employeeId)) {
			throw new RuntimeException("Employee with id " + employeeId + " does not exists!");
		}
		employee.setCompanyId(companyId);
		employee.setId(employeeId);
		
		employeesMap.put(employeeId, employee);
		companyEmployeesMap.put(companyId, employeesMap);
		
		return employee;
	}

	@Override
	public void delete(Long companyId, Long employeeId) {
		if(!companyEmployeesMap.containsKey(companyId)) {
			throw new RuntimeException("Company with id " + companyId + " does not exist!");
		}
		HashMap<Long, Employee> employeesMap = companyEmployeesMap.get(companyId);
		
		if(employeesMap == null) {
			employeesMap = new HashMap<>();
		}
		
		if(!employeesMap.containsKey(employeeId)) {
			throw new RuntimeException("Employee with id " + employeeId + " does not exists!");
		}
		
		employeesMap.remove(employeeId);
		companyEmployeesMap.put(companyId, employeesMap);
	}
}
