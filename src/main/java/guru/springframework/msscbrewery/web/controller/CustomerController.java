package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerPesel}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerPesel") String customerPesel){

        return new ResponseEntity<>(customerService.getCustomerByPesel(BigInteger.valueOf(Long.parseLong(customerPesel))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> postCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto customerDtoToSave =   customerService.saveCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","api/v1/customer/" + customerDtoToSave.getPesel().toString());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{customerPesel}")
    public ResponseEntity putCustomer(@PathVariable("customerPesel") String customerPesel,@Valid @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(BigInteger.valueOf(Long.parseLong(customerPesel)),customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerPesel}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerPesel") String customerPesel){
        customerService.deleteCustomer(BigInteger.valueOf(Long.parseLong(customerPesel)));
    }

}
