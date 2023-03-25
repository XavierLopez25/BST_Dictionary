package JUnit;

import Model.Association;
import Model.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The type Binary tree test.
 */
class BinaryTreeTest {

    /**
     * Test insert and search.
     */
    @Test
    public void testInsertAndSearch() {

        BinaryTree tree = new BinaryTree();
        Association<String, String> asc1 = new Association<>("apple", "manzana");
        Association<String, String> asc2 = new Association<>("banana", "plátano");
        Association<String, String> asc3 = new Association<>("cherry", "cereza");
        Association<String, String> asc4 = new Association<>("date", "dátil");
        Association<String, String> asc5 = new Association<>("elderberry", "saúco");

        // Test that inserts the values in the BST
        tree.setData(asc1);
        tree.insert(asc2);
        tree.insert(asc3);
        tree.insert(asc4);
        tree.insert(asc5);

        // Test that the values were inserted correctly and can be found
        assertEquals("manzana", tree.search("apple").getValue().getValue());
        assertEquals("plátano", tree.search("banana").getValue().getValue());
        assertEquals("cereza", tree.search("cherry").getValue().getValue());
        assertEquals("dátil", tree.search("date").getValue().getValue());
        assertEquals("saúco", tree.search("elderberry").getValue().getValue());

    }
}