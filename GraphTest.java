/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastián
 */
public class GraphTest {
    

    /**
     * Test of addEdge method, of class Graph.
     *
    @Test
    public void testAddEdge() {
        System.out.println("addEdge");
        String line = "";
        Graph instance = new Graph();
        instance.addEdge(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distBetweenNodes method, of class Graph.
     */
    @Test
    public void testDistBetweenNodes() {
        System.out.println("distBetweenNodes");
        String city1 = "pana";
        String city2 = "guatemala";
        Graph instance = new Graph();
        instance.addEdge("guatemala pana 300");
        int expResult = 300;
        int result = instance.distBetweenNodes(city1, city2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("");
    }

    /**
     * Test of deleteEdge method, of class Graph.
     *
    @Test
    public void testDeleteEdge() {
        System.out.println("deleteEdge");
        String city1 = "";
        String city2 = "";
        Graph instance = new Graph();
        instance.deleteEdge(city1, city2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Graph.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String city = "pana";
        Graph instance = new Graph();
        boolean expResult = false;
        boolean result = instance.contains(city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Graph.
     *
    @Test
    public void testToString_0args() {
        System.out.println("toString");
        Graph instance = new Graph();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Graph.
     *
    @Test
    public void testToString_String_String() {
        System.out.println("toString");
        String city1 = "";
        String city2 = "";
        Graph instance = new Graph();
        String expResult = "";
        String result = instance.toString(city1, city2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of floydAlgorithm method, of class Graph.
     *
    @Test
    public void testFloydAlgorithm() {
        System.out.println("floydAlgorithm");
        Graph instance = new Graph();
        instance.floydAlgorithm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCenter method, of class Graph.
     
    @Test
    public void testGetCenter() {
        System.out.println("getCenter");
        Graph instance = new Graph();
        String expResult = "";
        String result = instance.getCenter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    
    }
    * */
    
}
