package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerByPesel(BigInteger pesel) {
        return CustomerDto.builder()
                .firstName("aaa").lastName("bbb")
                .age(20).build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
      log.info("Customer was saved");
      return customerDto;
    }

    @Override
    public void updateCustomer(BigInteger pesel, CustomerDto customerDto) {
        log.info("customer was updated" + pesel.toString());
    }

    @Override
    public void deleteCustomer(BigInteger pesel) {
        log.info("customer was deleted" +pesel.toString());
    }
}
