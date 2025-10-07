package com.josue.backendcalculadorasueldo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5174") // para que React pueda hacer fetch
public class SueldoController {

    // Calcula el sueldo base con bono
    @Cacheable(value = "salarios", key = "T(java.lang.Math).round(#baseSueldo)", unless = "#result == null")
    @GetMapping("/sueldoBase")
    public SueldoResponse calcularSueldoBase(@RequestParam double baseSueldo) {
        double sueldoTotal = baseSueldo * 1.1; // ejemplo: +10% bono
        System.out.println("🔹 Calculando sueldo con bono REAL para: " + baseSueldo);
        return new SueldoResponse(baseSueldo, sueldoTotal);
    }

    // Aplica descuento
    @Cacheable(value = "salarios", key = "#sueldo", unless = "#result == null")
    @GetMapping("/descuento")
    public SueldoResponse aplicarDescuento(@RequestParam double sueldo) {
        double sueldoFinal = sueldo * 0.85; // ejemplo: -15% descuento
        System.out.println("🔹 Aplicando descuento REAL a sueldo: " + sueldo);
        return new SueldoResponse(sueldo, sueldoFinal);
    }
}
