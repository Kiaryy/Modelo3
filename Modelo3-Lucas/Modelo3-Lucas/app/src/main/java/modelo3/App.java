package modelo3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;



public class App {
    public static void main(String[] args) {
        Cliente cliente1 = Cliente.builder()
            .id(1L)
            .nombre("Miguel")
            .apellido("Sanches")
            .telefono("546454687")
            .email("migue.s@gmail.com")
            .fechaNacimiento(LocalDate.parse("2004-01-15"))
            .build();
        Cliente cliente2 = Cliente.builder()
            .id(2L)
            .nombre("Luis")
            .apellido("Suarez")
            .telefono("5683733841")
            .email("Luis.suss@gmail.com")
            .fechaNacimiento(LocalDate.parse("1986-03-05"))
            .build();
        Cliente cliente3 = Cliente.builder()
            .id(3L)
            .nombre("Juana")
            .apellido("Naravez")
            .telefono("2613009007")
            .email("juana.j.n@gmail.com")
            .fechaNacimiento(LocalDate.parse("2002-03-14"))
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
            .url("grande\\hawaiana")
            .build();
        
        Imagen imagen2 = Imagen.builder()
            .id(2L)
            .url("grande\\napolitana")
            .build();
        
        Imagen imagen3 = Imagen.builder()
            .id(3L)
            .url("grande\\muzza")
            .build();

        Imagen imagen4 = Imagen.builder()
            .id(4L)
            .url("chica\\hawaiana")
            .build();
        
        Imagen imagen5 = Imagen.builder()
            .id(5L)
            .url("chica\\napolitana")
            .build();

        Imagen imagen6 = Imagen.builder()
            .id(6L)
            .url("chica\\muzza")
            .build();
        
        Imagen imagen7 = Imagen.builder()
            .id(7L)
            .url("cerveza\\andes")
            .build();

        Imagen imagen8 = Imagen.builder()
            .id(8L)
            .url("cerveza\\quilmes")
            .build();
        
        Articulo articulo1 = Articulo.builder()
            .id(1L)
            .denominacion("Pizza Grande Hawaiana")
            .precioVenta(15D)
            .precioCompra(10D)
            .stockActual(20)
            .stockMaximo(40)
            .tiempoEstimadoMaximo(40)
            .unidadMedida(unidad1)
            .imagen(imagen1)
            .build();
        
        Articulo articulo2 = Articulo.builder()
            .id(2L)
            .denominacion("Pizza Chica Hawaiana")
            .precioVenta(10D)
            .precioCompra(5D)
            .stockActual(20)
            .stockMaximo(40)
            .tiempoEstimadoMaximo(20)
            .unidadMedida(unidad2)
            .imagen(imagen4)
            .build();
        
        Articulo articulo3 = Articulo.builder()
            .id(3L)
            .denominacion("Pizza Grande Napolitana")
            .precioVenta(20D)
            .precioCompra(15D)
            .stockActual(30)
            .stockMaximo(60)
            .tiempoEstimadoMaximo(40)
            .unidadMedida(unidad1)
            .imagen(imagen2)
            .build();
        
        Articulo articulo4 = Articulo.builder()
            .id(4L)
            .denominacion("Pizza Chica Napolitana")
            .precioVenta(15D)
            .precioCompra(10D)
            .stockActual(30)
            .stockMaximo(60)
            .tiempoEstimadoMaximo(20)
            .unidadMedida(unidad2)
            .imagen(imagen5)
            .build();
        
        Articulo articulo5 = Articulo.builder()
            .id(5L)
            .denominacion("Pizza Grande Muzza")
            .precioVenta(25D)
            .precioCompra(20D)
            .stockActual(35)
            .stockMaximo(50)
            .tiempoEstimadoMaximo(40)
            .unidadMedida(unidad1)
            .imagen(imagen3)
            .build();
        
        Articulo articulo6 = Articulo.builder()
            .id(6L)
            .denominacion("Pizza Chica Muzza")
            .precioVenta(25D)
            .precioCompra(20D)
            .stockActual(35)
            .stockMaximo(50)
            .tiempoEstimadoMaximo(20)
            .unidadMedida(unidad2)
            .imagen(imagen6)
            .build();
        
        Articulo articulo7 = Articulo.builder()
            .id(7L)
            .denominacion("Cerveza Andes")
            .precioVenta(20D)
            .precioCompra(15D)
            .stockActual(50)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(10)
            .unidadMedida(unidad3)
            .imagen(imagen7)
            .build();
        
        Articulo articulo8 = Articulo.builder()
            .id(8L)
            .denominacion("Cerveza Quilmes")
            .precioVenta(20D)
            .precioCompra(15D)
            .stockActual(50)
            .stockMaximo(100)
            .tiempoEstimadoMaximo(5)
            .unidadMedida(unidad3)
            .imagen(imagen8)
            .build();
        
        System.out.println("------Pedido Cliente 1-------");
        DetallePedido grande1 = DetallePedido.builder()
            .id(1L)
            .cantidad(1)
            .articulo(articulo1)
            .subTotal(articulo1.getPrecioVenta())
            .build();
        DetallePedido quilmes1 = DetallePedido.builder()
            .id(2L)
            .cantidad(1)
            .articulo(articulo8)
            .subTotal(articulo8.getPrecioVenta())
            .build();
        HashSet<DetallePedido> detalles1 = new HashSet<DetallePedido>();
        detalles1.add(grande1);
        detalles1.add(quilmes1);      
        Double total = 0D;
        Double totalCosto = 0D;
        for (DetallePedido detallePedido : detalles1) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }
        Pedido pedido1 = Pedido.builder()
            .id(1L)
            .horaEstimadaFinalizacion(LocalTime.parse("15:30:00"))
            .detalles(detalles1)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.ENVIADO)
            .tipoEnvio(Pedido.TipoEnvio.ESTANDAR)
            .formaPago(Pedido.FormaPago.TARJETA_DEBITO)
            .fechaPedido(LocalDate.parse("2024-09-02"))
            .build();
        
        System.out.println("El cliente " + cliente1.getNombre() + " " + cliente1.getApellido() + " a pedido: ");
        total = 0D;
        for (DetallePedido pedido : pedido1.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }
        System.out.println("Estado del pedido: " + pedido1.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido1.getHoraEstimadaFinalizacion());
        System.out.println("------Pedido Cliente 2-------");
        DetallePedido tresQuilmes = DetallePedido.builder()
            .id(3L)
            .cantidad(3)
            .articulo(articulo8)
            .subTotal(articulo8.getPrecioVenta())
            .build();
        
        DetallePedido hawaianaChica = DetallePedido.builder()
            .id(4L)
            .cantidad(1)
            .articulo(articulo2)
            .subTotal(articulo2.getPrecioVenta())
            .build();
        
        HashSet<DetallePedido> detalles2 = new HashSet<DetallePedido>();
        detalles2.add(tresQuilmes);
        detalles2.add(hawaianaChica);
        for (DetallePedido detallePedido : detalles2) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }
        Pedido pedido2 = Pedido.builder()
            .id(2L)
            .horaEstimadaFinalizacion(LocalTime.parse("17:55:45"))
            .detalles(detalles2)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.PROCESANDO)
            .tipoEnvio(Pedido.TipoEnvio.EXPRESO)
            .formaPago(Pedido.FormaPago.PAYPAL)
            .fechaPedido(LocalDate.parse("2024-09-06"))
            .build();
        
        System.out.println("El cliente " + cliente2.getNombre() + " " + cliente2.getApellido() + " a pedido: ");
        total = 0D;
        for (DetallePedido pedido : pedido2.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }
        System.out.println("Estado del pedido: " + pedido2.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido2.getHoraEstimadaFinalizacion());
        System.out.println("------Pedido Cliente 3-------");
        
        DetallePedido hawaianaGrande = DetallePedido.builder()
            .id(5L)
            .cantidad(1)
            .articulo(articulo1)
            .subTotal(articulo1.getPrecioVenta())
            .build();
        
        DetallePedido muzzaChica = DetallePedido.builder()
            .id(6L)
            .cantidad(1)
            .articulo(articulo6)
            .subTotal(articulo6.getPrecioVenta())
            .build();
        
        DetallePedido napoGrande = DetallePedido.builder()
            .id(7L)
            .cantidad(1)
            .articulo(articulo3)
            .subTotal(articulo3.getPrecioVenta())
            .build();
        
        DetallePedido dosAndes = DetallePedido.builder()
            .id(8L)
            .cantidad(2)
            .articulo(articulo7)
            .subTotal(articulo7.getPrecioVenta())
            .build();
        
        HashSet<DetallePedido> detalles3 = new HashSet<DetallePedido>();
        detalles3.add(hawaianaGrande);
        detalles3.add(muzzaChica);
        detalles3.add(napoGrande);
        detalles3.add(dosAndes);

        for (DetallePedido detallePedido : detalles3) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }
        Pedido pedido3 = Pedido.builder()
            .id(3L)
            .horaEstimadaFinalizacion(LocalTime.parse("13:55:45"))
            .detalles(detalles3)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.PENDIENTE)
            .tipoEnvio(Pedido.TipoEnvio.EXPRESO)
            .formaPago(Pedido.FormaPago.PAYPAL)
            .fechaPedido(LocalDate.parse("2024-09-06"))
            .build();

        System.out.println("El cliente " + cliente3.getNombre() + " " + cliente3.getApellido() + " a pedido: ");
        total = 0D;
        for (DetallePedido pedido : pedido3.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }
        System.out.println("Estado del pedido: " + pedido3.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido3.getHoraEstimadaFinalizacion());
        
        System.out.println("------Pedido Cliente 1-------");

        DetallePedido otraMuzzaChica = DetallePedido.builder()
            .id(9L)
            .cantidad(1)
            .articulo(articulo6)
            .subTotal(articulo6.getPrecioVenta())
            .build();
        
        DetallePedido unaAndes = DetallePedido.builder()
            .id(10L)
            .cantidad(1)
            .articulo(articulo7)
            .subTotal(articulo7.getPrecioVenta())
            .build();

        HashSet<DetallePedido> detalles4 = new HashSet<DetallePedido>();
        detalles4.add(otraMuzzaChica);
        detalles4.add(unaAndes);

        for (DetallePedido detallePedido : detalles4) {
            total += detallePedido.getArticulo().getPrecioVenta();
            totalCosto += detallePedido.getArticulo().getPrecioCompra();
        }

        Pedido pedido4 = Pedido.builder()
            .id(4L)
            .horaEstimadaFinalizacion(LocalTime.parse("15:36:25"))
            .detalles(detalles4)
            .total(total)
            .totalCosto(totalCosto)
            .estado(Pedido.Estado.PENDIENTE)
            .tipoEnvio(Pedido.TipoEnvio.EXPRESO)
            .formaPago(Pedido.FormaPago.PAYPAL)
            .fechaPedido(LocalDate.parse("2024-09-10"))
            .build();
        
        System.out.println("El cliente " + cliente1.getNombre() + " " + cliente1.getApellido() + " a pedido: ");
        total = 0D;
        for (DetallePedido pedido : pedido4.getDetalles()) {
            System.out.println(pedido.getArticulo().getDenominacion()+ "x" + pedido.getCantidad() + ": $" + pedido.getArticulo().getPrecioVenta() * pedido.getCantidad());
            total += pedido.getArticulo().getPrecioVenta() * pedido.getCantidad();
        }
        System.out.println("Estado del pedido: " + pedido4.getEstado());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Llegara aproximadamente a las: " + pedido4.getHoraEstimadaFinalizacion());
        System.out.println("-------Articulos del Local-------");
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
