package solvo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqlite.core.DB;
import solvo.model.DbInfo;
import solvo.model.Load;
import solvo.model.Location;
import solvo.repository.LocationRepository;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationRepository locationRepository;

	@Autowired
	public LocationServiceImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public void save(Location location) {
		locationRepository.save(location);
	}

	@Override
	public Location getByName(String name) {
		return locationRepository.getByName(name);
	}

	@Override
	public Integer count(String name) {
		return null;
	}

	@Override
	public void exportXML() {
		try {
			List<Location> locationList = locationRepository.findAll();
			JAXBContext context = JAXBContext.newInstance(DbInfo.class);


			Marshaller m = context.createMarshaller();

			File file = new File("employee.xml");
			DbInfo dbInfo  =new DbInfo();
			dbInfo.setLocations(locationList);
				m.marshal( dbInfo , file );





		} catch (Exception e){
			System.out.println("Ошибка при экспорте");
			e.printStackTrace();
		}

	}

}
