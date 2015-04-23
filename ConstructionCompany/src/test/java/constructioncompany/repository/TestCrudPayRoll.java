package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.domain.PayRoll;
import constructioncompany.respository.PayRollRepository;
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
public class TestCrudPayRoll {
    private String code;

    @Autowired
    PayRollRepository repository;

    @Test
    public void testCreate() throws Exception {

        List<PayRoll> payRolls = new ArrayList<PayRoll>();
        PayRoll payRoll = new PayRoll.Builder(01).payCode("PSC03").receiverCode("SC03").amount(20000.00).build();
        repository.save(payRoll);
        code = payRoll.getPayCode();
        Assert.assertNotNull(payRoll.getPayCode());
    }

    @Test
    public void testUpdate() throws Exception {

        PayRoll payRoll = repository.findOne(code);
        PayRoll newPayRoll = new PayRoll.Builder(03).payCode("PSC04").amount(10000.00).receiverCode("SC04").build();
        repository.save(newPayRoll);
        Assert.assertEquals("PSC04", payRoll.getPayCode());
        Assert.assertEquals(10000.00, payRoll.getAmount());
    }

    @Test
    public void testDelete() throws Exception {
        PayRoll payRoll = repository.findOne(code);
        repository.delete(payRoll);
        PayRoll newPayRoll = repository.findOne(code);
        Assert.assertNull(newPayRoll);
    }

    @Test
    public void testRead() throws Exception {
        PayRoll payRoll = repository.findOne(code);
        Assert.assertEquals("SC03", payRoll.getReceiverCode());
    }
}
