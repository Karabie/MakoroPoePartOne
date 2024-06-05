/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rc.makoropoepartone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kmmak
 */
public class MakoroPoePartOneTest {
    
    public MakoroPoePartOneTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class MakoroPoePartOne.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MakoroPoePartOne.main(args);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class MakoroPoePartOne.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        MakoroPoePartOne.createUser();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class MakoroPoePartOne.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        MakoroPoePartOne.registerUser();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class MakoroPoePartOne.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        MakoroPoePartOne.loginUser();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of runTask method, of class MakoroPoePartOne.
     */
    @Test
    public void testRunTask() {
        System.out.println("runTask");
        MakoroPoePartOne.runTask();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of menu method, of class MakoroPoePartOne.
     */
    @Test
    public void testMenu() {
        System.out.println("menu");
        int expResult = 0;
        int result = MakoroPoePartOne.menu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of displayTotalTasks method, of class MakoroPoePartOne.
     */
    @Test
    public void testDisplayTotalTasks() {
        System.out.println("displayTotalTasks");
        MakoroPoePartOne.displayTotalTasks();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnStatus method, of class MakoroPoePartOne.
     */
    @Test
    public void testReturnStatus() {
        System.out.println("returnStatus");
        MakoroPoePartOne.returnStatus();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of returnLongDuration method, of class MakoroPoePartOne.
     */
    @Test
    public void testReturnLongDuration() {
        System.out.println("returnLongDuration");
        String expResult = "";
        String result = MakoroPoePartOne.returnLongDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchTask method, of class MakoroPoePartOne.
     */
    @Test
    public void testSearchTask() {
        System.out.println("searchTask");
        String taskName = "";
        String expResult = "";
        String result = MakoroPoePartOne.searchTask(taskName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTask method, of class MakoroPoePartOne.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        Task[] array = null;
        String taskName = "";
        MakoroPoePartOne.deleteTask(array, taskName);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of showReport method, of class MakoroPoePartOne.
     */
    @Test
    public void testShowReport() {
        System.out.println("showReport");
        MakoroPoePartOne instance = new MakoroPoePartOne();
        instance.showReport();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
