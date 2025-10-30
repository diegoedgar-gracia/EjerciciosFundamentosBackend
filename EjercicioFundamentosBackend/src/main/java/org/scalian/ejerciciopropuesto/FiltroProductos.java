package org.scalian.ejerciciopropuesto;

import java.util.List;
import java.util.function.Predicate;

public class FiltroProductos {
    private final List<Producto> productos;

    public FiltroProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> filtrar(Predicate<Producto> logicaFiltro) {
        return productos.stream()
                .filter(logicaFiltro)
                .toList();
    }
}
