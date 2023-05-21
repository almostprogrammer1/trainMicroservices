package guru.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    @NotBlank
    @Size(min = 3,max = 100)
    private String firstName;

    @NotBlank
    @Size(min = 3,max = 100)
    private String lastName;

    private int age;
    private BigInteger pesel;
}
