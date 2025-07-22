package com.example.command;

public interface PagoCommand {
    void ejecutar(double monto);
    void deshacer();
}
