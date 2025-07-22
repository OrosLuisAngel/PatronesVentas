package com.example.strategy;

public class DescuentoFijo implements DescuentoStrategy {
    private double descuento;

    public DescuentoFijo(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - descuento;
    }
}
