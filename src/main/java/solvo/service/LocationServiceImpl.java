package solvo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solvo.config.XmlModel;
import solvo.model.Location;
import solvo.repository.LocationRepository;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

	private final JAXBContext context = JAXBContext.newInstance(XmlModel.class);

	private final Marshaller marshaller = context.createMarshaller();

	private LocationRepository locationRepository;

	@Autowired
	public LocationServiceImpl(LocationRepository locationRepository) throws JAXBException {
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
	public void exportXML(String fileName) {
		try {
			List<Location> locationList = locationRepository.findAll();
			File file = new File(fileName + ".xml");
			XmlModel xmlModel = new XmlModel();
			xmlModel.setLocations(locationList);
			marshaller.marshal(xmlModel, file);
			System.out.println("Экспорт завершен");
		} catch (Exception e) {
			System.out.println("Ошибка при экспорте");
			e.printStackTrace();
		}
	}
}
