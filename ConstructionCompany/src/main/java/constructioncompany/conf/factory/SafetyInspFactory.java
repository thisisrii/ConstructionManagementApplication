package constructioncompany.conf.factory;

import constructioncompany.domain.SafetyInsp;

import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class SafetyInspFactory {


    public static SafetyInsp createSafetyInsp(Map<String, String> values){

        SafetyInsp safety = new SafetyInsp.Builder(values.get("institute")).addressCode(values.get("addressCode"))
                .IDnumber(values.get("IDnumber")).name(values.get("name")).payCode(values.get("payCode"))
                .phone(values.get("phone")).qualification(values.get("qualification"))
                .staffCode(values.get("staffCode")).surname(values.get("staffCode")).build();

        return safety;
    }
}
