package june.module4.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import june.module4.homework.dto.CurrencyResponse;
import june.module4.homework.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/currency")
public class CurrencyController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
    private final CurrencyService currencyService;
    @Operation(summary = "Convert one currency to another")
    @GetMapping("/convert")
    public CurrencyResponse convertCurrency(
        @Parameter(description = "Source currency")
            @RequestParam String fromCurrency,
        @Parameter(description = "Target currency")
            @RequestParam String toCurrency,
        @Parameter(description = "Amount to convert")
            @RequestParam double units){
        logger.info("Received request for currency conversion");
        return currencyService.convertCurrency(
                fromCurrency,
                toCurrency,
                units
        );
    }
}
