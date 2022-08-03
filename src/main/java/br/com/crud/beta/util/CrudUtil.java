package br.com.crud.beta.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CrudUtil {

    public String formatarLocalDateByString(LocalDate localDate){
        // Converte um LocalDate em String
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
