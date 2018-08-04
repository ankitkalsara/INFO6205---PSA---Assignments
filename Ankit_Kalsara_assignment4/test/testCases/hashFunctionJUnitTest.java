/*
 * 2018 - Ankit Kalsara
 */
package testCases;

import assignment4.Assignment4;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ankit
 */
public class hashFunctionJUnitTest {
    
    public hashFunctionJUnitTest() {
    }
    
    @Test
    public void testHashFunction() {
        Assignment4 test1 = new Assignment4();
        int hashValue1 = test1.hash(919, 20);
        assertEquals(19, hashValue1,1);
        int hashValue2 = test1.hash(764,50);
        assertEquals(14, hashValue2,1);
        int hashValue3 = test1.hash(957,100);
        System.out.println(hashValue3);
        assertEquals(57, hashValue3,1);
    }
    
    @Test
    public void testCollectorProblem(){
        Assignment4 test2 = new Assignment4();
        test2.myArray = new int[20];
        test2.counterArray = new int[20];
        test2.calculate(test2.myArray, 0, 0);
        assertEquals(59.914,test2.globalB0,50);
    }    
    
    @Test
    public void testCountBalls(){
        Assignment4 test3 = new Assignment4();
        test3.myArray = new int[10];
        test3.counterArray = new int[10];
        test3.calculate(test3.myArray, 0, 0);        
        assertEquals(1, test3.counterArray[1]);
    }
}