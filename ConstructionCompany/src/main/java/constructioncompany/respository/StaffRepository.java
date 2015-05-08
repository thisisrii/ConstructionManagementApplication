package constructioncompany.respository;

import constructioncompany.domain.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Repository
public interface StaffRepository extends CrudRepository<Staff, String> {
    public Staff findBystaffCode(String staffCode);
}
