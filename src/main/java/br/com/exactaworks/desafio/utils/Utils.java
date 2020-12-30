package br.com.exactaworks.desafio.utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {


    public static Date dateGeneratorForToken() {
        return new Date();
    }

    public static Date dateExpirationForToken() {
        var calendar = Calendar.getInstance();
        calendar.setTime(dateGeneratorForToken());
        calendar.add(Calendar.HOUR_OF_DAY, 5);

        return calendar.getTime();
    }
}
