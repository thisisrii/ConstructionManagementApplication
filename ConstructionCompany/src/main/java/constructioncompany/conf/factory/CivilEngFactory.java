package constructioncompany.conf.factory;

import constructioncompany.domain.CivilEng;

import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class CivilEngFactory {

    public static CivilEng createCivilEng(Map<String, String> values){

        CivilEng civil = new CivilEng.Builder(values.get("university")).addressCode(values.get("addressCode"))
                .IDnumber(values.get("IDnumber")).name(values.get("name")).payCode(values.get("payCode"))
                .phone(values.get("phone")).qualification(values.get("qualification"))
                .staffCode(values.get("staffCode")).surname(values.get("staffCode")).build();

        return civil;
    }

}
