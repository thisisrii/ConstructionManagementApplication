package constructioncompany.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public class PayRollTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testPayRoll() throws Exception {
        PayRoll payRoll = new PayRoll.Builder("PSC02").amount(50000.00).receiverCode("SC02").build();
        Assert.assertEquals("PSC02", payRoll.getPayCode());

    }
}
