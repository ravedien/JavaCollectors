package util;

import java.util.List;

import model.Person;

public class DataUtil {

	public static List<Person> createPersons(){
		return List.of(
				new Person("Heather", "Nurse", 1),
				new Person("Diarmuid", "IT", 2),
				new Person("Buddha", "IT", 36),
				new Person("Dembu", "Nurse", 34),
				new Person("Monmon", "Accounting", 32),
				new Person("Menre", null, 30),
				new Person("Bebot", "IT", 27),
				new Person("Bebot", "Farmer", 17)
		);
	}
	
}
