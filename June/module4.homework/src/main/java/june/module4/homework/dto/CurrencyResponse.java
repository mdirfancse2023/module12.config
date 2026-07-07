package june.module4.homework.dto;

public record CurrencyResponse(
        String fromCurrency,
        String toCurrency,
        double units,
        double convertedAmount
        ) {
}
