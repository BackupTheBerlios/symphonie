import java.util.Collection;

import junit.framework.TestCase;
/**
 * Created on 4 févr. 2005
 *@author jsie
 */

public class GroupTest extends TestCase {

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /*
     * Class under test for void Group(String)
     */
    public void testGroupString() {
        Group g = new Group("un");
        if(g.getParent() != null)
            fail("parent not null");
        if(g.getName() != "un")
            fail("name");
    }

    /*
     * Class under test for void Group(Group, String)
     */
    public void testGroupGroupString() {
        Group g1 = new Group("un");
        Group g2 = new Group(g1,"deux");
        if(g2.getParent() != g1)
            fail("invalid parent");
        if(g2.getName() != "deux")
        	fail("invalid group name");
        if(!g1.getSubGroups().contains(g2))
            fail("g2 not in subgroups");
    }

    public void testGetName() {
        Group g = new Group("un");
        if(g.getName() != "un")
            fail("wrong group name");
    }

    public void testGetParent() {
        Group g1 = new Group("un");
        Group g2 = new Group(g1,"deux");
        if(g2.getParent() != g1)
            fail("wrong parent");
    }

    public void testAddSubGroup() {

        Group g = new Group("un");
        Group g2 = new Group("deux");
        g.addSubGroup(g2);
        
        Collection c = (Collection)g.getSubGroups();
        if(c.size() != 1)
            fail("wrong size");
        if(!c.contains(g2))
            fail("g2 not included into group");
        
        if(g2.getParent() != g)
            fail("g1 is not parent");
    }

    /*
     * Class under test for void getSubGroups()
     */
    public void testGetSubGroups() {
        Group g1 = new Group("un");
        Group g2 = new Group(g1,"deux");
        Group g3 = new Group("trois");
        
        Collection c = g1.getSubGroups();
        if(!c.contains(g2))
            fail("g2 not in subgroup");
        g1.addSubGroup(g3);
        if(!c.contains(g3))
            fail("g3 not in subgroup");
        if(g3.getParent() != g1)
            fail("wrong parent for g3");
        
    }

    /*
     * Class under test for void getSubGroups(String)
     */
    public void testGetSubGroupsString() {
        Group g1 = new Group("un");
        Group g2 = new Group(g1,"uno");
        Group g3 = new Group("una");
        
        Collection c = g1.getSubGroups("un");
        if(!c.contains(g2))
            fail("g2 not in subgroup");
        g1.addSubGroup(g3);
        if(!c.contains(g3))
            fail("g3 not in subgroup");
        if(g3.getParent() != g1)
            fail("wrong parent for g3");
    }

}
