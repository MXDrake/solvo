package solvo.service;

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
		load.setName("Груз-");
		loadRepository.save(load);
		load.setName(load.getName() + load.getId());
		loadRepository.save(load);
	}

	@Override
	public Integer count(Location location) {
		return loadRepository.countByLocation(location);
	}

}
