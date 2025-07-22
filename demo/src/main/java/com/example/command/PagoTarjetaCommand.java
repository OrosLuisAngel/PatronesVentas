package com.example.command;

public class PagoTarjetaCommand implements PagoCommand {
    private double ultimoMonto;

    @Override
    public void ejecutar(double monto) {
        ultimoMonto = monto;
        System.out.println("Pagado con tarjeta: S/." + monto);
    }

    @Override
    public void deshacer() {
        System.out.println("Deshacer pago con tarjeta de: S/." + ultimoMonto);
    }
}
