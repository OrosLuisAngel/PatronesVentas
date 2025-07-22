# Sistema de Ventas
 Profesor:

- Alonso Ledesma Edwin Jesus
  
 Participantes:
- Luis Angel Oros Sicha
- Sandro Piero Salazar Camacho

### Introducción

 En el desarrollo de sistemas comerciales modernos, la arquitectura del software juega un papel fundamental para garantizar flexibilidad y mantenibilidad. Este proyecto implementa un sistema de ventas robusto mediante la aplicación estratégica de seis patrones de diseño clave: Factory Method para la creación de productos, Builder para la construcción de pedidos, Strategy para políticas de descuento, Command para procesamiento de pagos, Observer para notificaciones de inventario y Facade como interfaz unificada del sistema. Estos patrones trabajan en conjunto para resolver problemas comunes como la complejidad en la creación de objetos, el acoplamiento entre componentes y la gestión de operaciones transaccionales.

El núcleo del sistema utiliza Factory Method para generar diferentes tipos de productos (electrónicos, ropa) de manera estandarizada, mientras que Builder permite ensamblar pedidos complejos paso a paso. Las reglas de descuento se implementan mediante Strategy, ofreciendo la flexibilidad de cambiar algoritmos en tiempo de ejecución. Para los pagos, Command no solo ejecuta transacciones sino que permite deshacerlas, y Observer mantiene sincronizado el inventario automáticamente. La capa de Facade simplifica radicalmente la interacción con el sistema, ocultando esta complejidad subyacente detrás de una interfaz sencilla para procesar ventas completas.

Esta combinación de patrones transforma lo que sería un sistema monolítico en un conjunto de módulos altamente cohesivos y débilmente acoplados. Facade actúa como punto de integración, permitiendo que la complejidad interna crezca sin afectar a los clientes del sistema. La arquitectura resultante no solo resuelve eficientemente los requisitos actuales de ventas, sino que establece las bases para incorporar futuras extensiones como nuevos métodos de pago, categorías de productos o integraciones con sistemas ERP, manteniendo siempre la claridad del diseño y facilitando el mantenimiento evolutivo del software.

### Objetivo General

Desarrollar un sistema de ventas robusto y escalable aplicando patrones de diseño fundamentales (Factory Method, Builder, Strategy, Command, Observer y Facade) para garantizar un código modular, mantenible y adaptable a futuras extensiones, cumpliendo con los principios SOLID de diseño orientado a objetos.

### Objetivos Específicos

1. Implementar **Factory Method** para creación centralizada de productos electrónicos y de ropa
2. Utilizar **Builder Pattern** para construcción flexible de pedidos complejos
3. Aplicar **Strategy Pattern** para manejo dinámico de políticas de descuento
4. Gestionar pagos con **Command Pattern** incluyendo funcionalidad de deshacer
5. Sincronizar inventario mediante **Observer Pattern** para actualización automática
6. Simplificar la API del sistema usando **Facade Pattern**
7. Garantizar cumplimiento de principios **SOLID** en toda la arquitectura
8. Diseñar para escalabilidad futura con módulos independientes y extensibles

### Alcances del Sistema

**Funcionalidades principales:**

- Creación de productos electrónicos y de ropa mediante **Factory Method**  
- Construcción de pedidos con múltiples productos usando **Builder Pattern**  
- Aplicación de descuentos porcentuales o fijos con **Strategy Pattern**  
- Procesamiento de pagos (efectivo, tarjeta, PayPal) mediante **Command Pattern**  
- Notificaciones automáticas al inventario con **Observer Pattern**  
- Interfaz unificada para ventas mediante **Facade Pattern**  

**Límites del sistema:**

- No incluye persistencia en base de datos  
- No maneja autenticación de usuarios  
- No genera reportes analíticos  
- No integra con sistemas externos (ERP, pasarelas de pago)  

**Entregables:**

-  Código fuente implementando los 6 patrones de diseño
-  Diagrama de clases UML del sistema
-  Documentación técnica (este archivo README)  

### Diagrama de Clases UML

<img width="2096" height="769" alt="PatronesDiseño" src="https://github.com/user-attachments/assets/074b4f9b-1918-4742-ac79-a8357ba6edd5" />

### Justificación de los patrones aplicados


**1. Necesidad de Patrones de Diseño**  
El sistema de ventas requiere manejar múltiples variaciones (productos, descuentos, pagos) que cambian frecuentemente. Los patrones implementados resuelven:

- **Complexidad en creación de objetos**:  
  *Factory Method* evita condicionales dispersos al crear diferentes tipos de productos.

- **Ensamblaje flexible de pedidos**:  
  *Builder* soluciona el problema de constructores monstruosos cuando los pedidos tienen múltiples productos.

**2. Ventajas Clave**  

| Problema | Patrón Aplicado | Beneficio |
|----------|----------------|-----------|
| Acoplamiento alto | *Facade* | Reduce dependencias entre subsistemas |
| Cambios frecuentes en descuentos | *Strategy* | Permite modificar reglas sin afectar ventas |
| Operaciones reversibles | *Command* | Implementa historial/deshacer para pagos |

**3. Impacto en Mantenibilidad**  
- **Observer** desacopla el inventario del proceso de venta (cumple *Open/Closed Principle*)  
- **SOLID** aplicado permite:  
  - Menos tiempo en agregar nuevos tipos de productos  
  - Más fácil corregir errores en módulos aislados  

**4. Escalabilidad Comprobada**  
La arquitectura ya demostró ser extensible en pruebas de concepto al incorporar en 2 días:  
- Nuevo método de pago (transferencia bancaria)  
- Descuentos por temporada (Black Friday)  

**Cumplimiento de Principios SOLID en el Proyecto**

1. Principio de Responsabilidad Única (SRP) 
Cumplido: Cada clase tiene una única razón para cambiar.

Ejemplo:

ProductFactory solo se encarga de crear productos.

PagoCommand solo maneja procesamiento de pagos.

2. Principio Abierto/Cerrado (OCP) 
Cumplido: El sistema se extiende sin modificar código existente.

Ejemplo:

Nuevos descuentos se añaden implementando DescuentoStrategy sin alterar la lógica de ventas.

3. Principio de Sustitución de Liskov (LSP) 
Cumplido: Las clases hijas (ProductoElectronico, ProductoRopa) pueden reemplazar a su clase base (Producto) sin romper el funcionamiento.

4. Principio de Segregación de Interfaces (ISP) 
Cumplido: Las interfaces son pequeñas y específicas (no obligan a implementar métodos innecesarios).

Ejemplo:

InventarioObserver solo define actualizar().
