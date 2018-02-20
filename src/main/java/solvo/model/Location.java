package solvo.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Entity
@Table(name = "location")
@XmlRootElement
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "location", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Load> loads;


	public Location() {

	}

	public Location(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
