package constructioncompany.conf.factory;

import constructioncompany.domain.Site;
import constructioncompany.domain.Staff;
import constructioncompany.domain.SubContractor;

import java.util.List;
import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class SiteFactory {

    public static Site createSite(int size, Map<String, String> values, List<Staff> staff, List<SubContractor> subcontractors){
        Site site = new Site.Builder(values.get("siteCode")).siteSize(size).addressCode(values.get("addressCode")).siteName(values.get("siteName"))
                .staff(staff).subContractors(subcontractors).build();

        return site;
    }

}
