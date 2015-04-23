package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.domain.SubContractor;
import constructioncompany.respository.SubContractorRepository;
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
public class TestCrudSubContractor {

    private String code;

    @Autowired
    SubContractorRepository repository;

    @Test
    public void testCreate() throws Exception {

        List<SubContractor> subContractors = new ArrayList<SubContractor>();
        SubContractor subContractor = new SubContractor.Builder(02).contractorCode("SC02").addressCode("SCA02")
                .name("Gareth's Plumbing").speciality("Plumbing").build();
        repository.save(subContractor);
        code = subContractor.getContractorCode();
        Assert.assertNotNull(subContractor.getId());
    }

    @Test
    public void testRead() throws Exception {
        SubContractor subContractor = repository.findOne(code);
        Assert.assertEquals("Gareth's Plumbing", subContractor.getName());

    }

    @Test
    public void testUpdate() throws Exception {
        SubContractor subContractor = repository.findOne(code);
        SubContractor newSubContractor = new SubContractor.Builder(03).contractorCode("SC03").addressCode("SCA03")
                .name("Mike's Plumbing").speciality("Plumbing").build();
        repository.save(newSubContractor);
        Assert.assertEquals("Mike's Plumbing", subContractor.getName());
        Assert.assertEquals("SC03", subContractor.getContractorCode());
    }

    @Test
    public void testDelete() throws Exception {
        SubContractor subContractor = repository.findOne(code);
        repository.delete(subContractor);
        SubContractor newSubContractor = repository.findOne(code);
        Assert.assertNull(newSubContractor);

    }
}
