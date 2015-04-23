package constructioncompany.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public class SubContractorTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testSubContractor() throws Exception {
        SubContractor subContractor = new SubContractor.Builder(10).name("Martin and East").speciality("Civil Engineering")
                .addressCode("SCA01").contractorCode("SC01").build();
        Assert.assertEquals("Martin and East", subContractor.getName());


    }
}
