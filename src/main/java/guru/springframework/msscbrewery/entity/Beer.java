package guru.springframework.msscbrewery.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    private String beerName;
    private String beerStyle;

    @Column(unique = true)
    private Long upc;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp modificationTime;

    private BigDecimal prize;

    private Integer minOnHand;
    private Integer qualityToBrew;
}
