package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.conf.factory.PayRollFactory;
import constructioncompany.domain.PayRoll;
import constructioncompany.respository.PayRollRepository;
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
public class TestCrudPayRoll {
    private String code;

    @Autowired
    PayRollRepository repository;

    @Test
    public void testCreate() throws Exception {

        Map<String, String> values = new HashMap<>();
        values.put("payCode", "PSC03");
        values.put("receiverCode", "SC03");
        PayRoll payRoll = PayRollFactory.createPayRoll(20000.00, values);
        repository.save(payRoll);
        code = payRoll.getPayCode();
        Assert.assertNotNull(payRoll.getPayCode());
    }

    @Test
    public void testRead() throws Exception {
        PayRoll payRoll = repository.findBypayCode("PSC03");
        Assert.assertEquals("SC03", payRoll.getReceiverCode());
    }

    @Test
    public void testUpdate() throws Exception {

        PayRoll payRoll = repository.findBypayCode("PSC03");
        Map<String, String> values = new HashMap<>();
        values.put("payCode", "PSC04");
        values.put("receiverCode", "SC04");
        PayRoll newPayRoll = PayRollFactory.createPayRoll(10000.00, values);
        repository.delete(payRoll);
        repository.save(newPayRoll);
        Assert.assertNotEquals("PSC04", payRoll.getPayCode());
        Assert.assertNotEquals(10000.00, payRoll.getAmount());
    }

    @Test
    public void testDelete() throws Exception {
        PayRoll payRoll = repository.findBypayCode("PSC04");
        repository.delete(payRoll);
        PayRoll newPayRoll = repository.findBypayCode("PSC04");
        Assert.assertNull(newPayRoll);
    }


}
