package constructioncompany.respository;

import constructioncompany.domain.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Repository
public interface SiteRepository extends CrudRepository<Site, String>{
    public Site findBysiteCode(String siteCode);
}
