package workHours.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TimeSheetTrackerDAO extends CrudRepository<TimeSheetTrackerDAO, Long> {
    TimeSheetTracker findsByEmail(String email);
}
