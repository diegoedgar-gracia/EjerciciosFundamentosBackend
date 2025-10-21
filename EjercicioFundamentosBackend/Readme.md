#  Ejercicio práctico – Gestor de Productos y Descuentos

##  Objetivo

Diseñar una aplicación en Java que modele un sistema básico de productos, aplique descuentos dinámicos y permita procesarlos mediante streams y lambdas, utilizando buenas prácticas de programación orientada a objetos y principios de diseño (SOLID).

---

##  Requisitos

### 1. Modelado de producto

- Crea un `record Producto` con los siguientes atributos:
    - `String nombre`
    - `double precio`
    - `String categoria`
- Añade validaciones en el constructor compacto:
    - El nombre no puede estar vacío o nulo.
    - El precio debe ser mayor que 0.

---

###  Aplicación de descuentos (Programación funcional)

- Define una **interfaz funcional** `CalculadoraDescuento` que reciba un producto y devuelva un precio con descuento.
- Crea dos descuentos como expresiones `lambda`:
    -  10% si el producto cuesta más de 100€.
    -  5% si el producto pertenece a la categoría `"tecnología"`.
- Crea una clase `AplicadorDescuentos` que reciba una lista de estrategias y devuelva el precio final aplicando todas secuencialmente.

---

### 3. Procesamiento con Streams

Usando una lista inmutable de productos (`List.of(...)`), implementa métodos que:

-  Filtren productos con precio > 50€.
-  Devuelvan una nueva lista con nombres en mayúsculas.
-  Ordenen los productos por precio descendente.
-  Impriman el precio final tras aplicar descuentos.

---

### 4. Principios de diseño (Bloque 2)

- Aplica al menos **3 principios SOLID**:
    - SRP: separación clara de responsabilidades.
    - OCP: el sistema debe ser extensible sin modificar código existente.
    - DIP: las clases dependen de abstracciones, no implementaciones concretas.

---

##  Pistas

- Usa `record` para modelar los datos de forma inmutable.
- Usa lambdas para implementar las reglas de descuento.
- Evita estructuras tradicionales como `for` o `if` innecesarios.
- Usa `stream()`, `map()`, `filter()`, `sorted()`, `forEach()` para trabajar con colecciones.

---

##  Extensiones (Opcional)

- Escribe tests unitarios con JUnit para verificar las estrategias de descuento y los métodos de filtrado.
- Añade nuevas estrategias de descuento y prueba que el sistema siga funcionando sin modificar código anterior.
- Usa `Function<T, R>` o `Predicate<T>` si quieres enriquecer la funcionalidad de forma funcional.

---

##  Entregable

Un proyecto Java estructurado, con las siguientes clases:

- `Producto.java` (record)
- `CalculadoraDescuento.java` (interfaz funcional)
- `AplicadorDescuentos.java`
- `FiltroProductos.java`
- `GestorProductos.java` con el método `main()`

---