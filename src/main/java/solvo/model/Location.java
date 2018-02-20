package solvo.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;
@Entity
@Table(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

	@XmlAttribute
	@Column(name = "name")
	private String name;

	public Location() {
	}

	@OneToMany(mappedBy = "location", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Load> loads;

	public Location(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Location location = (Location) o;

		if (id != null ? !id.equals(location.id) : location.id != null)
			return false;
		if (name != null ? !name.equals(location.name) : location.name != null)
			return false;
		return loads != null ? loads.equals(location.loads) : location.loads == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (loads != null ? loads.hashCode() : 0);
		return result;
	}
}
