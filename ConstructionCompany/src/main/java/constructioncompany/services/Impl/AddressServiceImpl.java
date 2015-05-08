package constructioncompany.services.Impl;

import constructioncompany.domain.Address;
import constructioncompany.respository.AddressRepository;
import constructioncompany.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository repositoryAddress;
    public List<Address> getAddresses() {
        List<Address> allAddresses = new ArrayList<Address>();

        Iterable<Address> addresses  = repositoryAddress.findAll();
        for (Address address : addresses){
            allAddresses.add(address);
        }
        return allAddresses;
    }

}
