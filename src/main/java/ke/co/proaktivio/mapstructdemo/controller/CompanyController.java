package ke.co.proaktivio.mapstructdemo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ke.co.proaktivio.mapstructdemo.mapper.CompanyMapper;
import ke.co.proaktivio.mapstructdemo.mapper.EmployeeMapper;
import ke.co.proaktivio.mapstructdemo.model.CompanyDto;
import ke.co.proaktivio.mapstructdemo.model.EmployeeDto;
import ke.co.proaktivio.mapstructdemo.service.CompanyService;
import ke.co.proaktivio.mapstructdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {
	private final CompanyService companyService;
	private final EmployeeService employeeService;
		
	private final CompanyMapper mapper;
	private final EmployeeMapper employeeMapper;
	
	@PostMapping
	CompanyDto create(@RequestBody CompanyDto company) {
		return mapper.toCompanyDto(companyService.create(mapper.toCompany(company)));
	}

	@PostMapping("/{companyId}/employees")
	EmployeeDto createCompanyEmployee(@PathVariable Long companyId, @RequestBody EmployeeDto employee) {
		return employeeMapper.toEmployeeDto(employeeService.create(companyId, employeeMapper.toEmployee(employee)));
	}
	
	@GetMapping("/{companyId}")
	CompanyDto findById(@PathVariable Long companyId) {
		return mapper.toCompanyDto(companyService.findById(companyId));
	}
	
	@GetMapping
	List<CompanyDto> findAll() {
		return companyService.findAll().stream()
						.map(company -> mapper.toCompanyDto(company))
						.collect(Collectors.toList());
	}
	
	@GetMapping("/{companyId}/employees")
	List<EmployeeDto> findCompanyEmployees(@PathVariable Long companyId) {
		return employeeService.findAllByCompanyId(companyId).stream()
				.map(employee -> employeeMapper.toEmployeeDto(employee)).collect(Collectors.toList());
	}
	
	@GetMapping("/{companyId}/employees/{employeeId}")
	EmployeeDto findCompanyEmployeeById(@PathVariable Long companyId, @PathVariable Long employeeId) {
		return employeeMapper.toEmployeeDto(employeeService.findByCompanyId(companyId, employeeId));
	}
	
	@PutMapping("/{companyId}")
	CompanyDto update(@PathVariable Long companyId, CompanyDto company) {
		return mapper.toCompanyDto(companyService.update(companyId, mapper.toCompany(company)));
	}

	@PutMapping("/{companyId}/employees/{employeeId}")
	EmployeeDto updateCompanyEmployee(@PathVariable Long companyId, @PathVariable Long employeeId,
			EmployeeDto employee) {
		return employeeMapper
				.toEmployeeDto(employeeService.update(companyId, employeeId, employeeMapper.toEmployee(employee)));
	}

	@DeleteMapping("/{companyId}")
	void delete(@PathVariable Long companyId) {
		companyService.delete(companyId);
	}

	@DeleteMapping("/{companyId}/employees/{employeeId}")
	void deleteCompanyEmployee(@PathVariable Long companyId, @PathVariable Long employeeId) {
		employeeService.delete(companyId, employeeId);
	}
}
