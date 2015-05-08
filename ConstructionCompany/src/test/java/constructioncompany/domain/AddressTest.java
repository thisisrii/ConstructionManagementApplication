package constructioncompany.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public class AddressTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testAddress() throws Exception {
        Address address = new Address.Builder("ASC01").number(5).street("Kirst Avenue")
                .subCity("Belville").city("Cape Town").province("Western Cape").country("South Africa")
                .areaCode(7935).build();
        Assert.assertEquals("Kirst Avenue", address.getStreet());

    }
}
