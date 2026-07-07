package june.module4.homework.service;

import june.module4.homework.dto.CurrencyResponse;
import june.module4.homework.entity.Currency;
import june.module4.homework.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
@AllArgsConstructor
public class CurrencyService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);
    private final RestClient restClient;
    private final CurrencyRepository repository;
    private static final String API_KEY = "fca_live_hQDRL0SgI2rUGKXVqE4jNA8r2Tz5CDoAewuNHaRl";
    public CurrencyResponse convertCurrency(String fromCurrency, String toCurrency, double units) {
        logger.info("Currency conversion started");
        String url = "https://api.freecurrencyapi.com/v1/latest?apikey="
                + API_KEY
                + "&base_currency="
                + fromCurrency;
        logger.info("Calling external API");

        Map response = restClient.get()
                .uri(url)
                .retrieve()
                .body(Map.class);

        Map<String, Double> data = (Map<String, Double>) response.get("data");

        Double rate = data.get(toCurrency);
        logger.info("Conversion rate fetched");
        double convertedAmount = units * rate;
        logger.info("Converted amount calculated");

        Currency transaction = new Currency();
        transaction.setFromCurrency(fromCurrency);
        transaction.setToCurrency(toCurrency);
        transaction.setUnits(units);
        transaction.setConvertedAmount(convertedAmount);

        repository.save(transaction);
        logger.info("Transaction saved into database");

        return new CurrencyResponse(
                fromCurrency,
                toCurrency,
                units,
                convertedAmount
        );
    }
}
