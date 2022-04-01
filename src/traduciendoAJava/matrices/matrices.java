package traduciendoAJava.matrices;

import java.util.Random;
import java.util.Scanner;

//
// ──────────────────────────────────────────────────────────────────────────────────────── I ──────────
//   :::::: O P E R A C I O N E S   C O N   M A T R I C E S : :  :   :    :     :        :          :
// ──────────────────────────────────────────────────────────────────────────────────────────────────
//

public class matrices {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int opcion;
            while (true) {
                menu();
                System.out.print("Escriba una opcion valida: ");
                opcion = leer.nextInt();
                if (opcion >= 1 && opcion <= 4)
                    break;
            }
            int[] dimensiones;
            int[][] matriz1 = {};
            int[][] matriz2 = {};
            boolean correcto = false;
            while (!correcto) {
                if(opcion == 4)
                    System.exit(0);
                dimensiones = pedirDimensionesMatriz("Primera");
                matriz1 = new int[dimensiones[0]][dimensiones[1]];
                dimensiones = pedirDimensionesMatriz("Segunda");
                matriz2 = new int[dimensiones[0]][dimensiones[1]];
                switch (opcion) {
                    case 1: case 2:
                        correcto = matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length;
                        break;
                    case 3:
                        correcto = matriz1[0].length == matriz2.length;
                        break;
                }
                if (!correcto) {
                    System.out.println("Las dimensiones son incorrectas");
                }
            }

            aleatorizarValoresMatriz(matriz1);
            aleatorizarValoresMatriz(matriz2);
            mostrarMatriz(matriz1);
            mostrarMatriz(matriz2);
            int[][] resultado = {};
            switch (opcion) {
                case 1:
                    resultado = sumar(matriz1, matriz2);
                    break;
                case 2:
                    resultado = restar(matriz1, matriz2);
                    break;
                case 3:
                    resultado = multiplicar(matriz1, matriz2);
            }
            mostrarMatriz(resultado);
        }
    }
//
// ─── MOSTRAR LA MATRIZ ──────────────────────────────────────────────────────────
//

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
//
// ─── SUMAR LAS MATRICES ─────────────────────────────────────────────────────────
//
    //* Tambien se pudo hacer solo una funcion para sumar y restar las matrices
    public static int[][] sumar(int[][] matriz1, int[][] matriz2) {
        int[][] suma = matriz1;
        for (int i = 0; i < suma.length; i++) {
            for (int j = 0; j < suma[0].length; j++) {
                suma[i][j] += matriz2[i][j];
            }
        }
        return suma;
    }
//
// ─── RESTAR LAS MATRICES ────────────────────────────────────────────────────────
//
    //! error catastrofico
    public static int[][] restar(int[][] matriz1, int[][] matriz2) {
        int[][] resta = matriz1;
        for (int i = 0; i < resta.length; i++) {
            for (int j = 0; j < resta[0].length; j++) {
                resta[i][j] += matriz2[i][j];
            }
        }
        return resta;
    }
//
// ─── MULTIPLICAR LAS MATRICES ───────────────────────────────────────────────────
//

    public static int[][] multiplicar(int[][] matriz1, int[][] matriz2) {
        int[][] multiplicacion = new int[matriz1.length][matriz2[0].length];
        for (int i = 0; i < multiplicacion.length; i++) {
            for (int j = 0; j < multiplicacion[0].length; j++) {
                for (int k = 0; k < matriz1[0].length; k++) {
                    multiplicacion[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return multiplicacion;
    }
//
// ─── MOSTRAR EL MENU ────────────────────────────────────────────────────────────
//

    public static void menu() {
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1) Sumar Matrices");
        System.out.println("2) Restar Matrices");
        System.out.println("3) Multiplicar Matrices");
        System.out.println("4) SALIR");
    }
//
// ─── ALEATORIZAR LOS VALORES DE LA MATRIZ ───────────────────────────────────────
//

    public static void aleatorizarValoresMatriz(int[][] matriz) {
        Random aleatorio = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = aleatorio.nextInt(100);
            }
        }
    }
//
// ─── PEDIR LAS DIMENSIONES DE LA MATRIZ ─────────────────────────────────────────
//

    public static int[] pedirDimensionesMatriz(String texto) {
        System.out.printf("Ingrese El Ancho de la %s Matriz: ", texto);
        int ancho = leer.nextInt();
        System.out.printf("Ingrese La Altura de la %s Matriz: ", texto);
        int altura = leer.nextInt();
        return new int[] { ancho, altura };
    }
}