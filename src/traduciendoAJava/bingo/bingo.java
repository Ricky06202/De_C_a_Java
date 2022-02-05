package traduciendoAJava.bingo;

import java.util.Scanner;

/**
 * bingo
 */
public class bingo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] listaDeNumeros = in.nextLine().split(" ");
        int suma = 0;
        for (String num : listaDeNumeros) {
            suma += Integer.parseInt(num);
        }
        System.out.println(suma);

    }
}