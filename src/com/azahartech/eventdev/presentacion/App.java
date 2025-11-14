package com.azahartech.eventdev.presentacion.old;

import com.azahartech.eventdev.modelo.DetallePago;
import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.modelo.Recinto;
import com.azahartech.eventdev.modelo.Usuario;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;


/**
 * @author Junfeng
 * @version 1.0
 *
 * Esta clase sirve para pedirle al usuario los datos del evento.
 */
public class App {
    /**
     *  El metodo main ejecuta la interfaz.
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Opcion Usuario
        int opcion = -1;
        do {
            System.out.println("-- MENÚ DE EVENTDEV --");
            System.out.println("-- 0. Iniciar session --");
            System.out.println("-- 1. Calculadora Precio de Entrada --");
            System.out.println("-- 2. Verificar Aforo --");
            System.out.println("-- 3. Salir --");
            System.out.print("Por favor, selecciona una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 0:
                        //Login
                        simularLogin();
                        break;
                    case 1:
                        ejecutarLogicaDePrecio();
                        break;

                    case 2:
                        System.out.println("Iniciando verificación de aforo...");
                        break;

                    case 3:
                        System.out.println("Saliendo de la plicación. ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Debes introducir un numero.");
                scanner.next();
            }

        } while (opcion != 3);
        scanner.close();
    }


    /**
     * Metodo para simular un login.
     */
    private static void simularLogin(){
        Scanner scanner = new Scanner(System.in);
        final String CONTRASEÑA_CORRECTA = "AzaharTech2024";
        String contraseña;
        do {
            System.out.print("Introduzca la contraseña: ");
            contraseña= scanner.nextLine();
            assert !contraseña.isEmpty() : "Error de logica: La contraseña tiene que tener 1 o mas caracteres";
            if (!contraseña.equals(CONTRASEÑA_CORRECTA)){
                System.out.println("Contraseña incorrecta.");
            }else{
                System.out.println("Acceso concedido.");
            }
        }while (!contraseña.equals(CONTRASEÑA_CORRECTA));
    }


