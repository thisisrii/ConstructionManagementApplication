package constructioncompany.conf.factory;

import constructioncompany.domain.SiteForeman;

import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class SiteForemanFactory {


    public static SiteForeman createSiteForeman(Map<String, String> values){

        SiteForeman siteforeman = new SiteForeman.Builder(values.get("university")).addressCode(values.get("addressCode"))
                .IDnumber(values.get("IDnumber")).name(values.get("name")).payCode(values.get("payCode"))
                .phone(values.get("phone")).qualification(values.get("qualification"))
                .staffCode(values.get("staffCode")).surname(values.get("staffCode")).build();

        return siteforeman;
    }
}
