package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.domain.Site;
import constructioncompany.respository.SiteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudSite {

    private String code;

    @Autowired
    SiteRepository repository;

    @Test
    public void testCreate() throws Exception {
        List<Site> sites = new ArrayList<Site>();
        Site site = new Site.Builder("F111").siteName("Foreshore, Cape Town").siteSize(3000).addressCode("AF111").build();
        repository.save(site);
        code = site.getSiteCode();
        Assert.assertNotNull(site.getSiteCode());

    }

    @Test
    public void testRead() throws Exception {
        Site site = repository.findOne(code);
        Assert.assertEquals("Foreshore, Cape Town", site.getSiteName());
    }

    @Test
    public void testUpdate() throws Exception {

        Site site = repository.findOne(code);
        Site newSite = new Site.Builder("D1").siteName("Mikes Cafe").siteSize(300).addressCode("N12").build();
        repository.save(newSite);
        Assert.assertEquals("Mikes Cafe", site.getSiteName());
        Assert.assertEquals(300, site.getSiteSize());

    }

    @Test
    public void testDelete() throws Exception {
        Site site = repository.findOne(code);
        repository.delete(site);
        Site newSite = repository.findOne(code);
        Assert.assertNull(newSite);

    }
}