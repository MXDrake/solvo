package solvo.service;

import solvo.model.Load;
import solvo.model.Location;
import javax.xml.bind.JAXBException;
import java.util.List;
public interface LocationService {

	void save(Location location);
	Location getByName(String name);
	Integer count(String name);
	void exportXML();

}
