package constructioncompany.conf.factory;

import constructioncompany.domain.SubContractor;

import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class SubContractorFactory {

    public static SubContractor createSubContractor(Map<String, String> values){
        SubContractor sub = new SubContractor.Builder(values.get("contractorCode"))
                .addressCode(values.get("addressCode")).name(values.get("name")).speciality(values.get("speciality"))
                .build();

        return sub;
    }
}
