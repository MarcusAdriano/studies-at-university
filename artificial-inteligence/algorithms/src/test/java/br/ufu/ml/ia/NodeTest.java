package br.ufu.ml.ia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    private Node<Integer> root;

    @Before
    public void setUp() throws Exception {
        /* make new tree */
        root = new Node<>(1);
        Node<Integer> child2 = new Node<>(2);
        Node<Integer> child3 = new Node<>(3);
        Node<Integer> child4 = new Node<>(4);

        root.addChild(child2);
        root.addChild(child3);
        root.addChild(child4);

        Node<Integer> child31 = new Node<>(5);
        child3.addChild(child31);

        /*
         *              Tree is:
         *
         *                  1
         *                / | \
 *                       2  3 4
         *                  |
*                           5
         */
    }

    @Test
    public void getChildren() {
        Node child2 = root.getChildren().get(0);
        assertEquals(2, ((int) child2.getData()));
    }

    @Test
    public void addChild() {
        Node<Integer> test = new Node<>(50);
        root.addChild(test);

        int lastChild = root.getChildren().size() - 1;
        assertEquals(root.getChildren().get(lastChild), test);
    }

    @Test
    public void getData() {
        assertEquals((int) root.getData(), 1);
    }

    @Test
    public void setData() {
        root.setData(500);
        assertEquals((int) root.getData(), 500);
    }

    @Test
    public void isRoot() {
        assertTrue(root.isRoot());
    }

    @Test
    public void isLeaf() {
        Node<Integer> child3 = root.getChildren().get(1);
        Node leaf = child3.getChildren().get(0);
        assertTrue(leaf.isLeaf());
    }

    @Test
    public void removeParent() {
        Node child3 = root.getChildren().get(1);
        child3.removeParent();
        assertTrue(child3.isRoot());
    }
}