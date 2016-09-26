package workHours.entities;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.repository.CrudRepository;


public interface JobSeekerDAO extends CrudRepository<JobSeeker, Long> {
    Iterable<JobSeeker> findAll();
}
