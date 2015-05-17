package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.conf.factory.ArtisanFactory;
import constructioncompany.conf.factory.SafetyInspFactory;
import constructioncompany.conf.factory.SiteFactory;
import constructioncompany.domain.Site;
import constructioncompany.domain.Staff;
import constructioncompany.respository.SiteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void create() throws Exception {
        Map<String, String> values = new HashMap<String, String>();
        values.put("addressCode", "AF111");
        values.put("siteName", "Foreshore, Cape Town");
        values.put("siteCode", "F111");

        Map<String, String> artisanValues = new HashMap<String, String>();
        artisanValues.put("name", "Michael");
        artisanValues.put("surname", "James");
        artisanValues.put("skill", "Plasterer");
        artisanValues.put("addressCode", "AA01");
        artisanValues.put("IDnumber", "8201234564085");
        artisanValues.put("payCode", "APC01");
        artisanValues.put("staffCode", "SA02");
        artisanValues.put("phone", "0723331122");
        Staff artisan = ArtisanFactory.createArtisan(values);

        Map<String, String> inspectorValues = new HashMap<String, String>();
        inspectorValues.put("name", "Michael");
        inspectorValues.put("surname", "David");
        inspectorValues.put("qualification", "ND Safety and Health");
        inspectorValues.put("institute", "Northlink");
        inspectorValues.put("addressCode", "ASI01");
        inspectorValues.put("IDnumber", "8201234564085");
        inspectorValues.put("payCode", "ASI01");
        inspectorValues.put("staffCode", "SI03");
        inspectorValues.put("phone", "0723331122");
        Staff inspector = SafetyInspFactory.createSafetyInsp(values);

        List<Staff> staffmembers = new ArrayList<Staff>();
        staffmembers.add(artisan);
        staffmembers.add(inspector);

        Site site = SiteFactory.createSite(3000, values, null, null);
        repository.save(site);
        code = site.getSiteCode();
        Assert.assertNotNull(site.getSiteCode());

    }

    @Test
    public void read() throws Exception {
        Site site = repository.findBysiteCode("F111");
        Assert.assertEquals("Foreshore, Cape Town", site.getSiteName());
    }

    @Test
    public void update() throws Exception {

        Site site = repository.findBysiteCode("F111");
        Map<String, String> values = new HashMap<String, String>();
        values.put("addressCode", "MC111");
        values.put("siteName", "Mikes Cafe");
        values.put("siteCode", "N12");
        Site newSite = SiteFactory.createSite(300, values, null, null);
        repository.delete(site);
        repository.save(newSite);
        Assert.assertNotEquals("Mikes Cafe", site.getSiteName());
        Assert.assertNotEquals(300, site.getSiteSize());

    }

    @Test
    public void delete() throws Exception {
        Site site = repository.findBysiteCode("N12");
        repository.delete(site);
        Site newSite = repository.findBysiteCode("N12");
        Assert.assertNull(newSite);

    }

}
