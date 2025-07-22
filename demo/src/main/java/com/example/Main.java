package com.example;

import java.util.Scanner;

import com.example.builder.OrderBuilder;
import com.example.command.PagoCommand;
import com.example.command.PagoEfectivoCommand;
import com.example.command.PagoPayPalCommand;
import com.example.command.PagoTarjetaCommand;
import com.example.facade.VentaFacade;
import com.example.factory.ProductFactory;
import com.example.modelo.Pedido;
import com.example.modelo.Producto;
import com.example.observer.Inventario;
import com.example.strategy.DescuentoPorcentaje;
import com.example.strategy.DescuentoStrategy;
import com.example.strategy.SinDescuento;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregarObserver(producto ->
            System.out.println("Le notificamos que esta comprando:" + producto.getNombre())
        );

        VentaFacade ventaFacade = new VentaFacade(inventario);
        Scanner scanner = new Scanner(System.in);
        OrderBuilder builder = new OrderBuilder();

        System.out.println("Compre su producto:");
        String opcion;
        do {
            System.out.print("Agregar producto (electronico/ropa): ");
            String tipo = scanner.nextLine();
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            Producto producto = ProductFactory.crearProducto(tipo, nombre, precio);
            builder.agregarProducto(producto);

            System.out.print("¿Agregar otro producto? (s/n): ");
            opcion = scanner.nextLine();
        } while (opcion.equalsIgnoreCase("s"));

        Pedido pedido = builder.build();
        ventaFacade.realizarVenta(pedido);

        double total = pedido.getTotal();

        System.out.println("¿Hay descuento? (s/n): ");
        String hayDescuento = scanner.nextLine();
        DescuentoStrategy descuentoStrategy;

        if (hayDescuento.equalsIgnoreCase("s")) {
            System.out.println("Ingrese porcentaje de descuento:");
            double porcentaje = Double.parseDouble(scanner.nextLine());
            descuentoStrategy = new DescuentoPorcentaje(porcentaje);
        } else {
            descuentoStrategy = new SinDescuento();
        }

        double totalConDescuento = descuentoStrategy.aplicarDescuento(total);
        System.out.println("Total con descuento: S/." + totalConDescuento);

        System.out.println("Método de pago: 1) Efectivo 2) Tarjeta 3) PayPal");
        int metodo = Integer.parseInt(scanner.nextLine());
        PagoCommand pagoCommand;

        switch (metodo) {
            case 1:
                pagoCommand = new PagoEfectivoCommand();
                break;
            case 2:
                pagoCommand = new PagoTarjetaCommand();
                break;
            case 3:
                pagoCommand = new PagoPayPalCommand();
                break;
            default:
                System.out.println("Método no válido, se usará efectivo.");
                pagoCommand = new PagoEfectivoCommand();
        }

        pagoCommand.ejecutar(totalConDescuento);

        System.out.println("¿Desea deshacer el pago? (s/n): ");
        String deshacer = scanner.nextLine();
        if (deshacer.equalsIgnoreCase("s")) {
            pagoCommand.deshacer();
        }
    }
}