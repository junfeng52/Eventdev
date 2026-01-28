package com.azahartech.eventdev.pagos;

public class PagoPaypal implements ProcesadorPago {
    private String emailUsuario;

    public PagoPaypal(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.printf("Redirigiendo a PayPal para el usuario %s\n", this.emailUsuario);
        System.out.printf("Cobro de %.2f realizado\n", cantidad);
        return true;
    }
}