    /**
     * Metodo que ejecuta la logica del evento.
     */
    private static void ejecutarLogicaDePrecio() {
        Scanner scanner = new Scanner(System.in);

        // Optener la posicion del guion para luego separalo
        //Constantes
        final Locale ESPAÑOL = new Locale("es", "ES");
        final NumberFormat FORMATO_MONEDA = NumberFormat.getCurrencyInstance();
        final DecimalFormat DF_FORMATO_DECIMAL = new DecimalFormat("#.##");
        final DecimalFormat DF_PORCENTAJE = new DecimalFormat("#.##%");
        final DecimalFormat DF_ID = new DecimalFormat("000000");

        //Recinto
        Recinto recinto;
        String recintoNombre;
        String recintoDirec;
        int recintoAforo;

        //Evento
        Evento evento;
        String eventoNombre;
        double eventoPrecioBase;
        double eventoBeneficio;

        //Usuario
        Usuario usuario;
        String usuarioNombre;
        String usuarioEmail;
        int usuarioEdad;
        boolean usuarioEsEstudiante;

        //Pago
        DetallePago detallePago;
        String pagoTipoTarjeta;
        String pagoNumeroTarjeta;

        //Compra
        int compraCantidad;
        boolean compraValida = true;

        //Valoracion
        int valorPuntuacion;
        String valorComentario;

        //Validacion
        boolean validacionNombreEvento;
        boolean validacionEmail;
        boolean validacionTarjeta;
        boolean valicadionCantidad;
        boolean validacionAforo;
        boolean validacióPuntuacion;
        boolean validacionComentarioVacio;

        //Reserva
        String codigoReserva;
        String estado;
        String ciudad;
        String anio;
        String serial;

        //Fechas
        int año;
        int mes;
        int dia;
        LocalDate eventoFecha;
        LocalDate fechaLimiteDevolucion;
        LocalDate fechaInicioVenta;
        LocalDate fechaEnvioRecordatorio;
        LocalDate fechaActual = LocalDate.now();
        String estadoDelEvento;

        //Posicion de los guiones
        int guion1;
        int guion2;
        int guion3;

        //Fecha
        String nombreDelDia;
        String nombreDelMes;
        int diaDelAño;
        boolean esAñoBisiesto;

        // Random
        int idCompra;
        double porcentajeDeDescuento;
        int fila;
        int asiento;

        // Math
        int numeroSalidasRecinto;
        double radioPersona;

        // Calcular diagonal
        double largo;
        double ancho;

        // Subtotal
        //double subtotal;
        double eventoDescuento;
        String eventoDescuentoMensaje;
        double eventoSuplemento;
        String eventoSuplementoMensaje;
        double eventoPrecioFinal;

        // UUID
        UUID IdEvento;
        UUID idCompraUUID;


        // Formato
        String eventoPrecioFormateado;
        String eventoBeneficioFormateado;
        String eventoPrecioFinalFormateado;
        String porcentajeDeDescuentoFormateado;
        String eventoSubTotalFormateado;
        String idCompraForamateado;


        // Pedir datos
        // Datos del recinto
        System.out.println("Dime el nombre del recinto");
        recintoNombre = scanner.nextLine().strip();
        recintoNombre = recintoNombre.substring(0, 1).toUpperCase() + recintoNombre.substring(1).toLowerCase();

        System.out.println("Dime la direccion del recinto");
        recintoDirec = scanner.nextLine().strip();
        recintoDirec = recintoDirec.substring(0, 1).toUpperCase() + recintoDirec.substring(1).toLowerCase();

        System.out.println("Dime el aforo del recinto");
        recintoAforo = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        // Datos del Evento
        System.out.println("Dime el nombre del evento");
        eventoNombre = scanner.nextLine().strip();
        eventoNombre = eventoNombre.substring(0, 1).toUpperCase() + eventoNombre.substring(1).toLowerCase();


        System.out.println("Dime la precio base del evento");
        eventoPrecioBase = scanner.nextDouble();
        scanner.nextLine();

        assert eventoPrecioBase >= 0 : "Error de lógica: el precio base no puede ser negativo.";

        System.out.println("Dime el beneficio del evento");
        eventoBeneficio = scanner.nextDouble();
        scanner.nextLine();

        System.out.println();

        // Datos del usuario
        System.out.println("Dime el nombre del usuario");
        usuarioNombre = scanner.nextLine().strip();
        usuarioNombre = usuarioNombre.substring(0, 1).toUpperCase() + usuarioNombre.substring(1).toLowerCase();

        System.out.println("Dime la email del usuario");
        usuarioEmail = scanner.nextLine().strip().toLowerCase();

        System.out.println("Dime la edad del usuario");
        usuarioEdad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("El usuario es estudiante. (si o no. Por defecto: no).");
        usuarioEsEstudiante = scanner.nextLine().strip().toLowerCase() == "si";

        System.out.println();

        // Datos del tarjeta
        System.out.println("Dime el tipo de la tarjeta");
        pagoTipoTarjeta = scanner.nextLine().strip().toLowerCase();

        System.out.println("Dime la numero de la tarjeta");
        pagoNumeroTarjeta = scanner.nextLine().strip().toLowerCase();


        System.out.println();

        // Datos de la cantidad
        do {
            System.out.println("Dime la cantidad a comprar");
            compraCantidad = scanner.nextInt();
            scanner.nextLine();

            if (compraCantidad <= 0){
                System.out.println("La cantidad tiene que ser mayor de 0.");
            }
        } while (compraCantidad <= 0);

        System.out.println();

        // Datos del Valoracion
        System.out.println("Dime la puntacion de la valoracion (1 - 5)");
        valorPuntuacion = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Dime el comentario de la valoracion");
        valorComentario = scanner.nextLine().strip();


        System.out.println();

        System.out.println("Dime el codigo de reserva. Ejemplos: CONFIRMADO-MAD-2024-12345");
        codigoReserva = scanner.nextLine();

        System.out.println();

        System.out.print("Dime un año: ");
        año = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Dime un mes: ");
        mes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Dime un dia: ");
        dia = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        System.out.println("Dime el numero de salidas: ");
        numeroSalidasRecinto = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        System.out.print("Dime el largo: ");
        largo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Dime el ancho: ");
        ancho = scanner.nextInt();
        scanner.nextLine();

        System.out.println();


        //Validaciones
        validacionNombreEvento = eventoNombre.length() >= 5;
        validacionEmail = usuarioEmail.indexOf("@") >= 1;
        validacionTarjeta = pagoNumeroTarjeta.length() == 16;
        valicadionCantidad = compraCantidad > 0;
        validacionAforo = compraCantidad < recintoAforo;
        validacióPuntuacion = valorPuntuacion >= 1 && valorPuntuacion <= 5;
        validacionComentarioVacio = !valorComentario.isEmpty();

        //Fecha
        eventoFecha = LocalDate.of(año, mes, dia);


        compraValida = !eventoFecha.isBefore(fechaActual) && valicadionCantidad && validacionAforo;


        if (compraValida) {

            recinto = new Recinto(recintoNombre, recintoDirec, recintoAforo);
            evento = new Evento(eventoNombre, eventoFecha, recinto);

            usuario = new Usuario(usuarioNombre, usuarioEmail);
            detallePago = new DetallePago(pagoTipoTarjeta, pagoNumeroTarjeta);


            guion1 = codigoReserva.indexOf("-");
            guion2 = codigoReserva.indexOf("-", guion1 + 1);
            guion3 = codigoReserva.indexOf("-", guion2 + 1);

            // Obtener las palabras separandolo por "-"
            estado = codigoReserva.substring(0, guion1);
            ciudad = codigoReserva.substring(guion1 + 1, guion2);
            anio = codigoReserva.substring(guion2 + 1, guion3);
            serial = codigoReserva.substring(guion3 + 1);

            // Obtener instanciar los objetos de LocalDate

            // Obtener valores de eventoFecha
            nombreDelDia = eventoFecha.getDayOfWeek().getDisplayName(TextStyle.FULL, ESPAÑOL).toUpperCase();
            nombreDelMes = eventoFecha.getMonth().getDisplayName(TextStyle.FULL, ESPAÑOL).toUpperCase();
            diaDelAño = eventoFecha.getDayOfYear();
            esAñoBisiesto = eventoFecha.isLeapYear();
            fechaLimiteDevolucion = eventoFecha.minusDays(7);
            fechaInicioVenta = eventoFecha.minusMonths(3);
            fechaEnvioRecordatorio = eventoFecha.minusDays(2);


            // Generar variables con numeros aleatorios
            idCompra = (int) (100000 + Math.random() * 900000);
            porcentajeDeDescuento = (double) Math.round((0.05 + Math.random() * (0.2 - 0.05)) * 100) / 100;
            fila = (int) (1 + Math.random() * 25);
            asiento = (int) (1 + Math.random() * 40);

            // Calcular el ratio de personas por salidas
            radioPersona = (double) Math.round(((double) recintoAforo / numeroSalidasRecinto) * 100) / 100;

            // Calcular los precios
            eventoPrecioFinal = eventoPrecioBase * compraCantidad;
            //eventoPrecioFinal = subtotal * (1 - porcentajeDeDescuento);

            // Aplicar descuento
            if (usuarioEdad < 12) {
                eventoDescuento = 0.2;//Descuento de un 50%
                eventoDescuentoMensaje = "Se ha aplicado el descuento del 50% por ser menor de 12 años.";

            } else if (usuarioEdad >= 65) {
                eventoDescuento = 0.3;//Descuento de un 30%
                eventoDescuentoMensaje = "Se ha aplicado el descuento del 30% por ser mayor de 65 años.";

            } else if (usuarioEsEstudiante) {
                eventoDescuento = 0.2;//Descuento de un 20%
                eventoDescuentoMensaje = "Se ha aplicado el descuento del 20% por ser estudiante.";

            } else {
                eventoDescuento = 0;
                eventoDescuentoMensaje = "No se ha aplicado ningun descuento";
            }
            eventoDescuentoMensaje = eventoDescuentoMensaje + "\n";
            eventoPrecioFinal *= 1 - eventoDescuento;

            //Aplicar suplemento
            if (eventoFecha.getDayOfWeek().getValue() == 6 || eventoFecha.getDayOfWeek().getValue() == 7) {
                if (eventoPrecioBase > 100) {
                    eventoSuplemento = 20;
                } else {
                    eventoSuplemento = 10;
                }
                eventoSuplementoMensaje = String.format("se ha añadido un suplemento por ser fin de semana de: %d", eventoSuplemento);
            } else {
                eventoSuplemento = 0;
                eventoSuplementoMensaje = "no se a añadido ningun suplemento";
            }
            eventoPrecioFinal += eventoSuplemento;


            // Instanciar los objetos UUID
            IdEvento = UUID.randomUUID();
            idCompraUUID = UUID.randomUUID();

            // Dar formato a las variables
            eventoPrecioFormateado = FORMATO_MONEDA.format(eventoPrecioBase);
            //eventoSubTotalFormateado = FORMATO_MONEDA.format(subtotal);
            eventoBeneficioFormateado = FORMATO_MONEDA.format(eventoBeneficio);
            eventoPrecioFinalFormateado = FORMATO_MONEDA.format(eventoPrecioFinal);
            porcentajeDeDescuentoFormateado = DF_PORCENTAJE.format(porcentajeDeDescuento);
            idCompraForamateado = DF_ID.format(idCompra);

            // Pedir los asistentes
            for (int asistente = 1; asistente < (compraCantidad + 1); asistente++) {
                System.out.printf("Introduce el nombre del asistente %d de %d: ", asistente, compraCantidad);

                System.out.printf("Asistente %s registrado\n", scanner.nextLine());
            }


            //Mostrar la infomraciona al cliente
            System.out.println("---------------------------------------------------");
            System.out.println("Recinto");
            System.out.printf("Nombre del recinto: %s\n", recintoNombre);
            System.out.printf("Direccion del recinto: %s\n", recintoDirec);
            System.out.printf("Aforo del recinto: %s\n", recintoAforo);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Evento");
            System.out.printf("Nombre del Evento: %s\n", eventoNombre);
            System.out.printf("Precio del Evento: %s\n", eventoPrecioFormateado);
            System.out.printf("Beneficio del Evento: %s\n", eventoBeneficioFormateado);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Usuario");
            System.out.printf("Nombre de usuario: %s\n", usuarioNombre);
            System.out.printf("Email de usuario: %s\n", usuarioEmail);
            System.out.printf("Edad del usuario: %s\n", usuarioEdad);
            System.out.printf("El usuario es estudiante : %s\n", (usuarioEsEstudiante) ? "si" : "no");
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Tarjeta");
            System.out.printf("Tipo de tarjeta: %s\n", pagoTipoTarjeta);
            System.out.printf("Numero de tarjeta: %s\n", pagoNumeroTarjeta);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Cantidad");
            System.out.printf("Cantidad a comprar: %d\n", compraCantidad);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Comentario");
            System.out.printf("Valoracion del comentario: %d\n", valorPuntuacion);
            System.out.printf("Comentario: %s\n", valorComentario);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Validaciones");
            System.out.printf("Validacion de nombre del Evento: %b\n", validacionNombreEvento);
            System.out.printf("Validacion de Email: %b\n", validacionEmail);
            System.out.printf("Validacion de numero de tarjeta: %b\n", validacionTarjeta);
            System.out.printf("Validacion de la Puntuacion: %b\n", validacióPuntuacion);
            System.out.printf("Validacion de Comentario vacio: %b\n", validacionComentarioVacio);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Descomposicion de codigo");
            System.out.printf("Estado: %s\n", estado);
            System.out.printf("Ciudad: %s\n", ciudad);
            System.out.printf("Año: %s\n", anio);
            System.out.printf("Serial: %s\n", serial);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Fechas");
            System.out.printf("El nombre del dia es: %s\n", nombreDelDia);
            System.out.printf("El nombre del mes es: %s\n", nombreDelMes);
            System.out.printf("El dia del año es: %d\n", diaDelAño);
            System.out.printf("Es año bisiesto: %b\n", esAñoBisiesto);
            System.out.printf("La eventoFecha limite para devolver la entrada es: %s\n", fechaLimiteDevolucion);
            System.out.printf("La eventoFecha para el inicio de ventas es: %s\n", fechaInicioVenta);
            System.out.printf("La eventoFecha para enviar un recordatorio es: %s\n", fechaEnvioRecordatorio);
            // Comprobar en que momento es el evento
            if (eventoFecha.isBefore(fechaActual)) {
                System.out.println("El evento ya ha pasado.");
            } else if (eventoFecha.isEqual(fechaActual)) {
                System.out.println("El evento ya ha pasado.");
            } else {
                System.err.printf("El evento es en el futuro y faltan: %s dias", ChronoUnit.DAYS.between(fechaActual, eventoFecha));
            }
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Random");
            System.out.printf("Id Compra: %s\n", idCompra);
            System.out.printf("Porcentaje de descuento: %s\n", porcentajeDeDescuentoFormateado);
            System.out.printf("Fila: %d\n", fila);
            System.out.printf("Asiento: %d\n", asiento);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Ratio");
            System.out.printf("Ratio de personas por salida: %f\n", radioPersona);
            System.out.printf("La longitud en diagonal es: %f\n", Math.sqrt(Math.pow(largo, 2) + Math.pow(ancho, 2)));
            //System.out.printf("Subtotal es: %s\n", eventoPrecioFormateado);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Precio");
            System.out.printf("%s", eventoDescuentoMensaje);
            System.out.printf("El precio final del evento es: %s,y %s\n", eventoPrecioFinalFormateado, eventoSuplementoMensaje);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("IDs");
            System.out.printf("ID del evento es: %s\n", IdEvento);
            System.out.printf("ID de compra es: %s\n", idCompraUUID);
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Formato");
            System.out.printf("Precio entrada: original: %f, con formato: %s\n", eventoPrecioBase, eventoPrecioFormateado);
            System.out.printf("Precio final: original: %f, con formato: %s\n", eventoPrecioFinal, eventoPrecioFinalFormateado);
            System.out.printf("Porcentaje Descuento: original: %f, con formato: %s\n", porcentajeDeDescuento, porcentajeDeDescuentoFormateado);
            System.out.printf("IDCompra: original: %d, con formato: %s\n", idCompra, idCompraForamateado);
        } else {
            if (fechaActual.isBefore(fechaActual)) {
                System.err.println("Compra no valida: La fecha es invalida");
            }
            if (!valicadionCantidad) {
                System.err.println("Compra no valida: La cantidad tiene que ser igual o mayor a 0");
            }
            if (!validacionAforo) {
                System.err.println("Compra no valida: La cantidad no tiene que ser mayor al aforo");
            }

        }
    }
}

