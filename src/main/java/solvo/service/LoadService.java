package solvo.service;

import solvo.model.Load;
import solvo.model.Location;
public interface LoadService {

	void save(Load load);
	Integer count(Location location);
	Load getByName(String name);
}
