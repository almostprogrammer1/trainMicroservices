package guru.springframework.msscbrewery.mapper;

import guru.springframework.msscbrewery.entity.Beer;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;


@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDTOMapper(Beer beer);
    Beer beerDTOToBeer(BeerDto beerDto);
}
