package constructioncompany.respository;

import constructioncompany.domain.PayRoll;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public interface PayRollRepository extends CrudRepository<PayRoll, String> {
    public PayRoll findByCode(String code);
}
