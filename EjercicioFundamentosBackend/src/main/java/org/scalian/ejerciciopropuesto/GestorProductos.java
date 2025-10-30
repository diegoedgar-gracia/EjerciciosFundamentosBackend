package org.scalian.ejerciciopropuesto;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Predicate;

public class GestorProductos {

    private static String patchEuros(Double precio) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(precio) + "€";
    }

    //Tendrá el main que ejecutará la aplicación
    /*Realiza las siguientes operaciones usando streams:
    Obtener todos los productos con precio > 50€.
    Convertir todos los nombres de producto a mayúsculas.
    Calcular el precio final de cada producto con su descuento ya acplicado.
    Imprimir los productos ordenados por precio descendente.
    */
    public static void main() {
        System.out.println("=== GESTOR DE PRODUCTOS ===");

        List<Producto> inventario = List.of(
                new Producto("Teclado", 120.0, "tecnología"),
                new Producto("Camiseta", 25.0, "ropa"),
                new Producto("Raton", 60.0, "tecnología"),
                new Producto("Mesa", 150.0, "muebles")
        );

        FiltroProductos filtro = new FiltroProductos(inventario);

        // 1ª operación
        double precioFiltro = 50.0;
        Predicate<Producto> filtro1 = p -> p.precio() > precioFiltro;
        List<Producto> f_mas_50 = filtro.filtrar(filtro1);
        System.out.println("\nProductos con precio > " + patchEuros(precioFiltro) + ":");
        f_mas_50.forEach(p -> System.out.println(" - " + p.nombre() + ": " + patchEuros(p.precio())));

        // 2ª operación
        System.out.println("\nProductos con nombres en mayúsculas:");
        inventario.forEach(p -> System.out.println(" - " + p.nombre().toUpperCase()));

        // 3ª operación
        System.out.println("\nProductos ordenados por precio (descendente):");
        inventario.stream()
                .sorted(Comparator.comparingDouble(Producto::precio).reversed())
                .forEach(p -> System.out.println(" - " + p.nombre() + ": " + patchEuros(p.precio())));

        // 4ª operación
        /*
        * Crea al menos dos estrategias distintas usando lambdas:
        * Un descuento del 10% si el precio es mayor de 100€
        * Un descuento del 5% si el producto pertenece a la cateogría "tecnología".
        * */
        System.out.println("\nAplicando descuentos...");
        List<CalculadoraDescuento> descuentos = new ArrayList<CalculadoraDescuento>();
        //  Descuento del 10% a productos con precio > 100€
        CalculadoraDescuento descuento100 = p ->
                p.precio() > 100.0 ? p.precio() * 0.90 : p.precio();
        descuentos.add(descuento100);
        //  Descuento del 5% a productos con categoría "tecnología"
        CalculadoraDescuento descuentoTecno = p ->
                p.categoria().equals("tecnología") ? p.precio() * 0.95 : p.precio();
        descuentos.add(descuentoTecno);

        inventario.forEach(p ->
                System.out.println(" - " + p.nombre() + "(" + p.categoria() + "): "
                        + patchEuros(p.precio()) + " -> "
                        + patchEuros(AplicadorDescuentos.aplicaDescuentos(p, descuentos))));
    }
}
