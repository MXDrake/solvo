package solvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solvo.model.Load;
import solvo.model.Location;
public interface LoadRepository extends JpaRepository<Load, Long> {

	Integer countByLocation(Location location);
}
