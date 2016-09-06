package workHours.entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by perrythomson on 9/2/16.
 */
public interface EmployeeDAO extends CrudRepository<Employee, Long> {
    Iterable<Employee> findAll();
//    List<Employee> findByEmployeeID;
}
