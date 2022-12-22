public class Tablero {
    //El tablero consistira en dos matrices de 10x10 donde la primera genrara un tablero y la segunda guardara y mostrara los valores que se vayan introduciendo

    //Matriz que genera el tablero
    private int[][] tablero;

    //Matriz que guarda los valores introducidos
    private int[][] tableroValores;

    //Constructor
    public Tablero() {
        //Inicializamos las matrices
        tablero = new int[10][10];
        tableroValores = new int[10][10];

    }

    //Metodo que genera el tablero
    public void generarTablero() {
        //Generamos el tablero con numeros aleatorios del 1 al 100
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = (int) (Math.random() * 100) + 1;
            }
        }
    }

    //Metodo que muestra el tablero

    public void mostrarTablero() {
        //Mostramos el tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Metodo que muestra el tablero con los valores introducidos

    public void mostrarTableroValores() {
        //Mostramos el tablero con los valores introducidos
        for (int i = 0; i < tableroValores.length; i++) {
            for (int j = 0; j < tableroValores[i].length; j++) {
                System.out.print(tableroValores[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Metodo que comprueba si la posicion introducida es valida

    public boolean comprobarPosicion(int fila, int columna) {
        //Comprobamos si la posicion introducida es valida
        if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo que comprueba si la posicion introducida esta vacia

    public boolean comprobarPosicionVacia(int fila, int columna) {
        //Comprobamos si la posicion introducida esta vacia
        if (tableroValores[fila][columna] == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo que comprueba si la posicion introducida es valida para colocar el siguiente numero

    public boolean comprobarPosicionValida(int fila, int columna, int numero) {
        //Comprobamos si la posicion introducida es valida para colocar el siguiente numero
        if (comprobarPosicion(fila, columna) && comprobarPosicionVacia(fila, columna)) {
            //Comprobamos si la posicion introducida es valida para colocar el siguiente numero horizontalmente
            if (comprobarPosicion(fila, columna + 2) && comprobarPosicionVacia(fila, columna + 2)) {
                if (tableroValores[fila][columna + 2] == numero + 1) {
                    return true;
                }
            }
            //Comprobamos si la posicion introducida es valida para colocar el siguiente numero verticalmente
            if (comprobarPosicion(fila + 2, columna) && comprobarPosicionVacia(fila + 2, columna)) {
                if (tableroValores[fila + 2][columna] == numero + 1) {
                    return true;
                }
            }
            //Comprobamos si la posicion introducida es valida para colocar el siguiente numero en diagonal
            if (comprobarPosicion(fila + 1, columna + 1) && comprobarPosicionVacia(fila + 1, columna + 1)) {
                if (tableroValores[fila + 1][columna + 1] == numero + 1) {
                    return true;
                }
            }
            //Comprobamos si la posicion introducida es valida para colocar el siguiente numero en diagonal
            if (comprobarPosicion(fila + 1, columna - 1) && comprobarPosicionVacia(fila + 1, columna - 1)) {
                if (tableroValores[fila + 1][columna - 1] == numero + 1) {
                    return true;
                }
            }
            //Comprobamos si la posicion introducida es valida para colocar el siguiente numero en diagonal
            if (comprobarPosicion(fila - 1, columna + 1) && comprobarPosicionVacia(fila - 1, columna + 1)) {
                if (tableroValores[fila - 1][columna + 1] == numero + 1) {
                    return true;
                }

            }
        }
        return false;
    }

    //Metodo que comprueba si el tablero esta lleno

    public boolean comprobarTableroLleno(){
        //Comprobamos si el tablero esta lleno
        for (int i = 0; i < tableroValores.length; i++) {
            for (int j = 0; j < tableroValores[i].length; j++) {
                if(tableroValores[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

}
