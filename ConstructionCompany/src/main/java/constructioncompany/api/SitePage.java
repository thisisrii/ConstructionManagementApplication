package constructioncompany.api;

import constructioncompany.domain.Site;
import constructioncompany.model.SiteResource;
import constructioncompany.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusiry Davids on 5/17/2015.
 */
    @RestController
    @RequestMapping(value="site/**")
    public class SitePage {
        @Autowired
        private SiteService service;
        @RequestMapping(value="/{id}", method= RequestMethod.GET)

        public List<SiteResource> getSites(){
            List<SiteResource> hateos = new ArrayList<>();
            List<Site> sites = service.getSites();
            for(Site site : sites) {
                SiteResource res = new SiteResource
                        .Builder(site.getSiteName())
                        .address(site.getAddressCodeTwo())
                        .sitecode(site.getSiteCode())
                        .staff(site.getStaff())
                        .build();
                Link staff = new Link("http://localhost:8080/site/" + res.getSitecode()
                ).withRel("staff");
                res.add(staff);
                hateos.add(res);
            }

            return hateos;
    }
}
