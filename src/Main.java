import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Boolean estadoMenu = true;

        System.out.println("-------------------------------------------");
        System.out.println("Torneo universitario de videojuegos");
        System.out.println("");
        System.out.println("Bienvenido!, crea a tu jugador!");
        System.out.println("-------------------------------------------");

        // Primero se piden los datos para crear al jugador
        System.out.println("");
        System.out.println("");
        System.out.println("¿Cual es tu nombre?");
        System.out.println("");
        String nombre = scanner.nextLine();

        System.out.println("");
        System.out.println("¿Cual es tu edad?");
        System.out.println("");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");
        System.out.println("¿Que nickname quieres usar?");
        System.out.println("");
        String nickname = scanner.nextLine();

        System.out.println("");
        System.out.println("J U G A D O R  C R E A D O  C O N  E X I T O");
        System.out.println("");

        Jugador jugadoractivo = new Jugador(nombre, nickname, edad);

        System.out.println("P U L S A  E N T E R  P A R A  C O N T I N U A R");
        scanner.nextLine();

        // Aca empieza el menu principal del programa
        while (estadoMenu) {

            System.out.println("-------------------------------------------");
            System.out.println("");
            System.out.println("1 - CREAR NUEVO JUGADOR");
            System.out.println("");
            System.out.println("2 - REGISTRAR NUEVA PARTIDA");
            System.out.println("");
            System.out.println("3 - CONSULTAR PUNTAJES");
            System.out.println("");
            System.out.println("4 - CONSULTAR UNA PARTIDA");
            System.out.println("");
            System.out.println("5 - MODIFICAR UNA PARTIDA");
            System.out.println("");
            System.out.println("6 - MOSTRAR PROMEDIO");
            System.out.println("");
            System.out.println("7 - MEJOR Y PEOR PUNTAJE");
            System.out.println("");
            System.out.println("8 - CONSULTAR PARTIDAS DISPONIBLES");
            System.out.println("");
            System.out.println("9 - SALIR DEL PROGRAMA");
            System.out.println("");
            System.out.println("-------------------------------------------");

            int eleccion = scanner.nextInt();
            scanner.nextLine();

            // Aca se puede crear otro jugador y reemplazar el anterior
            if (eleccion == 1) {

                System.out.println("");
                System.out.println("¿Cual es tu nombre?");
                System.out.println("");
                nombre = scanner.nextLine();

                System.out.println("");
                System.out.println("¿Cual es tu edad?");
                System.out.println("");
                edad = scanner.nextInt();
                scanner.nextLine();

                System.out.println("");
                System.out.println("¿Que nickname quieres usar?");
                System.out.println("");
                nickname = scanner.nextLine();

                jugadoractivo = new Jugador(nombre, nickname, edad);

                System.out.println("");
                System.out.println("N U E V O  J U G A D O R  C R E A D O  C O N  E X I T O");
                System.out.println("");
                System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                scanner.nextLine();
                System.out.println("");
            }

            // Aca se registra una nueva partida con su puntaje
            if (eleccion == 2) {

                System.out.println("");
                System.out.println("Ingresa el puntaje que quieres registrar en la partida: ");
                System.out.println("");

                int puntaje = scanner.nextInt();
                scanner.nextLine();

                System.out.println("");

                if (jugadoractivo.registrarPartida(puntaje) == false) {
                    System.out.println("HUBO UN ERROR, LA PARTIDA NO SE PUDO REGISTRAR!.");
                    System.out.println("VOLVIENDO AL MENU...");
                    System.out.println("");
                } else {
                    System.out.println("P A R T I D A  R E G I S T R A D A  C O N  E X I T O");
                    System.out.println("");
                    System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                    scanner.nextLine();
                    System.out.println("");
                }
            }

            // Se muestran todos los puntajes registrados
            if (eleccion == 3) {

                int[] puntajesactivos = jugadoractivo.obtenerPuntajes();

                System.out.println("");

                if (puntajesactivos == null) {
                    System.out.println("NO SE PUEDEN OBTENER PUNTAJES YA QUE NO SE HAN REGISTRADO PARTIDAS!.");
                    System.out.println("VOLVIENDO AL MENU...");
                    System.out.println("");
                } else {
                    System.out.println("--------------------------------");
                    System.out.println("REGISTROS DE PUNTAJES");
                    System.out.println("");

                    for (int i = 0; i < puntajesactivos.length; i++) {
                        int npartida = i + 1;
                        System.out.println("Partida " + npartida + " - Puntaje: " + puntajesactivos[i]);
                    }

                    System.out.println("--------------------------------");
                    System.out.println("");
                    System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                    scanner.nextLine();
                    System.out.println("");
                }
            }

            // Aca se consulta una partida en especifico
            if (eleccion == 4) {

                System.out.println("");
                System.out.println("Elige la partida que quieras consultar");
                System.out.println("");

                int eleccionPartida = scanner.nextInt();
                scanner.nextLine();

                System.out.println("");

                if (jugadoractivo.consultarPuntaje(eleccionPartida) == -1) {
                    System.out.println("");
                    System.out.println("HAS ELEGIDO UNA PARTIDA INVALIDA!");
                    System.out.println("VOLVIENDO AL MENU");
                    System.out.println("");
                } else {
                    System.out.println("PARTIDA: " + eleccionPartida);
                    System.out.println("PUNTAJE: " + jugadoractivo.consultarPuntaje(eleccionPartida));
                    System.out.println("");
                    System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                    scanner.nextLine();
                    System.out.println("");
                }
            }

            // Sirve para cambiar el puntaje de una partida ya registrada
            if (eleccion == 5) {

                System.out.println("");
                System.out.println("Elige la partida que quieras modificar: ");
                System.out.println("");

                int eleccionPartida = scanner.nextInt();
                scanner.nextLine();

                System.out.println("");
                System.out.println("Elige el puntaje que quieras poner en esa partida!: ");
                System.out.println("");

                int eleccionPuntaje = scanner.nextInt();
                scanner.nextLine();

                System.out.println("");

                if (jugadoractivo.modificarPuntaje(eleccionPartida, eleccionPuntaje)) {
                    System.out.println("LA MODIFICACION HA SIDO REALIZADA EXITOSAMENTE!");
                    System.out.println("");
                    System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                    scanner.nextLine();
                    System.out.println("");
                } else {
                    System.out.println("HA HABIDO UN ERROR...");
                    System.out.println("REGRESANDO AL MENU...");
                    System.out.println("");
                }
            }

            // Se calcula el promedio de los puntajes
            if (eleccion == 6) {

                double promedio = jugadoractivo.calcularPromedio();

                System.out.println("");

                if (promedio == -1) {
                    System.out.println("NO SE HA REGISTRADO NINGUNA PARTIDA PREVIAMENTE PARA SACAR EL PROMEDIO");
                    System.out.println("REGRESANDO AL MENU...");
                    System.out.println("");
                } else {
                    System.out.println("EL PROMEDIO DE TUS PUNTAJES FUE: " + promedio);
                    System.out.println("");
                    System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                    scanner.nextLine();
                    System.out.println("");
                }
            }

            // Aca se muestran el puntaje mas alto y el mas bajo
            if (eleccion == 7) {

                System.out.println("");

                if (jugadoractivo.obtenerPuntajeMayor() == -1) {
                    System.out.println("NO SE HA REGISTRADO NINGUNA PARTIDA PREVIAMENTE PARA SACAR EL PUNTAJE MAXIMO Y MINIMO...");
                    System.out.println("REGRESANDO AL MENU...");
                    System.out.println("");
                } else {
                    System.out.println("EL PUNTAJE MAXIMO FUE DE " + jugadoractivo.obtenerPuntajeMayor());
                    System.out.println("EL PUNTAJE MINIMO FUE DE " + jugadoractivo.obtenerPuntajeMenor());
                    System.out.println("");
                    System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                    scanner.nextLine();
                    System.out.println("");
                }
            }

            // Muestra cuantas partidas lleva y cuantas le quedan
            if (eleccion == 8) {

                System.out.println("");
                System.out.println("HAS REGISTRADO UN TOTAL DE " + jugadoractivo.getPartidasJugadas() + " PARTIDAS!");
                System.out.println("TIENES UN TOTAL DE " + jugadoractivo.getPartidasDisponibles() + " PARTIDAS DISPONIBLES!");
                System.out.println("");
                System.out.println("P U L S A  E N T E R  P A R A  REGRESAR AL MENU");
                scanner.nextLine();
                System.out.println("");
            }

            // Con esta opcion se termina el programa
            if (eleccion == 9) {
                estadoMenu = false;
                System.out.println("");
                System.out.println("H A S  S A L I D O  D E L  P R O G R A M A");
            }

            if (eleccion < 1 || eleccion > 9) {
                System.out.println("");
                System.out.println("El numero ingresado no esta en el menu!");
                System.out.println("Coloca un numero valido!.");
                System.out.println("");
            }
        }

        scanner.close();
    }
}