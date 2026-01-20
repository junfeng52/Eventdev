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

    @Test
    void esTelefonoEspañolValido_DeveDevolverTrue_ParaUnTelefonoValido() {
        assertTrue(UtilidadValidacion.esTelefonoEspañolValido("670088999"));
    }

    @Test
    void esTelefonoEspañolValido_DeveDevolverFalse_ParaUnTelefonoNoValido() {
        assertFalse(UtilidadValidacion.esTelefonoEspañolValido("6700899"));
    }

    @Test
    void esCodigoEventoValido_DeveDevolverTrue_ParaUnCodigoEventoValido() {
        String codigoEvento = "EVT-2024-ENS";
        assertTrue(UtilidadValidacion.esCodigoEventoValido(codigoEvento));
    }

    @Test
    void esCodigoEventoValido_DeveDevolverFalse_ParaUnCodigoEventoNoValido() {
        String codigoEvento1 = "EVT-202-ENS";
        String codigoEvento2 = "EVT-2024-EN";
        String codigoEvento3 = "ET-2024-ENS";
        String codigoEvento4 = "evt-2024-ENS";
        assertFalse(UtilidadValidacion.esCodigoEventoValido(codigoEvento1));
        assertFalse(UtilidadValidacion.esCodigoEventoValido(codigoEvento2));
        assertFalse(UtilidadValidacion.esCodigoEventoValido(codigoEvento3));
        assertFalse(UtilidadValidacion.esCodigoEventoValido(codigoEvento4));
    }
}