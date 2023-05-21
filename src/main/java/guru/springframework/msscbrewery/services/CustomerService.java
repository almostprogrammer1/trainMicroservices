package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.math.BigInteger;

public interface CustomerService {
    CustomerDto getCustomerByPesel(BigInteger pesel);
    CustomerDto saveCustomer(CustomerDto customerDto);
    void updateCustomer(BigInteger pesel,CustomerDto customerDto);
    void deleteCustomer(BigInteger pesel);
}
