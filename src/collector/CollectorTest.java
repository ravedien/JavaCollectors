package collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Person;
import util.DataUtil;

public class CollectorTest {

	public static void main(String[] args) {
		List<Person> persons = DataUtil.createPersons();
		
//		calculateAge(persons);
		
//		concatNames(persons);
		
//		collectNames(persons);
		
		collectToMap(persons);
	}

	private static void collectToMap(List<Person> persons) {
		System.out.println(
			persons.stream()
				.collect(
					Collectors.toUnmodifiableMap(
							Person::getName, 
							Person::getAge, 
							(person1,person2) -> person1)) // resolves duplicate
				);
	}

	private static void collectNames(List<Person> persons) {
		System.out.println(
				persons.stream()
					.map(Person::getName)
					.map(String::toUpperCase)
					.collect(Collectors.toUnmodifiableList())
				);		
	}

	private static void concatNames(List<Person> persons) {
		System.out.println(
			persons.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.reduce((names,name) -> names + " " + name)
		);
	}

	private static void calculateAge(List<Person> persons) {
		System.out.println(persons.stream()
				.map(Person::getAge)
//				.reduce(0, (total, age) -> total + age));
//				.reduce(0, (total, age) -> Integer.sum(total, age)));
				.reduce(0, Integer::sum));
	}

}
