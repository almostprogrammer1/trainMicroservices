package guru.springframework.msscbrewery.mapper;

import guru.springframework.msscbrewery.entity.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDto customerDto);
}
