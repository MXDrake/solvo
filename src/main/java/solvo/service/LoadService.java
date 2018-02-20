package solvo.service;

import solvo.model.Load;
import solvo.model.Location;
import javax.xml.bind.JAXBException;
public interface LoadService {

	void save(Load load);
	Integer count(Location location);
}
