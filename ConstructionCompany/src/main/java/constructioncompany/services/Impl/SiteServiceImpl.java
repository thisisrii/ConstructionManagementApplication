package constructioncompany.services.Impl;

import constructioncompany.domain.Site;
import constructioncompany.respository.SiteRepository;
import constructioncompany.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusiry Davids on 4/22/2015.
 */
@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    SiteRepository repository;
    public List<Site> getSites(){
        List<Site> allSites = new ArrayList<Site>();

        Iterable<Site> sites = repository.findAll();
        for (Site site : sites){
            allSites.add(site);
        }
        return allSites;
    }


}
