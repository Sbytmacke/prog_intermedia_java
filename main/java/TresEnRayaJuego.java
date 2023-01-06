import java.util.Scanner;

public class TresEnRayaJuego {

    public static void main(String[] args) {

        boolean salir = false;
        while(!salir) {
            // Inicializamos el mapa
            String[][] mapa = generarMapa();
            System.out.println(" ");
            imprimirMatriz(mapa);

            //Repetirá hasta que verifique haya 9 valores de "X" o "O"
            while(!verificarLimiteJuego(mapa)){
                // Scanner
                Scanner sc = new Scanner(System.in);

                // Valores de fila y columna JUGADOR 1
                int[] posicionesJugadorUno = new int[2];

                // Movimientos jugador /decision
                System.out.println(" ");
                System.out.println("(Jugador 1) Elige donde marcar:");
                while (true) {
                    while(true){
                        System.out.println("Fila:");
                        int filaJugadorUno = sc.nextInt();
                        if (filaJugadorUno >=1 && filaJugadorUno <= 3 ){
                            // Introducimos el valor asignado en nuestro almacén
                            posicionesJugadorUno[0] = filaJugadorUno-1;
                            break;
                        }
                    }
                    while(true){
                        System.out.println("Columna:");
                        int columnaJugadorUno = sc.nextInt();
                        if (columnaJugadorUno >=1 && columnaJugadorUno <= 3 ){
                            // Introducimos el valor asignado en nuestro almacén
                            posicionesJugadorUno[1] = columnaJugadorUno-1;
                            break;
                        }
                    }

                    // Verificar que la posición elegida no está ya ocupada
                    if (isEmpty(mapa, posicionesJugadorUno)){

                        // Cambiar el mapa
                        mapa[posicionesJugadorUno[0]][posicionesJugadorUno[1]] = "X";

                        // Demostrar valores nuevos
                        System.out.println(" ");
                        imprimirMatriz(mapa);

                        break;
                    }
                }

                // Verificar si ha ganado el jugador
                if (verificarGanadorJugadorUno(mapa)){
                    break;
                }

                //========================================================================================
                // Valores de fila y columna JUGADOR 2
                int[] posicionesJugadorDos = new int[2];

                // Movimientos jugador /decision
                System.out.println(" ");
                System.out.println("(Jugador 2) Elige donde marcar:");
                while (true) {
                    while (true) {
                        System.out.println("Fila:");
                        int filaJugadorDos = sc.nextInt();
                        if (filaJugadorDos >= 1 && filaJugadorDos <= 3) {
                            // Introducimos el valor asignado en nuestro almacén
                            posicionesJugadorDos[0] = filaJugadorDos-1;
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("Columna:");
                        int columnaJugadorDos = sc.nextInt();
                        if (columnaJugadorDos >= 1 && columnaJugadorDos <= 3) {
                            // Introducimos el valor asignado en nuestro almacén
                            posicionesJugadorDos[1] = columnaJugadorDos-1;
                            break;
                        }
                    }
                    // Verificar que la posición elegida no está ya ocupada
                    if (isEmpty(mapa, posicionesJugadorDos)){

                        // Cambiar el mapa
                        mapa[posicionesJugadorDos[0]][posicionesJugadorDos[1]] = "O";

                        // Demostrar valores nuevos
                        System.out.println(" ");
                        imprimirMatriz(mapa);

                        break;
                    }
                }

                // Verificar si ha ganado el jugador
                if (verificarGanadorJugadorDos(mapa)){
                    break;
                }
            }
            System.out.println(" ");
            salir = salir();
        }
    }

    // Verificar ganador
    public static boolean verificarGanadorJugadorUno(String[][] mapa){
        for (int filas = 0; filas < mapa.length; filas++) {
            for (int columnas = 0; columnas < mapa[filas].length; columnas++)  {

                // Primera condición que haya 3 en una línea
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (columnas == 0) {
                    if (mapa[filas][columnas].equals("X")
                            && mapa[filas][columnas + 1].equals("X")
                            && mapa[filas][columnas + 2].equals("X")) {
                        System.out.println("Ha ganado el jugador 1!");
                        return true;
                    }
                }

                // Segunda condición que haya 3 en una columna
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (filas == 0) {
                    if (mapa[filas][columnas].equals("X")
                            && mapa[filas + 1][columnas].equals("X")
                            && mapa[filas + 2][columnas].equals("X")) {
                        System.out.println("Ha ganado el jugador 1!");
                        return true;
                    }
                }

                // Tercera condición que haya 3 en diagonal descendente
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (filas == 0 && columnas == 0) {
                    if (mapa[filas][columnas].equals("X")
                            && mapa[filas + 1][columnas + 1].equals("X")
                            && mapa[filas + 2][columnas + 2].equals("X")) {
                        System.out.println("Ha ganado el jugador 1!");
                        return true;
                    }

                }

                // Cuarta condición que haya 3 en diagonal ascendente
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (filas == 2 && columnas == 0){
                    if (mapa[filas][columnas].equals("X")
                            && mapa[filas - 1][columnas + 1].equals("X")
                            && mapa[filas - 2][columnas + 2].equals("X")){
                        System.out.println("Ha ganado el jugador 1!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Verificar si existe ya un elemento
    public static boolean isEmpty(String[][] mapa, int[] posicionAsignar){
        if (mapa[posicionAsignar[0]][posicionAsignar[1]].equals("X")) {
            System.out.println("Esa casilla ya está ocupada!");
            return false;
        }
        if (mapa[posicionAsignar[0]][posicionAsignar[1]].equals("O")) {
            System.out.println("Esa casilla ya está ocupada!");
            return false;
        }
        return true;
    }


    // Verificar ganador
    public static boolean verificarGanadorJugadorDos(String[][] mapa){
        for (int filas = 0; filas < mapa.length; filas++) {
            for (int columnas = 0; columnas < mapa[filas].length; columnas++)  {

                // Primera condición que haya 3 en una línea
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (columnas == 0) {
                    if (mapa[filas][columnas].equals("O")
                            && mapa[filas][columnas + 1].equals("O")
                            && mapa[filas][columnas + 2].equals("O")) {
                        System.out.println("Ha ganado el jugador 2!");
                        return true;
                    }
                }

                // Segunda condición que haya 3 en una columna
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (filas == 0) {
                    if (mapa[filas][columnas].equals("O")
                            && mapa[filas + 1][columnas].equals("O")
                            && mapa[filas + 2][columnas].equals("O")) {
                        System.out.println("Ha ganado el jugador 2!");
                        return true;
                    }
                }

                // Tercera condición que haya 3 en diagonal descendente
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (filas == 0 && columnas == 0) {
                    if (mapa[filas][columnas].equals("O")
                            && mapa[filas + 1][columnas + 1].equals("O")
                            && mapa[filas + 2][columnas + 2].equals("O")) {
                        System.out.println("Ha ganado el jugador 2!");
                        return true;
                    }
                }

                // Cuarta condición que haya 3 en diagonal ascendente
                // Con su filtro para solo observar, el caso que queremos y no salirnos de la matriz
                if (filas == 2 && columnas == 0){
                    if (mapa[filas][columnas].equals("O")
                            && mapa[filas - 1][columnas + 1].equals("O")
                            && mapa[filas - 2][columnas + 2].equals("O")){
                        System.out.println("Ha ganado el jugador 2!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Verificar que no es posible jugar más
    public static boolean verificarLimiteJuego(String[][] mapa){
        int contadorLimite = 0;
        for (int filas = 0; filas < mapa.length; filas++) {
            for (int columnas = 0; columnas < mapa[filas].length; columnas++) {
                if (mapa[filas][columnas].equals("X") || mapa[filas][columnas].equals("O")){
                    contadorLimite += 1;
                    if (contadorLimite == 9){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // Generar mapa
    public static String[][] generarMapa() {
        String[][] mapaUno = new String[3][3];

        // Otra forma, para no dejarlo a nulos
        String[][] mapaDos = {{" "," "," "},{" "," "," "},{" "," "," "}};

        return mapaDos;
    }

    // Genera un número entre 1 y 10 (incluidos)
    public static int sortearNumeroAleatorio(){
        final int numero = (int) (Math.random() * 10 + 1);
        //System.out.println(numero);
        return numero;
    }


    // Para imprimir en pantalla la matriz del mapa
    public static void imprimirMatriz(String[][] miMatriz) {
        for (int filas = 0; filas < miMatriz.length; filas++) {
            for (int columnas = 0; columnas < miMatriz[filas].length; columnas++) {

                if (columnas == 0){
                    System.out.print("|");
                }

                System.out.print(miMatriz[filas][columnas] + " ");

                if (columnas == miMatriz.length-1){
                    System.out.println("|");
                }

            }
        }
        System.out.print(" ");
    }


    // Decisión del usuario si quiere reiniciar la partida o salir
    public static boolean salir(){
        System.out.println("¿Quieres salir (Y) o reiniciar la Partida (N)?:");
        Scanner entrada = new Scanner(System.in);

        while (true) {

            String respuesta = entrada.nextLine();

            if (respuesta.equals("Y") || respuesta.equals("y")) {
                return true;
            } else if (respuesta.equals("N") || respuesta.equals("n")) {
                return false;
            } else {
                System.out.println("Por favor, ingrese una respuesta válida (Y/N):");
            }
        }
    }
}