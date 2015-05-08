package constructioncompany.respository;

import constructioncompany.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    public Address findByaddressCode(String addressCode);
}
