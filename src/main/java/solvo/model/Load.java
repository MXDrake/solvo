package solvo.model;

import com.sun.istack.internal.NotNull;
import org.springframework.context.annotation.Primary;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "load")
public class Load {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="name", nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "load_id")
	private Location location;

	public Load(){

	}

	public Load(Location location){
		this.location = location;
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
}
