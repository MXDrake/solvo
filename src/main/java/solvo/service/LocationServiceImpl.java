package solvo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solvo.model.Load;
import solvo.model.Location;
import solvo.repository.LocationRepository;
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
	public void addLoads(Location location, List<Load> loads) {
		for (int i = 0; i < loads.size()-1; i++) {

		}
	}

}
