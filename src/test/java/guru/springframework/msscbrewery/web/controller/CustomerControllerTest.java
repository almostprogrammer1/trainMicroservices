package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerDto validCustomer;

    @Before
    public void setUp(){
        validCustomer = CustomerDto.builder().lastName("test").firstName("testName").age(19).pesel(BigInteger.valueOf(21212111)).build();
    }

    @Test
    public void getCustomer() throws Exception {

        given(customerService.getCustomerByPesel(any(BigInteger.class))).willReturn(validCustomer);

        mockMvc.perform(get("/api/v1/customer/" + validCustomer.getPesel().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.firstName",is("testName")));
    }

    @Test
    public void postCustomer() throws Exception {
        CustomerDto customerDto = validCustomer;
        customerDto.setPesel(BigInteger.valueOf(21212121));
        String customerJson = objectMapper.writeValueAsString(customerDto);

        given(customerService.saveCustomer(any())).willReturn(customerDto);

        mockMvc.perform(post("/api/v1/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void putCustomer() throws Exception {
        CustomerDto customerDto = validCustomer;
        customerDto.setAge(20);
        String customerJson = objectMapper.writeValueAsString(customerDto);

        mockMvc.perform(put("/api/v1/customer/"+ customerDto.getPesel().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isNoContent());
       then(customerService).should().updateCustomer(any(),any());

    }

    @Test
    public void deleteCustomer() throws Exception {

        CustomerDto customerDto = validCustomer;
        String customerJson = objectMapper.writeValueAsString(customerDto);

        mockMvc.perform(delete("/api/v1/customer/" + customerDto.getPesel().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isNoContent());
        then(customerService).should().deleteCustomer(any());

    }

}
