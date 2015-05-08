package constructioncompany.respository;

import constructioncompany.domain.PayRoll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Repository
public interface PayRollRepository extends CrudRepository<PayRoll, String> {
    public PayRoll findBypayCode(String payCode);
}
