package guru.springframework.msscbrewery.repository;

import guru.springframework.msscbrewery.entity.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
