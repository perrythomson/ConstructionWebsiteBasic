package workHours.entities;

import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

@Transactional
public interface AdminDAO extends CrudRepository<Admin, Long> {
    Iterable<Admin> findAll();

}
