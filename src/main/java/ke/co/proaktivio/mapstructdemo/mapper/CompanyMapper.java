package ke.co.proaktivio.mapstructdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ke.co.proaktivio.mapstructdemo.domain.Company;
import ke.co.proaktivio.mapstructdemo.model.CompanyDto;

@Mapper
public interface CompanyMapper {
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	CompanyDto toCompanyDto(Company company);

	Company toCompany(CompanyDto companyDto);
}
