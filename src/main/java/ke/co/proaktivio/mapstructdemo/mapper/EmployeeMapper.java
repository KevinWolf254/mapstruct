package ke.co.proaktivio.mapstructdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ke.co.proaktivio.mapstructdemo.domain.Employee;
import ke.co.proaktivio.mapstructdemo.model.EmployeeDto;

@Mapper
public interface EmployeeMapper {
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

	EmployeeDto toEmployeeDto(Employee employee);

	Employee toEmployee(EmployeeDto employeeDto);
}
