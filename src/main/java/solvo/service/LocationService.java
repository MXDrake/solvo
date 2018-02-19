package solvo.service;

import solvo.model.Load;
import solvo.model.Location;
import java.util.List;
public interface LocationService {

	void save(Location location);
	void addLoads(Location location, List<Load> loads);

}
