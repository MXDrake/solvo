package solvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import solvo.model.Load;
import solvo.model.Location;
import solvo.service.LoadService;
import solvo.service.LoadServiceImpl;
import solvo.service.LocationService;
import solvo.service.LocationServiceImpl;

@SpringBootApplication
public class Application  {




	public static void main(String[] args) {

//		SpringApplication.run(Application.class, args);

		ApplicationContext ctx =
			SpringApplication.run(Application.class, args);
//	  		String[] beanNames = ctx.getBeanDefinitionNames();
//	  		    Arrays.sort(beanNames);
//	  		    System.out.println("***********************");
//	  		    for (String beanName : beanNames) {
//	  		        System.out.println(beanName);
//	  		    }
//	  		    System.out.println("***********************");

		LoadService loadService =
			ctx.getBean("loadServiceImpl", LoadServiceImpl.class);

		LocationService locationService =
			ctx.getBean("locationServiceImpl", LocationServiceImpl.class);

		Location location = new Location();
		location.setName("home");
		locationService.save(location);

		Load load = new Load();
		load.setName("Max");
		load.setLoad(location);
		loadService.save(load);




	}


}
