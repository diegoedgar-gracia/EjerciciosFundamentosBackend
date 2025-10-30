package org.scalian.ejerciciopropuesto;

import java.util.List;

public class AplicadorDescuentos {
    public static double aplicaDescuento(Producto p, CalculadoraDescuento c) {
        return c.descontar(p);
    }
    public static double aplicaDescuentos(Producto p, List<CalculadoraDescuento> cL) {
        if (cL.isEmpty()) return p.precio();
        return cL.get(0)
                .descontar(new Producto(p.nombre(),
                        aplicaDescuentos(p, cL.subList(1, cL.size())),
                        p.categoria()));
    }
}
