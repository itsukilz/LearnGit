import static org.junit.Assert.*;

import org.junit.Test;

public class SLListTest {

    @Test
    public void testSLList() {
        SLList p = new SLList(3);
    }


    @Test
    public void testAddFirst() {
        SLList p = new SLList(2);
        p.addFirst(3);
        p.addFirst(4);
        p.print();
        //expected 4 3 2
    }


    @Test
    public void testAddLast() {
        SLList p = new SLList(2);
        p.addLast(3);
        p.addLast(4);
        p.print();

        // expected 2 3 4
    }

    @Test
    public void testPrint() {
        SLList p = new SLList(2);
        p.addFirst(3);
        p.addLast(1);
        p.print();

        // expected 1 2 3
    }

    /** declare a null SLList and test addLast() */
    @Test
    public void testNullSLListAddLast() {
        SLList p = new SLList();
        p.addLast(3);
        p.print();
        //expect 3
    }

    /** declare a null SLList and test addFirst() */
    @Test
    public void testNullSLListAddFirst() {
        SLList p = new SLList();
        p.addFirst(3);
        p.print();
        //expect 3
    }

    /** test sentinelNode when SLList is null */
    @Test
    public void testSentinelNode() {
        SLList p = new SLList();
        p.addLast(3);
        p.print();
        //expect 3
    }
}