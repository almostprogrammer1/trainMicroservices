package guru.springframework.msscbrewery.bootstrapData;

import guru.springframework.msscbrewery.entity.Beer;
import guru.springframework.msscbrewery.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class BeerLoadData implements CommandLineRunner {

    BeerRepository beerRepository;

    public BeerLoadData(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects(){
        beerRepository.save(Beer.builder().
                beerName("APA").beerStyle("crafted")
                .upc(4245345234545345L)
                .prize(BigDecimal.valueOf(44.33))
                .qualityToBrew(10).minOnHand(12).build());


        beerRepository.save(Beer.builder().
                beerName("IPA").beerStyle("homeMade")
                .upc(4245345234545343L)
                .prize(BigDecimal.valueOf(11.33))
                .qualityToBrew(10).minOnHand(12).build());
        System.out.println("Loaded beers: " + beerRepository.count());
    }

}
