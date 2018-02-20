package solvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solvo.model.Location;
public interface LocationRepository extends JpaRepository<Location, Long> {

	Location getByName(String name);
}
