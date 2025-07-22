package com.example.strategy;

public class SinDescuento implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double monto) {
        return monto;
    }
}
