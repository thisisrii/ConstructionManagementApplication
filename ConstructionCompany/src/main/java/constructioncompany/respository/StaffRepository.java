package constructioncompany.respository;

import constructioncompany.domain.Staff;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public interface StaffRepository extends CrudRepository<Staff, String> {
    public Staff findByCode(String code);
}
