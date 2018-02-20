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
import javax.xml.bind.JAXBException;
import java.util.Scanner;

@SpringBootApplication
public class Application {

	static final String help =
			"Команды: \n Добавление грузов в ячеку : Добавить [Кол-во грузов] [Имя ячейки]   \n " + "Показать" + " " +
			"содержание ячеек : Показать [Имя ячейки1] [Имя ячейки2] ... \n Выход из программы : Выход \n Помощь: " +
			"help \r";

	public static void main(String[] args) throws JAXBException {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
//	  		String[] beanNames = ctx.getBeanDefinitionNames();
//	  		    Arrays.sort(beanNames);
//	  		    System.out.println("***********************");
//	  		    for (String beanName : beanNames) {
//	  		        System.out.println(beanName);
//	  		    }
//	  		    System.out.println("***********************");

		LoadService loadService = ctx.getBean("loadServiceImpl", LoadServiceImpl.class);

		LocationService locationService = ctx.getBean("locationServiceImpl", LocationServiceImpl.class);

		Scanner scanner = new Scanner(System.in);
		String command = "";
		String leftAlignFormat = "| %-28s | %-17s |%n";

		System.out.println(help);

		while (!(command = scanner.next()).equalsIgnoreCase("выход")) {
			switch (command.toUpperCase()) {
				case "ДОБАВИТЬ": {
					try {
						int count = scanner.nextInt();
						String locationName = scanner.next();
						Location location = locationService.getByName(locationName);
						if (location == null) {
							location = new Location(locationName);
							locationService.save(location);
						}
						for (int i = 0; i < count; i++) {
							loadService.save(new Load(location));
						}
						break;
					} catch (Exception e) {
						System.out.println("Неверный формат");
					}
				}
				case "ПОКАЗАТЬ": {
					Scanner scannerLocationName = new Scanner(scanner.nextLine());
					System.out.format("|            Ячейка            | Кол-во грузов     |%n");
					while (scannerLocationName.hasNext()) {
						String locationName = scannerLocationName.next();
						Location location = locationService.getByName(locationName);
						if (location != null) {
							System.out.format(leftAlignFormat, location.getName(), loadService.count(location));
						} else {
							System.out.format(leftAlignFormat, locationName, "ячейка не найдена");
						}
					}
					System.out.format("+--------------------------------------------------|%n");
					break;
				}
				case "HELP":{
					System.out.println(help);
				}
				case "EXPORT":{
					//Load load = loadService.get(1l);
					locationService.exportXML();
				}
			}
		}
	}
}
