package solvo.model;

import javax.persistence.*;

@Entity
@Table(name = "load")
public class Load {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name ="name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "load_id")
	private Location location;

	public Load(){

	}

	public Load(Location location){
		this.location = location;
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

	public Location getLoad() {
		return location;
	}

	public void setLoad(Location load) {
		this.location = load;
	}
}
