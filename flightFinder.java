import java.util.*;
import java.io.*;

public class flightFinder {
    ArrayList<City> Cities = new ArrayList<City>();
    City From;
    City To;

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);    
        BufferedReader cities; 
        BufferedReader flights;
        String cityFileName;
        String flightFileName;

        try {
            System.out.println("Please enter the City File:");
            cityFileName = input.nextLine();
            cities = new BufferedReader(new FileReader(cityFileName));
            String name;
            while((name = cities.readLine()) != null) {
                Cities.add(new City(name));
            }
            System.out.println("Please enter the flight File:");
            flightFileName = input.nextLine();
            flights = new BufferedReader(new FileReader(flightFileName));
            String[] line;
            City start = null;
            City end = null;
            while((name = flights.readLine()) != null) {
               line = name.split(",");
               start = Search(line[0]);
               end = Search(line[1].trim());
               start.addFlightTo(end, Integer.parseInt(line[2].trim()));
            }
            
            
            
            cities.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static City Search(String city) {
        int low = 0;
        int high = Cities.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if(Cities.get(mid).name.compareTo(city) < 0) {
                low = mid - 1;
            }
            else if (Cities.get(mid).name.compareTo(name) > 0) {
                high = mid - 1;
            }
            else {
                return Cities.get(mid);
            }
        }
        return null;
    }
}
