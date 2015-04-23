package constructioncompany.services.Impl;

import constructioncompany.domain.PayRoll;
import constructioncompany.respository.PayRollRepository;
import constructioncompany.services.PayRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Service
public class PayRollServiceImpl implements PayRollService {

    @Autowired
    PayRollRepository repository;
    public List<PayRoll> getPayRoll(){
        List<PayRoll> allPayroll = new ArrayList<PayRoll>();

        Iterable<PayRoll> payRolls = repository.findAll();
        for (PayRoll payroll : payRolls){
            allPayroll.add(payroll);
        }
        return  allPayroll;
    }
}
