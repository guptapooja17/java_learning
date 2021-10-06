package lamdaPrograms;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlatMap {
	public static void main (String[] args) {

		List<City> l1 = new LinkedList<>();
		l1.add(new City("Indore","5767889"));
		l1.add(new City("Singapre","987654"));
		l1.add(new City("Sihor","2345"));
		l1.add(new City("Sehgaon","123"));
		l1.add(new City("Kokan","23423465"));
		l1.add(new City(null,"23423465"));
		l1.add(new City("Mumbai","53456746"));

		City.printCities1(l1);
		System.out.println("_________________________");
		City.printCities(l1);
	}
}

class City {

	String location;
	String zip;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public City(String location, String zip) {
		this.location = location;
		this.zip = zip;
	}

	public City() {
	}

	@Override
	public String toString() {
		return "location = " + location + "\t" + "Zip = " + zip;
	}
	
	public static void printCities1(List<City> listOfCity) {
		listOfCity.stream().flatMap(cities -> Stream.of(cities.getLocation()))
		.map(locations -> Optional.ofNullable(locations).orElse("Default Location"))
		.forEach(locations -> System.out.println(locations));
	}

	public static void printCities(List<City> listOfCity) {
		listOfCity.stream().flatMap(cities -> Stream.of(cities.getLocation())).map(locations -> CompletableFuture.supplyAsync( () -> locations.startsWith("S"))).
		map(CompletableFuture::join).forEach(locations -> System.out.println(locations));

	}	
	
}
