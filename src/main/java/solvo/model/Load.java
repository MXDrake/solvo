package solvo.model;

import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "load")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Load {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

	@XmlAttribute
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "load_id")
	@XmlTransient
	private Location location;

	public Load() {
		this.name = RandomStringUtils.randomAlphanumeric(10);
	}

	public Load(Location location) {
		this.location = location;
		this.name = RandomStringUtils.randomAlphanumeric(10);
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

	public Location getLoad() {
		return location;
	}

	public void setLoad(Location load) {
		this.location = load;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Load load = (Load) o;

		if (id != null ? !id.equals(load.id) : load.id != null)
			return false;
		if (name != null ? !name.equals(load.name) : load.name != null)
			return false;
		return location != null ? location.equals(load.location) : load.location == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		return result;
	}
}
