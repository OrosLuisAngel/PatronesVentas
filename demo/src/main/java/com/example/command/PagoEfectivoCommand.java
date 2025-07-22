package com.example.command;

public class PagoEfectivoCommand implements PagoCommand {
    private double ultimoMonto;

    @Override
    public void ejecutar(double monto) {
        ultimoMonto = monto;
        System.out.println("Pagado en efectivo: S/." + monto);
    }

    @Override
    public void deshacer() {
        System.out.println("Deshacer pago en efectivo de: S/." + ultimoMonto);
    }
}
