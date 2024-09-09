package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

public class App {

    public static void main(String[] args) {

        Cliente cliente1 = Cliente.builder()
            .id(1L)
            .nombre("Juan")
            .apellido("Perez")
            .telefono("2616666666")
            .email("juanperez22@gmail.com")
            .fechaNacimiento(LocalDate.parse("1984-05-26"))
            .build();

        Cliente cliente2 = Cliente.builder()
            .id(2L)
            .nombre("Pepe")
            .apellido("Argento")
            .telefono("2615432112")
            .email("pepeargento@gmail.com")
            .fechaNacimiento(LocalDate.parse("1972-12-12"))
            .build();

        Cliente cliente3 = Cliente.builder()
            .id(3L)
            .nombre("Carlos")
            .apellido("Rodriguez")
            .telefono("2612345678")
            .email("carlosrodri@gmail.com")
            .fechaNacimiento(LocalDate.parse("1960-01-03"))
            .build();
        
        UnidadMedida unidad1 = UnidadMedida.builder()
            .id(1L)
            .denominacion("8 porciones")
            .build();
        
        UnidadMedida unidad2 = UnidadMedida.builder()
            .id(2L)
            .denominacion("4 porciones")
            .build();
        
        UnidadMedida unidad3 = UnidadMedida.builder()
            .id(3L)
            .denominacion("1 Litro")
            .build();
        
        Imagen imagen1 = Imagen.builder()
            .id(1L)
            .url("hawaiana_grande")
            .build();
        
        Imagen imagen2 = Imagen.builder()
            .id(2L)
            .url("napolitana_grande")
            .build();
        
        Imagen imagen3 = Imagen.builder()
            .id(3L)
            .url("muzzarella_grande")
            .build();

        Imagen imagen4 = Imagen.builder()
            .id(4L)
            .url("hawaiana_chica")
            .build();
        
        Imagen imagen5 = Imagen.builder()
            .id(5L)
            .url("napolitana_chica")
            .build();

        Imagen imagen6 = Imagen.builder()
            .id(6L)
            .url("muzzarella_chica")
            .build();
        
        Imagen imagen7 = Imagen.builder()
            .id(7L)
            .url("cerveza_andes")
            .build();

        Imagen imagen8 = Imagen.builder()
            .id(8L)
            .url("cerveza_quilmes")
            .build();
        
        Articulo articulo1 = Articulo.builder()
            .id(1L)
            .denominacion("Pizza Grande Hawaiana")
            .precioVenta(5000d)
            .precioCompra(3000d)
            .stockActual(56)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(30)
            .unidadMedida(unidad1)
            .imagen(imagen1)
            .build();
        
        Articulo articulo2 = Articulo.builder()
            .id(2L)
            .denominacion("Pizza Chica Hawaiana")
            .precioVenta(3500d)
            .precioCompra(2000d)
            .stockActual(91)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(20)
            .unidadMedida(unidad2)
            .imagen(imagen4)
            .build();
        
        Articulo articulo3 = Articulo.builder()
            .id(3L)
            .denominacion("Pizza Grande Napolitana")
            .precioVenta(5000d)
            .precioCompra(3000d)
            .stockActual(88)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(40)
            .unidadMedida(unidad1)
            .imagen(imagen2)
            .build();
        
        Articulo articulo4 = Articulo.builder()
            .id(4L)
            .denominacion("Pizza Chica Napolitana")
            .precioVenta(3500d)
            .precioCompra(2000d)
            .stockActual(45)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(30)
            .unidadMedida(unidad2)
            .imagen(imagen5)
            .build();
        
        Articulo articulo5 = Articulo.builder()
            .id(5L)
            .denominacion("Pizza Grande Muzza")
            .precioVenta(4500d)
            .precioCompra(3000)
            .stockActual(23)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(20)
            .unidadMedida(unidad1)
            .imagen(imagen3)
            .build();
        
        Articulo articulo6 = Articulo.builder()
            .id(6L)
            .denominacion("Pizza Chica Muzza")
            .precioVenta(3500d)
            .precioCompra(2700d)
            .stockActual(29)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(20)
            .unidadMedida(unidad2)
            .imagen(imagen6)
            .build();
        
        Articulo articulo7 = Articulo.builder()
            .id(7L)
            .denominacion("Cerveza Andes")
            .precioVenta(2000d)
            .precioCompra(1000d)
            .stockActual(51)
            .stockMaximo(200)
            .tiempoEstimadoMaximo(10)
            .unidadMedida(unidad3)
            .imagen(imagen7)
            .build();
        
        Articulo articulo8 = Articulo.builder()
            .id(8L)
            .denominacion("Cerveza Quilmes")
            .precioVenta(2000d)
            .precioCompra(1000d)
            .stockActual(75)
            .stockMaximo(200)
            .tiempoEstimadoMaximo(10)
            .unidadMedida(unidad3)
            .imagen(imagen8)
            .build();
        
        System.out.println("~~~~~~~~~~ Pedido Cliente 1 ~~~~~~~~~~");
        DetallePedido detallePedido1Pizza = DetallePedido.builder()
            .id(1L)
            .cantidad(1)
            .articulo(articulo1)
            .subTotal(articulo1.getPrecioVenta())
            .build();
        DetallePedido detallePedido1Quilmes = DetallePedido.builder()
            .id(2L)
            .cantidad(1)
            .articulo(articulo8)
            .subTotal(articulo8.getPrecioVenta())
            .build();

        HashSet<DetallePedido> detallesPedido1 = new HashSet<DetallePedido>();

        detallesPedido1.add(detallePedido1Pizza);
        detallesPedido1.add(detallePedido1Quilmes);      

        Double total = 0d;
        Double totalCosto = 0d;

        for (DetallePedido detallePedido : detallesPedido1) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }

