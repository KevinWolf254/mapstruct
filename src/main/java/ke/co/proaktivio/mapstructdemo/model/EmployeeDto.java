package ke.co.proaktivio.mapstructdemo.model;

import lombok.Data;

@Data
public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private Long companyId;
}
