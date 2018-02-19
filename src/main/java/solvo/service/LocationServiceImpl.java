package solvo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solvo.model.Location;
import solvo.repository.LocationRepository;

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
}