        Pedido pedido1 = Pedido.builder()
            .id(1L)
            .horaEstimadaFinalizacion(LocalTime.parse("22:30:52"))
            .detalles(detallesPedido1)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.ENVIADO)
            .tipoEnvio(Pedido.TipoEnvio.ESTANDAR)
            .formaPago(Pedido.FormaPago.TARJETA_DEBITO)
            .fechaPedido(LocalDate.parse("2024-09-02"))
            .build();
        
        System.out.println("El cliente " + cliente1.getNombre() + " " + cliente1.getApellido() + " a pedido: ");

        total = 0d;

        for (DetallePedido pedido : pedido1.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }

        System.out.println("Estado del pedido: " + pedido1.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido1.getHoraEstimadaFinalizacion());
        
        System.out.println("~~~~~~~~~~ Pedido Cliente 2 ~~~~~~~~~~");
        
        DetallePedido detallePedido2Hawaiana = DetallePedido.builder()
            .id(4L)
            .cantidad(1)
            .articulo(articulo2)
            .subTotal(articulo2.getPrecioVenta())
            .build();

        DetallePedido detallePedido2Quilmes = DetallePedido.builder()
            .id(3L)
            .cantidad(3)
            .articulo(articulo8)
            .subTotal(articulo8.getPrecioVenta())
            .build();
        
        HashSet<DetallePedido> detallesPedido2 = new HashSet<DetallePedido>();

        detallesPedido2.add(detallePedido2Hawaiana);
        detallesPedido2.add(detallePedido2Quilmes);

        for (DetallePedido detallePedido : detallesPedido2) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }
        Pedido pedido2 = Pedido.builder()
            .id(2L)
            .horaEstimadaFinalizacion(LocalTime.parse("22:55:23"))
            .detalles(detallesPedido2)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.PROCESANDO)
            .tipoEnvio(Pedido.TipoEnvio.EXPRESO)
            .formaPago(Pedido.FormaPago.PAYPAL)
            .fechaPedido(LocalDate.parse("2024-09-02"))
            .build();
        
        System.out.println("El cliente " + cliente2.getNombre() + " " + cliente2.getApellido() + " a pedido: ");

        total = 0d;

        for (DetallePedido pedido : pedido2.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }

        System.out.println("Estado del pedido: " + pedido2.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido2.getHoraEstimadaFinalizacion());

        System.out.println("~~~~~~~~~~ Pedido Cliente 3 ~~~~~~~~~~");
        
        DetallePedido detallePedido3Hawaiana = DetallePedido.builder()
            .id(5L)
            .cantidad(1)
            .articulo(articulo1)
            .subTotal(articulo1.getPrecioVenta())
            .build();
        
        DetallePedido detallePedido3Muzza = DetallePedido.builder()
            .id(6L)
            .cantidad(1)
            .articulo(articulo6)
            .subTotal(articulo6.getPrecioVenta())
            .build();
        
        DetallePedido detallePedido3Napo = DetallePedido.builder()
            .id(7L)
            .cantidad(1)
            .articulo(articulo3)
            .subTotal(articulo3.getPrecioVenta())
            .build();
        
        DetallePedido detallePedido3Andes = DetallePedido.builder()
            .id(8L)
            .cantidad(2)
            .articulo(articulo7)
            .subTotal(articulo7.getPrecioVenta())
            .build();
        
        HashSet<DetallePedido> detallesPedido3 = new HashSet<DetallePedido>();

        detallesPedido3.add(detallePedido3Hawaiana);
        detallesPedido3.add(detallePedido3Muzza);
        detallesPedido3.add(detallePedido3Napo);
        detallesPedido3.add(detallePedido3Andes);

        for (DetallePedido detallePedido : detallesPedido3) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }

        Pedido pedido3 = Pedido.builder()
            .id(3L)
            .horaEstimadaFinalizacion(LocalTime.parse("23:05:24"))
            .detalles(detallesPedido3)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.PENDIENTE)
            .tipoEnvio(Pedido.TipoEnvio.EXPRESO)
            .formaPago(Pedido.FormaPago.PAYPAL)
            .fechaPedido(LocalDate.parse("2024-09-02"))
            .build();

        System.out.println("El cliente " + cliente3.getNombre() + " " + cliente3.getApellido() + " a pedido: ");

        total = 0d;

        for (DetallePedido pedido : pedido3.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }

        System.out.println("Estado del pedido: " + pedido3.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido3.getHoraEstimadaFinalizacion());
        
        System.out.println("~~~~~~~~~~ Pedido Cliente 1 ~~~~~~~~~~");

        DetallePedido detallePedido4Muzza = DetallePedido.builder()
            .id(9L)
            .cantidad(1)
            .articulo(articulo6)
            .subTotal(articulo6.getPrecioVenta())
            .build();
        
        DetallePedido detallePedido4Andes= DetallePedido.builder()
            .id(10L)
            .cantidad(1)
            .articulo(articulo7)
            .subTotal(articulo7.getPrecioVenta())
            .build();

        HashSet<DetallePedido> detallesPedido4 = new HashSet<DetallePedido>();
        detallesPedido4.add(detallePedido4Muzza);
        detallesPedido4.add(detallePedido4Andes);

        for (DetallePedido detallePedido : detallesPedido4) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }

        Pedido pedido4 = Pedido.builder()
            .id(4L)
            .horaEstimadaFinalizacion(LocalTime.parse("21:47:32"))
            .detalles(detallesPedido4)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.PENDIENTE)
            .tipoEnvio(Pedido.TipoEnvio.EXPRESO)
            .formaPago(Pedido.FormaPago.PAYPAL)
            .fechaPedido(LocalDate.parse("2024-09-07"))
            .build();
        
        System.out.println("El cliente " + cliente1.getNombre() + " " + cliente1.getApellido() + " a pedido: ");

        total = 0d;

        for (DetallePedido pedido : pedido4.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }

        System.out.println("Estado del pedido: " + pedido4.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido4.getHoraEstimadaFinalizacion());

        System.out.println("~~~~~~~~~~ Articulos del Local ~~~~~~~~~~");

        System.out.println(articulo1.getDenominacion());
        System.out.println(articulo2.getDenominacion());
        System.out.println(articulo3.getDenominacion());
        System.out.println(articulo4.getDenominacion());
        System.out.println(articulo5.getDenominacion());
        System.out.println(articulo6.getDenominacion());
        System.out.println(articulo7.getDenominacion());
        System.out.println(articulo8.getDenominacion());
    }
}
