package solvo.service;

import solvo.model.Location;
public interface LocationService {
	void save(Location location);
	Location getByName(String name);
	void exportXML(String fileName);
}
