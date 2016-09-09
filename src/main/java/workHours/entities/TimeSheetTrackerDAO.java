package workHours.entities;

import org.springframework.data.repository.CrudRepository;
import java.util.Calendar;

import javax.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeSheetTrackerDAO extends CrudRepository<TimeSheetTracker, Long> {
//    TimeSheetTracker findsByEmail(String email);
    Iterable<TimeSheetTracker> findAll();

}

