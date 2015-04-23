package constructioncompany.domain;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public class StaffTest {

    @Before()
    public void setUp() throws Exception {
        

    }

    @Test
    public void testStaff() throws Exception {
        Staff artisan = new Artisan.Builder("Plastering").IDnumber("9705432910").addressCode("AA01")
                .name("David").surname("Michael").payCode("PA01").phone("0798654321").staffCode("A01").build();
        Assert.assertEquals("David", artisan.getName());
    }
}
