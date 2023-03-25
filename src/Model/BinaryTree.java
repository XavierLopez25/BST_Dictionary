package Model;

/**
 * The type Binary tree.
 */
//Extraído de: https://www.baeldung.com/java-binary-tree
public class BinaryTree{


    /**
     * The Data.
     */
    Association<String,String> data;
    /**
     * The Left.
     */
    BinaryTree left;
    /**
     * The Right.
     */
    BinaryTree right;

    /**
     * The Already printed.
     */
    boolean alreadyPrinted;


    /**
     * Instantiates a new Binary tree.
     */
    public BinaryTree() {
        data = null;
        left = null;
        right = null;
        alreadyPrinted = false;
    }

    /**
     * Instantiates a new Binary tree.
     *
     * @param data the data
     */
    public BinaryTree(Association<String,String> data) {
        this.data = data;
        left = null;
        right = null;
        alreadyPrinted = false;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Association<String,String> data) {
        this.data = data;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Association<String,String> getValue() {
        return data;
    }

    /**
     * Insert.
     *
     * @param value the value
     */
    //Metodo para insertar nodos
    public void insert(Association<String,String> value) {

        if (value.getKey() == null) {
            return;
        }

        int res = stringCompare(value.getKey(), data.getKey());

        if (res <= 0) {

            if (left == null) {
                left = new BinaryTree(value);
            } else {
                left.insert(value);
            }

        } else {

            if (right == null) {
                right = new BinaryTree(value);
            } else {
                right.insert(value);
            }
        }

    }

    /**
     * Contains boolean.
     *
     * @param value the value
     * @return the boolean
     */
    //Metodo para encontrar un nodo
    public boolean contains(String value) {

        int res = stringCompare(value, data.getKey());

        if (res == 0) {
            return true;

        } else if (res < 0) {

            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {

            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    //Metodo que hace las traducciones
    public String get(String key) {

        int res = stringCompare(key, data.getKey());

        if (res == 0) {
            return data.getValue();

        } else {

            if (res < 0) {
                return left.get(key);

            } else {
                return right.get(key);
            }
        }

    }

    /**
     * Print in order.
     */
    //Metodo para mostrar los nodos en orden
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }

        if (!alreadyPrinted) {
            System.out.println(this.data.toString());
            alreadyPrinted = true;
        }

        if (right != null) {
            right.printInOrder();
        }
    }

    /**
     * String compare int.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return the int
     */
    //Metodo que compara las asociaciones
    public int stringCompare(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        } else {
            return 0;
        }
    }

    /**
     * Search binary tree.
     *
     * @param key the key
     * @return the binary tree
     */
    public BinaryTree search(String key) {
        int res = stringCompare(key, data.getKey());

        if (res == 0) {
            return this;

        } else if (res < 0) {
            if (left == null) {
                return null;
            } else {
                return left.search(key);
            }
        } else {
            if (right == null) {
                return null;
            } else {
                return right.search(key);
            }
        }
    }

}
