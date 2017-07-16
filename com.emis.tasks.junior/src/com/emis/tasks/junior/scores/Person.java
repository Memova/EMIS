package com.emis.tasks.junior.scores;

import java.util.ArrayList;
import java.util.Random;

public class Person {
	
	protected final static ArrayList<String> possibleNames;
	
	static {
		possibleNames = new ArrayList<String>();
		possibleNames.add("Peter");
		possibleNames.add("George");
		possibleNames.add("Daniel");
		possibleNames.add("John");
		possibleNames.add("Kate");
		possibleNames.add("Sam");
		possibleNames.add("Megan");
		possibleNames.add("Sophie");
		possibleNames.add("Oliver");
		possibleNames.add("James");
	}

	private String name;
	private int age;
	private int score;
	
	public Person() {
		Random randomGenerator = new Random();
		int pick = randomGenerator.nextInt(possibleNames.size());
	    this.name =  possibleNames.get(pick);
	    this.age = randomGenerator.nextInt(60) + 20;
	    this.score = randomGenerator.nextInt(100);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getScore() {
		return score;
	}
}
