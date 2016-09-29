package workHours.entities;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.repository.CrudRepository;


public interface InterestedPartyDAO extends CrudRepository<InterestedParty, Long> {
    Iterable<InterestedParty> findAll();
}
