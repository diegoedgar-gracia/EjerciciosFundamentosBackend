package org.scalian.ejerciciopropuesto;

public record Producto(String nombre, double precio, String categoria) {

    public Producto {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("No se permite que el nombre esté vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("No se permiten precios negativos o iguales a 0");
        }
    }

}
