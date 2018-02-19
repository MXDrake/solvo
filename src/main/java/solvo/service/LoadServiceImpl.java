package solvo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solvo.model.Load;
import solvo.repository.LoadRepository;

@Service
public class LoadServiceImpl implements LoadService {


	@Autowired
	LoadRepository loadRepository;


	@Override
	public void save(Load load) {
		loadRepository.save(load);
		System.out.println("Сохранил");
	}
}
