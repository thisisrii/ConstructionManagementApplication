package constructioncompany.services.Impl;

import constructioncompany.domain.SubContractor;
import constructioncompany.respository.SubContractorRepository;
import constructioncompany.services.SubContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Service
public class SubContractorServiceImpl implements SubContractorService {
    @Autowired
    SubContractorRepository repository;
    public List<SubContractor> getSubContractors(){
        List<SubContractor> allSubContractors = new ArrayList<SubContractor>();

        Iterable<SubContractor> subContractors = repository.findAll();
        for (SubContractor subContractor : subContractors){
            allSubContractors.add(subContractor);
        }

        return allSubContractors;
    }


}
