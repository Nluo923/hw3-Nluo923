import org.junit.Test;
import org.junit.Before;

import DataStructures.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class DataStructuresTests {

    MyPriorityQueue pq;
    @Before
    public void init() {
        pq = new MyPriorityQueue();
    }

    /** Adds and removes one item. **/
    @Test
    public void insertOne() {
        pq.insert("Axolotl", 100);
        assertEquals("Size should be 1", 1, pq.size());
        assertEquals("Max item should be \"Axolotl\" when peeking.",
                "Axolotl", pq.peek());
        assertEquals("Max item should be \"Axolotl\" when removing.",
                "Axolotl", pq.removeMax());
    }

   /** Create more tests here! The above test is not comprehensive. */
   @Test
   public void insertTest() {
       pq.insert("Axolotl", 100);
       pq.insert("Axolotl", 100);
       pq.insert("Axolotl", 100);
       pq.insert("Axolotl", 100);
       pq.insert("Axolotl", 100);
       assertEquals("Size should be 1", 1, pq.size());
       assertEquals("Max item should be \"Axolotl\" when peeking.",
               "Axolotl", pq.peek());
       assertEquals("Max item should be \"Axolotl\" when removing.",
               "Axolotl", pq.removeMax());
   }
}
