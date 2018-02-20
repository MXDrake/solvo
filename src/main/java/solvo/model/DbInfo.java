package solvo.model;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;
@XmlRootElement
public class DbInfo {

	@XmlAnyAttribute
	private Map<Location, Boolean> locations;



	public void setLocations(List<Location> locations) {
		for (int i = 0; i < locations.size(); i++) {
		this.locations.put(locations.get(i), true)	;
		}

	}
}
