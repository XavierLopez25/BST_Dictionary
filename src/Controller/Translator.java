package Controller;

import Model.Association;
import Model.BinaryTree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Translator.
 */
public class Translator {

    /**
     * Translate string.
     *
     * @param DICTIONARY the dictionary
     * @param TEXT       the text
     * @param binaryTree the binary tree
     * @param asc        the asc
     * @param op         the op
     * @return the string
     * @throws FileNotFoundException the file not found exception
     */
    public static String translate(String DICTIONARY, String TEXT, BinaryTree binaryTree, Association<String, String> asc, int op) throws FileNotFoundException {

        FileReader fr = new FileReader(DICTIONARY);
        BufferedReader br = new BufferedReader(fr);
        String stringOutput;

        try {


            int cont = 0;

            while ((stringOutput = br.readLine()) != null) {

                String words = stringOutput.substring(1, stringOutput.length() - 1);
                String[] arrayWords = words.split(", ");

                switch (op){
                    case 1:

                        asc = new Association<>(arrayWords[0].toLowerCase(), arrayWords[1].toLowerCase());

                        if (cont == 0) {
                            binaryTree.setData(asc);
                            cont++;

                        } else {
                            binaryTree.insert(asc); //se inserta el array en el diccionario
                        }
                        break;
                    case 2:
                        asc = new Association<>(arrayWords[0].toLowerCase(), arrayWords[2].toLowerCase());

                        if (cont == 0) {
                            binaryTree.setData(asc);
                            cont++;

                        } else {
                            binaryTree.insert(asc); //se inserta el array en el diccionario
                        }
                        break;
                    case 3:
                        asc = new Association<>(arrayWords[1].toLowerCase(), arrayWords[0].toLowerCase());

                        if (cont == 0) {
                            binaryTree.setData(asc);
                            cont++;

                        } else {
                            binaryTree.insert(asc); //se inserta el array en el diccionario
                        }
                        break;
                    case 4:
                        asc = new Association<>(arrayWords[1].toLowerCase(), arrayWords[2].toLowerCase());

                        if (cont == 0) {
                            binaryTree.setData(asc);
                            cont++;

                        } else {
                            binaryTree.insert(asc); //Se inserta el array en el diccionario
                        }
                        break;
                    case 5:
                        asc = new Association<>(arrayWords[2].toLowerCase(), arrayWords[0].toLowerCase());

                        if (cont == 0) {
                            binaryTree.setData(asc);
                            cont++;

                        } else {
                            binaryTree.insert(asc); //Se inserta el array en el diccionario
                        }
                        break;
                    case 6:
                        asc = new Association<>(arrayWords[2].toLowerCase(), arrayWords[1].toLowerCase());

                        if (cont == 0) {
                            binaryTree.setData(asc);
                            cont++;

                        } else {
                            binaryTree.insert(asc); //Se inserta el array en el diccionario
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                br.close();

                fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

        br = null;
        fr = null;
        String traduction = "";

        try {

            fr = new FileReader(TEXT);
            br = new BufferedReader(fr);

            while ((stringOutput = br.readLine()) != null) {

                stringOutput = stringOutput.replace(".", ""); // remueve todos los puntos

                String[] palabras = stringOutput.split(" ", 0); // separa por espacios

                for (String p : palabras) { // se crea un ciclo para ordenar las palabras y separarlas

                    if (binaryTree.contains(p.toLowerCase())) {

                        traduction += " " + binaryTree.get(p.toLowerCase());

                    } else {

                        traduction += " *" + p + "* "; //se imprime la traduccion
                    }
                }

                traduction += ".\n"; // final de la oracion

            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }

        return traduction;

    }

}
