package pruebaslab;

import java.util.Random;

public class Tablero {
    private static final int AGUA = 0;
    private static final int BARCO = 1;
    private static final int DISPARO_AGUA = -1;
    private static final int DISPARO_BARCO = 2;

    private int[][] matriz;
    private int barcosHundidos;
    private int totalBarcos;
    private int tamano; // Tamaño dinámico del tablero

    public Tablero(int tamano) {
        this.tamano = tamano;
        matriz = new int[tamano][tamano];
        barcosHundidos = 0;
        totalBarcos = 0;
        inicializarTablero();
    }

    // Inicializa el tablero con agua
    public void inicializarTablero() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                matriz[i][j] = AGUA;
            }
        }
    }

    // Coloca barcos aleatoriamente en el tablero
    public void colocarBarcos(int numBarcos) {
        Random random = new Random();
        int barcosColocados = 0;
        totalBarcos = numBarcos;

        while (barcosColocados < numBarcos) {
            int fila = random.nextInt(tamano);
            int columna = random.nextInt(tamano);

            if (matriz[fila][columna] == AGUA) {
                matriz[fila][columna] = BARCO;
                barcosColocados++;
            }
        }
    }

    // Procesar un disparo en el tablero
    public String procesarDisparo(int fila, int col) {
        if (matriz[fila][col] == BARCO) {
            matriz[fila][col] = DISPARO_BARCO;
            barcosHundidos++;
            return "LE HAS DADO A UN BARCO WUJUUUU!!!";
        } else if (matriz[fila][col] == AGUA) {
            matriz[fila][col] = DISPARO_AGUA;
            return "LE HAS DADO AL AGUA :(";
        } else if (matriz[fila][col] == DISPARO_AGUA) {
            return "YA HAS DISPARADO AQUI, ERA AGUA";
        } else if (matriz[fila][col] == DISPARO_BARCO) {
            return "YA HAS DISPARADO AQUI, ERA UN BARCO";
        } else {
            return "ERROR: DISPARO NO VÁLIDO";
        }
    }

    // Verificar si todos los barcos han sido hundidos
    public boolean todosBarcosHundidos() {
        return barcosHundidos == totalBarcos;
    }

    // Método de depuración para mostrar el estado del tablero (opcional)
    public void mostrarTablero() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
