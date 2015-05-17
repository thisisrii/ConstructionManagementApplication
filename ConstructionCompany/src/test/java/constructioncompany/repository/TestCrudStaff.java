package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.conf.factory.ArtisanFactory;
import constructioncompany.conf.factory.SafetyInspFactory;
import constructioncompany.domain.SafetyInsp;
import constructioncompany.domain.Staff;
import constructioncompany.respository.StaffRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudStaff {
    private String code;

    @Autowired
    StaffRepository repository;

    @Test
    public void create() throws Exception {

        Map<String, String> values = new HashMap<String, String>();
        values.put("name", "Michael");
        values.put("surname", "James");
        values.put("skill", "Plasterer");
        values.put("addressCode", "AA01");
        values.put("IDnumber", "8201234564085");
        values.put("payCode", "APC01");
        values.put("staffCode", "SA01");
        values.put("phone", "0723331122");

        Staff artisan = ArtisanFactory.createArtisan(values);
        repository.save(artisan);
        code = artisan.getStaffCode();
        Assert.assertNotNull(artisan.getStaffCode());
    }

    @Test
    public void read() throws Exception {
        Staff inspector = repository.findBystaffCode("SA01");
        Assert.assertEquals("Michael", inspector.getName());
    }

    @Test
    public void update() throws Exception {
        Staff artisan = repository.findBystaffCode("SA01");
        Map<String, String> values = new HashMap<String, String>();
        values.put("name", "Michael");
        values.put("surname", "David");
        values.put("qualification", "ND Safety and Health");
        values.put("institute", "Northlink");
        values.put("addressCode", "ASI01");
        values.put("IDnumber", "8201234564085");
        values.put("payCode", "ASI01");
        values.put("staffCode", "SA01");
        values.put("phone", "0723331122");

        Staff newInspector = SafetyInspFactory.createSafetyInsp(values);
        repository.delete(artisan);
        repository.save(newInspector);
        Assert.assertNotEquals("David", artisan.getSurname());
        Assert.assertNotEquals("SA02", artisan.getStaffCode());
    }

    @Test
    public void delete() throws Exception {
        Staff inspector = repository.findBystaffCode("SA01");
        repository.delete(inspector);
        Staff newInspector = repository.findBystaffCode("SA01");
        Assert.assertNull(newInspector);
    }
}
