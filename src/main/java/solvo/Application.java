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

	private static final String HELP =
			"Команды: \n Добавление грузов в ячеку : Add [Кол-во грузов] [Имя ячейки]   \n " + "Показать" + " " +
			"содержание ячеек : Show [Имя ячейки1] [Имя ячейки2] ... \n Экспорт базы в xml: Export [Имя файла] \n" +
			" Выход из программы : Exit \n Помощь: Help \r";

	public static void main(String[] args) throws JAXBException {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		LoadService loadService = ctx.getBean("loadServiceImpl", LoadServiceImpl.class);

		LocationService locationService = ctx.getBean("locationServiceImpl", LocationServiceImpl.class);

		Scanner scanner = new Scanner(System.in);
		String command;
		String leftAlignFormat = "| %-28s | %-17s |%n";

		System.out.println(HELP);

		while (!(command = scanner.next()).equalsIgnoreCase("exit")) {
			switch (command.toUpperCase()) {
				case "ADD": {
					try {
						Scanner scannerAddLine = new Scanner(scanner.nextLine());
						int count = scannerAddLine.nextInt();
						String locationName = scannerAddLine.next();
						Location location = locationService.getByName(locationName);
						if (location == null) {
							location = new Location(locationName);
							locationService.save(location);
						}
						for (int i = 0; i < count; i++) {
							loadService.save(new Load(location));
						}
						System.out.println("Груз добавлен");

					} catch (Exception e) {
						System.out.println("Неверный формат");
					}
					break;
				}
				case "SHOW": {
					Scanner scannerLocationName = new Scanner(scanner.nextLine());
					System.out.format("+            Ячейка            | Кол-во грузов     +%n");
					while (scannerLocationName.hasNext()) {
						String locationName = scannerLocationName.next();
						Location location = locationService.getByName(locationName);
						if (location != null) {
							System.out.format(leftAlignFormat, location.getName(), loadService.count(location));
						} else {
							System.out.format(leftAlignFormat, locationName, "ячейка не найдена");
						}
					}
					System.out.format("+--------------------------------------------------+%n");
					break;
				}
				case "HELP": {
					System.out.println(HELP);
					break;
				}
				case "EXPORT": {
					Scanner scannerFileName = new Scanner(scanner.nextLine());
					if (scannerFileName.hasNext()) {
						String fileName = scannerFileName.next();

						locationService.exportXML(fileName);
					} else {
						System.out.println("Введите имя файла");
					}
					break;
				}
				default:
					scanner.nextLine();
			}
		}
	}
}
