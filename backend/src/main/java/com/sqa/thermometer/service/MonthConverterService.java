package com.sqa.thermometer.service;

import java.util.HashMap;
import java.util.Map;

public class MonthConverterService {
  
    private static final Map<String, Integer> monthMap = new HashMap<>();

    static {
        monthMap.put("january", 1);
        monthMap.put("february", 2);
        monthMap.put("march", 3);
        monthMap.put("april", 4);
        monthMap.put("may", 5);
        monthMap.put("june", 6);
        monthMap.put("july", 7);
        monthMap.put("august", 8);
        monthMap.put("september", 9);
        monthMap.put("october", 10);
        monthMap.put("november", 11);
        monthMap.put("december", 12);
    }

    public static Integer convertirMesANumero(String mes) {
        // Convertir el mes a minúsculas para evitar errores de mayúsculas y minúsculas
        String mesEnMinusculas = mes.toLowerCase();
        
        // Obtener el número del mes del mapa
        Integer numeroDeMes = monthMap.get(mesEnMinusculas);
        
        return numeroDeMes;
    }
}
