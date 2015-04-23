package constructioncompany.repository;

import constructioncompany.App;
import constructioncompany.domain.Address;
import constructioncompany.respository.AddressRepository;
import org.hibernate.hql.internal.ast.tree.AssignmentSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudAddress {
    private String code;

    @Autowired
    AddressRepository repository;

    @Test
    public void testCreate() throws Exception {
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address.Builder(01).addressCode("ASC03").number(1).street("7th Avenue").subCity("Kensington")
                .city("Cape Town").province("Western Cape").country("South Africa").areaCode(7925).build();
        repository.save(address);
        code = address.getAddressCode();
        Assert.assertNotNull(address);

    }

    @Test
    public void testRead() throws Exception {
        Address address = repository.findOne(code);
        Assert.assertEquals("ASC03", address.getAddressCode());
    }

    @Test
    public void testUpdate() throws Exception {
        Address address = repository.findOne(code);
        Address newAddress = new Address.Builder(02).addressCode("ASC04").number(5).street("Kirst Avenue")
                .subCity("Belville").city("Cape Town").province("Western Cape").country("South Africa")
                .areaCode(7935).build();
        repository.save(newAddress);
        Assert.assertEquals("ASC04", address.getAddressCode());
        Assert.assertEquals("Belville", address.getSubCity());
    }

    @Test
    public void testDelete() throws Exception {
        Address address = repository.findOne(code);
        repository.delete(address);
        Address newAddress = repository.findOne(code);
        Assert.assertNull(newAddress);
    }
}
