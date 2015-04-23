package constructioncompany.respository;

import constructioncompany.domain.Site;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public interface SiteRepository extends CrudRepository<Site, String>{
    public Site findByCode(String code);
}
