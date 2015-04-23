package constructioncompany.respository;

import constructioncompany.domain.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public interface AddressRepository extends CrudRepository<Address, String> {
    public Address findByCode(String code);
}
