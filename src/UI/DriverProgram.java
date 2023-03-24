package UI;

import Controller.Translator;
import Model.Association;
import Model.BinaryTree;

import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverProgram {

    public static void main(String[] args) throws FileNotFoundException {

        BinaryTree dicc = new BinaryTree();
        Association<String, String> asc = new Association<>();
        String DICTIONARY = "src/dictionary.txt";
        String TEXT = "src/text.txt";
        String printBST = "";

        Scanner sc = new Scanner(System.in);
        int resp = 0;

        while (resp != 8) {
            System.out.println("\n --- Traductor ---");
            System.out.println("Sugerencia: Recuerde cambiar la oración en el archivo dictionary.txt para poder testear las 6 opciones de traducción\n y cambiar la ruta de dictionary.txt y text.txt en las variables: DICTIONARY y TEXT.");
            System.out.println("\t1. Traducir un texto de ingles a español");
            System.out.println("\t2. Traducir un texto de ingles a frances");
            System.out.println("\t3. Traducir un texto de español a ingles");
            System.out.println("\t4. Traducir un texto de español a frances");
            System.out.println("\t5. Traducir un texto de frances a ingles");
            System.out.println("\t6. Traducir un texto de frances a español");
            System.out.println("\t7. Salir  ");
            System.out.println("\t\tIngrese el número de la opción que desea escoger: ");

            try {
                resp = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Ingrese un número por favor.");
            }

            while (resp < 1 || resp > 7) {
                System.out.println("Ingrese una opción válida.");
                System.out.println("Ingrese la opción desea elegir: ");

                try {
                    resp = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("Ingrese un número por favor.");
                }
            }

            switch (resp) {
                case 1:
                    System.out.println("La traduccion del texto de ingles a español es: " + Translator.translate(DICTIONARY, TEXT, dicc, asc, resp));
                    System.out.println("¿Desea imprimir el arbol ordenado? (Y/N)");
                    printBST = sc.nextLine();
                    if (printBST.equalsIgnoreCase("y")) {
                        dicc.printInOrder();
                    }
                    break;
                case 2:
                    System.out.println("La traduccion del texto de ingles a frances es: " + Translator.translate(DICTIONARY, TEXT, dicc, asc, resp));
                    System.out.println("¿Desea imprimir el arbol ordenado?");
                    printBST = sc.nextLine();
                    if (printBST.equalsIgnoreCase("y")) {
                        dicc.printInOrder();
                    }
                    break;
                case 3:
                    System.out.println("La traduccion del texto de español a inglés es: " + Translator.translate(DICTIONARY, TEXT, dicc, asc, resp));
                    System.out.println("¿Desea imprimir el arbol ordenado?");
                    printBST = sc.nextLine();
                    if (printBST.equalsIgnoreCase("y")) {
                        dicc.printInOrder();
                    }
                    break;
                case 4:
                    System.out.println("La traduccion del texto de español a frances es: " + Translator.translate(DICTIONARY, TEXT, dicc, asc, resp));
                    System.out.println("¿Desea imprimir el arbol ordenado?");
                    printBST = sc.nextLine();
                    if (printBST.equalsIgnoreCase("y")) {
                        dicc.printInOrder();
                    }
                    break;
                case 5:
                    System.out.println("La traduccion del texto de frances a español es: " + Translator.translate(DICTIONARY, TEXT, dicc, asc, resp));
                    System.out.println("¿Desea imprimir el arbol ordenado?");
                    printBST = sc.nextLine();
                    if (printBST.equalsIgnoreCase("y")) {
                        dicc.printInOrder();
                    }
                    break;
                case 6:
                    System.out.println("La traduccion del texto de frances a ingles es: " + Translator.translate(DICTIONARY, TEXT, dicc, asc, resp));
                    System.out.println("¿Desea imprimir el arbol ordenado?");
                    printBST = sc.nextLine();
                    if (printBST.equalsIgnoreCase("y")) {
                        dicc.printInOrder();
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    resp = 8;
            }

        }
    }
}


