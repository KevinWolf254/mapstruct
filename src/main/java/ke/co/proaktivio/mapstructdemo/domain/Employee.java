package ke.co.proaktivio.mapstructdemo.domain;

import lombok.Data;

@Data
public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private Long companyId;
}
