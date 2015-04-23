package constructioncompany.respository;

import constructioncompany.domain.SubContractor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public interface SubContractorRepository extends CrudRepository<SubContractor, String> {
    public SubContractor findByCode(String code);
}
