package collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Person;
import util.DataUtil;

public class CollectorTest {

	public static void main(String[] args) {
		List<Person> persons = DataUtil.createPersons();
		
		groupingBy(persons);
		partitioningBy(persons);
		collectJoining(persons);
		collectToMap(persons);
		collectToList(persons);
		reduceConcat(persons);
		reduceSummation(persons);
	}
	
	

	private static void groupingBy(List<Person> persons) {
		Map<String, List<Person>> result = persons.stream()
			.collect(Collectors.groupingBy(Person::getName));
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() +" " + result);
	}



	//Applicable only for splitting to two parts only
	private static void partitioningBy(List<Person> persons) {
		Map<Boolean, List<Person>> result = persons.stream()
			.collect(Collectors.partitioningBy(person -> person.getAge() % 2 == 0));
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() +" " + result);
	}

	private static void collectJoining(List<Person> persons) {
		String result = persons.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(Collectors.joining(", "));
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() +" " + result);
	}

	private static void collectToMap(List<Person> persons) {
		Map<String, Integer> result = persons.stream()
				.collect(Collectors.toUnmodifiableMap(
						Person::getName, 
						Person::getAge, 
						(person1, person2) -> person1)); // resolves duplicate key
																														// duplicate
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() +" " + result);
	}

	private static void collectToList(List<Person> persons) {
		List<String> result = persons.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toUnmodifiableList());
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() +" " + result);
	}

	private static void reduceConcat(List<Person> persons) {
		Optional<String> result = persons.stream().map(Person::getName).map(String::toUpperCase)
				.reduce((names, name) -> names + " " + name);
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() +" " + result);
	}

	private static void reduceSummation(List<Person> persons) {
		int result = persons.stream().map(Person::getAge)
//				.reduce(0, (total, age) -> total + age));
//				.reduce(0, (total, age) -> Integer.sum(total, age)));
				.reduce(0, Integer::sum);
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() +" " + result);
	}

}
