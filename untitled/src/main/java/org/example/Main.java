package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int aux;

        int[] numeros = new int[5];

        numeros[0] = -1;
        numeros[1] = 10;
        numeros[2] = 20;
        numeros[3] = -1;
        numeros[4] = 80;

        for (int i = 0; i < numeros.length ; i++) {
            if (numeros[i] == -1) {
                if ((i - 1 >= 1) && (i+1 <= 4) ) {

                    aux = numeros[i+1];

                    numeros[i+1] = numeros[i];

                    numeros[i] = aux;

                } else {

                    numeros[i] = -100;

                }
            }
        }

        for (int i = 0; i < numeros.length ; i++) {
            System.out.println(numeros[i]);
        }

    }
}