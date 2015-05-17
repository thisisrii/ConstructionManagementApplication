package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.conf.factory.SubContractorFactory;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<String, String> values = new HashMap<>();
        values.put("contractorCode", "SC02");
        values.put("addressCode", "SCA02");
        values.put("name", "Gareth's Plumbing");
        values.put("speciality", "Plumbing");

        SubContractor subContractor = SubContractorFactory.createSubContractor(values);
        repository.save(subContractor);
        code = subContractor.getContractorCode();
        Assert.assertNotNull(subContractor.getId());
    }

    @Test
    public void testRead() throws Exception {
        SubContractor subContractor = repository.findBycontractorCode("SC02");
        Assert.assertEquals("Gareth's Plumbing", subContractor.getName());

    }

    @Test
    public void testUpdate() throws Exception {
        SubContractor subContractor = repository.findBycontractorCode("SC02");
        Map<String, String> values = new HashMap<>();
        values.put("contractorCode", "SC03");
        values.put("addressCode", "SCA03");
        values.put("name", "Mikes's Plumbing");
        values.put("speciality", "Plumbing");
        SubContractor newSubContractor = SubContractorFactory.createSubContractor(values);
        repository.delete(subContractor);
        repository.save(newSubContractor);
        Assert.assertNotEquals("Mike's Plumbing", subContractor.getName());
        Assert.assertNotEquals("SC03", subContractor.getContractorCode());
    }

    @Test
    public void testDelete() throws Exception {
        SubContractor subContractor = repository.findBycontractorCode("SC03");
        repository.delete(subContractor);
        SubContractor newSubContractor = repository.findBycontractorCode("SC02");
        Assert.assertNull(newSubContractor);

    }
}
