package solvo.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solvo.model.Load;
import solvo.model.Location;
import solvo.repository.LoadRepository;

@Service
public class LoadServiceImpl implements LoadService {

	private LoadRepository loadRepository;

	@Autowired
	public LoadServiceImpl(LoadRepository loadRepository) {
		this.loadRepository = loadRepository;
	}

	@Transactional
	@Override
	public void save(Load load) {
		if (loadRepository.getByName(load.getName()) == null) {
			loadRepository.save(load);
		} else {
			load.setName(RandomStringUtils.randomAlphanumeric(10));
			save(load);
		}
	}

	@Override
	public Integer count(Location location) {
		return loadRepository.countByLocation(location);
	}

	@Override
	public Load getByName(String name) {
		return loadRepository.getByName(name);
	}
}
