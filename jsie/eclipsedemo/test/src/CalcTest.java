
import java.util.Random;

import junit.framework.TestCase;

/**
 * Created on 4 févr. 2005
 * 
 * @author jsie
 */

public class CalcTest extends TestCase {

    private Calc c;

    private Random rand;

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        c = new Calc();
        rand = new Random(1234);
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testReturnSeven() {
        if (c.returnSeven() != 7)
            throw new AssertionError();
    }

    public void testAdd() {
        int a = rand.nextInt();
        int b = rand.nextInt();

        int result = c.add(a, b);
        if (result != (a + b))
            throw new AssertionError();
    }

    public void testSub() {
        int a = rand.nextInt();
        int b = rand.nextInt();

        int result = c.sub(a, b);
        if (result != (a - b))
            throw new AssertionError();
    }

    public void testGetMemory() {
        if (c.getMemory() != 0)
            throw new AssertionError();
    }

    public void testSetMemory() {
        int a = rand.nextInt();
        c.setMemory(a);
        if (c.getMemory() != a)
            new AssertionError();
    }

}