package solvo.config;

import solvo.model.Location;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlModel {

	private List<Location> locations;

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}
