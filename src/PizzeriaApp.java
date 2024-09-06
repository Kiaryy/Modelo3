import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class PizzeriaApp {

    public static void main(String[] args) {

        // Crear clientes
        Cliente cliente1 = new Cliente(1L, "Juan", "Perez", "123456789", "juan@example.com", LocalDate.of(1990, 5, 20));
        Cliente cliente2 = new Cliente(2L, "Maria", "Gomez", "987654321", "maria@example.com", LocalDate.of(1985, 7, 15));
        Cliente cliente3 = new Cliente(3L, "Carlos", "Diaz", "555123456", "carlos@example.com", LocalDate.of(1975, 11, 30));

        // Crear unidades de medida
        UnidadMedida porcion8 = new UnidadMedida(1L, "8 porciones");
        UnidadMedida porcion4 = new UnidadMedida(2L, "4 porciones");
        UnidadMedida litro1 = new UnidadMedida(3L, "1 litro");

        // Crear imagenes
        Imagenes imagen1 = new Imagenes(1L, "Pizza grande Hawaiana", "hawaiana_grande.jpg");
        Imagenes imagen2 = new Imagenes(2L, "Pizza grande Napolitana", "napolitana_grande.jpg");
        Imagenes imagen3 = new Imagenes(3L, "Pizza grande Muzza", "muzza_grande.jpg");
        Imagenes imagen4 = new Imagenes(4L, "Pizza chica Hawaiana", "hawaiana_chica.jpg");
        Imagenes imagen5 = new Imagenes(5L, "Pizza chica Napolitana", "napolitana_chica.jpg");
        Imagenes imagen6 = new Imagenes(6L, "Pizza chica Muzza", "muzza_chica.jpg");
        Imagenes imagen7 = new Imagenes(7L, "Cerveza Andes", "cerveza_andes.jpg");
        Imagenes imagen8 = new Imagenes(8L, "Cerveza Quilmes", "cerveza_quilmes.jpg");

        // Crear los Articulos y asociarlos con sus unidades de medida e imagenes
        Articulo pizzaGrandeHawaiana = new Articulo(1L, "Pizza grande Hawaiana", 1200.00, 800.00, 10, 20, 30, porcion8, imagen1);
        Articulo pizzaChicaHawaiana = new Articulo(2L, "Pizza chica Hawaiana", 800.00, 600.00, 15, 30, 20, porcion4, imagen4);
        Articulo pizzaGrandeNapolitana = new Articulo(3L, "Pizza grande Napolitana", 1100.00, 750.00, 8, 20, 30, porcion8, imagen2);
        Articulo pizzaChicaNapolitana = new Articulo(4L, "Pizza chica Napolitana", 750.00, 550.00, 20, 30, 20, porcion4, imagen5);
        Articulo pizzaGrandeMuzza = new Articulo(5L, "Pizza grande Muzza", 1000.00, 700.00, 12, 25, 30, porcion8, imagen3);
        Articulo pizzaChicaMuzza = new Articulo(6L, "Pizza chica Muzza", 700.00, 500.00, 18, 30, 20, porcion4, imagen6);
        Articulo cervezaAndes = new Articulo(7L, "Cerveza Andes", 350.00, 200.00, 50, 100, 5, litro1, imagen7);
        Articulo cervezaQuilmes = new Articulo(8L, "Cerveza Quilmes", 300.00, 180.00, 60, 120, 5, litro1, imagen8);

        // Crear ordenes y agregar detalles
        // Variable para contar las veces que el Cliente 1 compró en el local
        int comprasCliente1 = 0;

        // Cliente 1 (primer pedido)
        Pedido pedido1 = new Pedido(1L, LocalTime.now().plusMinutes(30), 0.0, 0.0, Estado.PENDIENTE, TipoEnvio.DELIVERY, FormaPago.EFECTIVO, LocalDate.now(), cliente1);
        DetallePedido detalle1_1 = new DetallePedido(1L, 1, pizzaGrandeHawaiana.getPrecioVenta(), pizzaGrandeHawaiana);
        DetallePedido detalle1_2 = new DetallePedido(2L, 1, cervezaQuilmes.getPrecioVenta(), cervezaQuilmes);
        pedido1.getDetalles().add(detalle1_1);
        pedido1.getDetalles().add(detalle1_2);
        pedido1.setTotal(detalle1_1.getSubTotal() + detalle1_2.getSubTotal());
        comprasCliente1++; // Incrementa el contador

        // Mostrar primer pedido del Cliente 1
        System.out.println("Pedido 1 del cliente 1:");
        displayPedido(pedido1);

        // Cliente 2
        Pedido pedido2 = new Pedido(2L, LocalTime.now().plusMinutes(25), 0.0, 0.0, Estado.PENDIENTE, TipoEnvio.PICKUP, FormaPago.TARJETA, LocalDate.now(), cliente2);
        DetallePedido detalle2_1 = new DetallePedido(3L, 3, cervezaQuilmes.getPrecioVenta() * 3, cervezaQuilmes);
        DetallePedido detalle2_2 = new DetallePedido(4L, 1, pizzaChicaHawaiana.getPrecioVenta(), pizzaChicaHawaiana);
        pedido2.getDetalles().add(detalle2_1);
        pedido2.getDetalles().add(detalle2_2);
        pedido2.setTotal(detalle2_1.getSubTotal() + detalle2_2.getSubTotal());

        // Mostrar pedido del Cliente 2
        System.out.println("\nPedido del cliente 2:");
        displayPedido(pedido2);

        // Cliente 3
        Pedido pedido3 = new Pedido(3L, LocalTime.now().plusMinutes(35), 0.0, 0.0, Estado.CONFIRMADO, TipoEnvio.DELIVERY, FormaPago.TRANSFERENCIA, LocalDate.now(), cliente3);
        DetallePedido detalle3_1 = new DetallePedido(5L, 1, pizzaGrandeHawaiana.getPrecioVenta(), pizzaGrandeHawaiana);
        DetallePedido detalle3_2 = new DetallePedido(6L, 1, pizzaChicaMuzza.getPrecioVenta(), pizzaChicaMuzza);
        DetallePedido detalle3_3 = new DetallePedido(7L, 1, pizzaGrandeNapolitana.getPrecioVenta(), pizzaGrandeNapolitana);
        DetallePedido detalle3_4 = new DetallePedido(8L, 2, cervezaAndes.getPrecioVenta() * 2, cervezaAndes);
        pedido3.getDetalles().add(detalle3_1);
        pedido3.getDetalles().add(detalle3_2);
        pedido3.getDetalles().add(detalle3_3);
        pedido3.getDetalles().add(detalle3_4);
        pedido3.setTotal(detalle3_1.getSubTotal() + detalle3_2.getSubTotal() + detalle3_3.getSubTotal() + detalle3_4.getSubTotal());

        // Mostrar pedido del Cliente 3
        System.out.println("\nPedido del cliente 3:");
        displayPedido(pedido3);

        // Cliente 1 (segundo pedido)
        Pedido pedido4 = new Pedido(4L, LocalTime.now().plusMinutes(20), 0.0, 0.0, Estado.PENDIENTE, TipoEnvio.PICKUP, FormaPago.TARJETA, LocalDate.now().plusDays(1), cliente1);
        DetallePedido detalle4_1 = new DetallePedido(9L, 1, pizzaChicaMuzza.getPrecioVenta(), pizzaChicaMuzza);
        DetallePedido detalle4_2 = new DetallePedido(10L, 1, cervezaAndes.getPrecioVenta(), cervezaAndes);
        pedido4.getDetalles().add(detalle4_1);
        pedido4.getDetalles().add(detalle4_2);
        pedido4.setTotal(detalle4_1.getSubTotal() + detalle4_2.getSubTotal());
        comprasCliente1++; // Incrementa el contador

        // Mostrar segundo pedido del Cliente 1
        System.out.println("\nPedido 2 del cliente 1:");
        displayPedido(pedido4);

        // Mostrar la cantidad de veces que compró el Cliente 1
        System.out.println("\nCompras registradas del cliente 1: " + comprasCliente1);

        // Mostrar todos los articulos
        System.out.println("\nArtículos comercializados por el negocio:");
        Set<Articulo> articulos = new HashSet<>();
        articulos.add(pizzaGrandeHawaiana);
        articulos.add(pizzaChicaHawaiana);
        articulos.add(pizzaGrandeNapolitana);
        articulos.add(pizzaChicaNapolitana);
        articulos.add(pizzaGrandeMuzza);
        articulos.add(pizzaChicaMuzza);
        articulos.add(cervezaAndes);
        articulos.add(cervezaQuilmes);
        for (Articulo articulo : articulos) {
            System.out.println(articulo.getDenominacion() + " - Precio: $" + articulo.getPrecioVenta());
        }
    }

    public static void displayPedido(Pedido pedido) {

        System.out.println("Fecha del pedido: " + pedido.getFechaPedido());
        System.out.println("Cliente: " + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido());
        System.out.println("Detalles:");
        for (DetallePedido detalle : pedido.getDetalles()) {
            System.out.println("- " + detalle.getArticulo().getDenominacion() + ": Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubTotal());
        }
        System.out.println("Total a pagar: $" + pedido.getTotal());
    }
}
