package solvo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solvo.model.Load;
import solvo.model.Location;
import solvo.repository.LoadRepository;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

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

	@Override
	public void exportXML(Load load) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Load.class);
		Marshaller m = context.createMarshaller();
		m.marshal(load, new File("employee.xml"));
	}

	@Override
	public Load get(Long id) {
		return loadRepository.findOne(id);
	}
}
