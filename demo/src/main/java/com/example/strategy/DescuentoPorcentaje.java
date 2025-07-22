package com.example.strategy;

public class DescuentoPorcentaje implements DescuentoStrategy {
    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - (monto * porcentaje / 100);
    }
}
