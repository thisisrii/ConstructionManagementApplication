package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.domain.Artisan;
import constructioncompany.domain.SafetyInsp;
import constructioncompany.domain.Staff;
import constructioncompany.respository.StaffRepository;
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
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudStaff {
    private String code;

    @Autowired
    StaffRepository repository;

    @Test
    public void testCreate() throws Exception {

        List<Staff> staff = new ArrayList<Staff>();
        Staff inspector = new SafetyInsp.Builder("College of CT").staffCode("SI01").addressCode("ASI01")
                .payCode("PSI01").IDnumber("8754321234").name("Sipho").surname("Tsa").phone("0723334444")
                .qualification("ND: Safety and PM").build();
        repository.save(inspector);
        code = inspector.getStaffCode();
        Assert.assertNotNull(inspector.getStaffCode());
    }

    @Test
    public void testRead() throws Exception {
        Staff inspector = repository.findOne(code);
        Assert.assertEquals("Sipho", inspector.getName());
    }

    @Test
    public void testUpdate() throws Exception {
        Staff inspector = repository.findOne(code);
        Staff newInspector = new SafetyInsp.Builder("Northlink").IDnumber("9705432910").addressCode("ASI02")
                .name("David").surname("Michael").payCode("PSI02").phone("0798654321").qualification("ND Safety and Health")
                .staffCode("SI02").build();
        repository.save(newInspector);
        Assert.assertEquals("Michael", inspector.getSurname());
        Assert.assertEquals("SI02", inspector.getStaffCode());
    }

    @Test
    public void testDelete() throws Exception {
        Staff inspector = repository.findOne(code);
        repository.delete(inspector);
        Staff newInspector = repository.findOne(code);
        Assert.assertNull(newInspector);
    }
}
