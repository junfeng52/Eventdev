package com.azahartech.eventdev.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadValidacionTest {
    @Test
    void esValidoEmail_DebeDevolverTrue_ParaUnEmailCorrecto() {
        // Arrange: Preparar el escenario
        String emailValido = "usuario@dominio.com";
        // Act: Ejecutar el método a probar
        boolean resultado = UtilidadValidacion.esEmailValido(emailValido);
        // Assert: Verificar el resultado
        assertTrue(resultado, "Un email válido fue marcado como inválido");
    }

    @Test
    void esEmailValido_DebeDevolverFalse_ParaUnEmailSinArroba() {

        // 1. Arrange
        String emailInvalido = "email.incorrecto.com";
        // 2. Act
        boolean resultado = UtilidadValidacion.esEmailValido(emailInvalido);
        // 3. Assert
        assertFalse(resultado, "El email sin arroba fue incorrectamente marcado como válido");
    }

    @Test
    void esEmailValido_DebeDevolverFalse_ParaUnEmailSinDominio() {
        // Arrange
        String emailInvalido = "usuario@dominio";
        // Act
        boolean resultado = UtilidadValidacion.esEmailValido (emailInvalido);
        // Assert
        assertFalse(resultado, "Un email sin punto fue aceptado");
    }

    @Test
    void esEmailValido_DebeDevolverFalse_ParaUnInputNuloOVacio() {
        assertFalse(UtilidadValidacion.esEmailValido(null), "El valor null debería ser inválido");
        assertFalse(UtilidadValidacion.esEmailValido(""), "Un string vacío debería ser inválido");
    }

    @Test
    void esCodigoEventoValido_DebeDevolverTrue_ParaUnCodigoValido(){
        assertTrue(UtilidadValidacion.esCodigoEventoValido("EVT-2000-AVT"));
    }

    @Test
    void esCodigoEventoValido_DebeDevolverFalse_ParaUnCodigoNoValido(){
        assertFalse(UtilidadValidacion.esCodigoEventoValido("EVT-200-avt"));
        assertFalse(UtilidadValidacion.esCodigoEventoValido("EVT-2000-avt"));
    }
}