package workHours.entities;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by perrythomson on 9/16/16.
 */
public interface JobSeekerDAO extends CrudRepository<JobSeeker, Long> {
    Iterable<JobSeeker> findAll();
}
