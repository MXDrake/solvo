package solvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solvo.model.Load;
import org.springframework.data.repository.CrudRepository;
import solvo.model.Location;
public interface LoadRepository extends JpaRepository<Load, Long> {

	Integer countByLocation(Location location);
}
