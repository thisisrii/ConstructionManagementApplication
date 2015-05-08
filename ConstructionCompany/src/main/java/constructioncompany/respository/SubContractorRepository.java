package constructioncompany.respository;

import constructioncompany.domain.SubContractor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Repository
public interface SubContractorRepository extends CrudRepository<SubContractor, String> {
    public SubContractor findBycontractorCode(String contractorCode);
}
