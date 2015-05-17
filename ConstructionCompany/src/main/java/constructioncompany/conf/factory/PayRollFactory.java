package constructioncompany.conf.factory;

import constructioncompany.domain.PayRoll;

import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class PayRollFactory {

    public static PayRoll createPayRoll(double amt, Map<String, String> values){

        PayRoll payroll = new PayRoll.Builder(values.get("payCode")).amount(amt).receiverCode(values.get("receiverCode"))
                .build();

        return payroll;
    }
}
