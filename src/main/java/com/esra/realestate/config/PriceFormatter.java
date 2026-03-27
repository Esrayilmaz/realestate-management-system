package com.esra.realestate.config;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Component("priceFormatter")
public class PriceFormatter {

    public String formatTL(Double value) {
        if (value == null) {
            return "0,00 TL";
        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("tr", "TR"));
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        return decimalFormat.format(value) + " TL";
    }
}