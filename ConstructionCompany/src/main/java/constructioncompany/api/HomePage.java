package constructioncompany.api;

import constructioncompany.domain.Site;
import constructioncompany.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yusiry Davids on 4/22/2015.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private SiteService service;
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/site", method = RequestMethod.GET)
    public Site getSite(){
        Site site = new Site.Builder("E123").siteName("New Eastern Hotel").siteSize(40000).addressCode("AE123").build();

        return site;
    }

    @RequestMapping(value = "/sites", method = RequestMethod.GET)
    public List<Site> getSites(){
        return service.getSites();
    }
}
