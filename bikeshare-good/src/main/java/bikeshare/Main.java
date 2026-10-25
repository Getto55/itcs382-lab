package bikeshare;

import bikeshare.cli.CliMenu;
import bikeshare.repository.CsvRideSaver;
import bikeshare.repository.RideSaver;
import bikeshare.service.BikeShareService;

public class Main {
    public static void main(String[] args) {
        RideSaver rideSaver = new CsvRideSaver("rides.csv");
        BikeShareService service = new BikeShareService(rideSaver);
        CliMenu menu = new CliMenu(service);
        
        menu.start();
        System.out.println("Goodbye!");
    }
}