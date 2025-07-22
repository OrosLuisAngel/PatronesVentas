package com.example.command;

public class PagoPayPalCommand implements PagoCommand {
    private double ultimoMonto;

    @Override
    public void ejecutar(double monto) {
        ultimoMonto = monto;
        System.out.println("Pagado con PayPal: S/." + monto);
    }

    @Override
    public void deshacer() {
        System.out.println("Deshacer pago con PayPal de: S/." + ultimoMonto);
    }
}
