package constructioncompany.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public class SiteTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testSite() throws Exception {
        Site site = new Site.Builder("E123").addressCode("AE123").siteSize(40000).siteName("New Eastern Hotel").build();
        Assert.assertEquals("New Eastern Hotel", site.getSiteName());

    }
}
