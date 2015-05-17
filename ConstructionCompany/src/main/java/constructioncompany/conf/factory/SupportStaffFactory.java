package constructioncompany.conf.factory;

import constructioncompany.domain.SupportStaff;

import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class SupportStaffFactory {


    public static SupportStaff createSupportStaff(Map<String, String> values){

        SupportStaff supportstaff = new SupportStaff.Builder(values.get("position")).university(values.get("university"))
                .addressCode(values.get("addressCode"))
                .IDnumber(values.get("IDnumber")).name(values.get("name")).payCode(values.get("payCode"))
                .phone(values.get("phone")).qualification(values.get("qualification"))
                .staffCode(values.get("staffCode")).surname(values.get("staffCode")).build();

        return supportstaff;
    }
}
