# JUnit
Pruebas Unitarias

# Documentación del Módulo de Compras

## Descripción del problema
Este sistema se encarga de calcular el subtotal de las compras en línea, validar si una transacción es legítima, aplicar los descuentos correspondientes según las reglas de negocio y obtener el precio final a pagar. Verificar estos componentes mediante pruebas es indispensable para evitar errores financieros que perjudiquen la confianza del cliente o los ingresos del negocio.

## Reglas de negocio
* **Cálculo de subtotal:** Multiplica el precio unitario del producto por la cantidad solicitada.
* **Validación de compra:** Una compra se considera válida únicamente si tanto el precio como la cantidad son estrictamente mayores a cero.
* **Cálculo de descuento:** Se otorga un 10% de descuento cuando el subtotal es igual o superior a $1,000.00 MXN. De lo contrario, no se aplica descuento ($0.0).
* **Precio final:** Se obtiene restando el descuento calculado al subtotal de la compra, reutilizando la lógica del método de descuento.

## Casos de prueba

| Datos de Entrada | Resultado Esperado | Resultado Obtenido | Descripción / Propósito |
| :--- | :--- | :--- | :--- |
| Precio: $100, Cantidad: 3 | 300.0 | 300.0 | Comprueba el cálculo del subtotal con valores estándar. |
| Precio: $50, Cantidad: 1 | 50.0 | 50.0 | Verifica el comportamiento del subtotal con una sola unidad. |
| Precio: $0, Cantidad: 5 | 0.0 | 0.0 | Comprueba el subtotal cuando el precio del producto es cero. |
| Precio: $100, Cantidad: 2 | true | true | Valida una compra exitosa con valores positivos. |
| Precio: $0, Cantidad: 2 | false | false | Rechaza la compra si el precio es igual a cero. |
| Precio: $100, Cantidad: 0 | false | false | Rechaza la compra si la cantidad de artículos es cero. |
| Precio: -$10, Cantidad: 2 | false | false | Rechaza transacciones con precios negativos. |
| Subtotal: $999.99 | 0.0 | 0.0 | Comprueba el límite inferior (justo debajo del umbral de descuento). |
| Subtotal: $1,000.00 | 100.0 | 100.0 | Valida la regla exacta en el límite de $1,000.00. |
| Subtotal: $1,500.00 | 150.0 | 150.0 | Verifica el cálculo de descuento para montos superiores al umbral. |
| Subtotal: $500.00 | 500.00 | 500.00 | Calcula el precio final de una compra sin descuento. |
| Subtotal: $1,000.00 | 900.00 | 900.00 | Calcula el precio final aplicando correctamente el descuento límite. |

## Resultados de ejecución
* **Pruebas totales ejecutadas:** 12
* **Pruebas exitosas (Passed):** 12
* **Pruebas fallidas (Failed):** 0

## Errores que se pueden prevenir
1. **Uso incorrecto de operadores relacionales (`>` en lugar de `>=`):** Previene fallas en los límites, asegurando que los clientes que alcancen exactamente los $1,000 obtengan su descuento.
2. **Procesamiento de montos o cantidades inválidas:** Evita que el sistema acepte valores negativos o nulos que corrompan los cálculos contables.

## Conclusión
Las pruebas unitarias son fundamentales para asegurar la robustez de las aplicaciones de comercio electrónico. Permiten validar de forma aislada y automatizada que la lógica financiera funcione correctamente ante escenarios estándar y casos límite, garantizando la precisión en las transacciones para cada usuario.
