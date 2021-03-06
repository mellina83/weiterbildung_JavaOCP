package pak01_functional;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		this("Hans", 55);
	}
	
	public Person(String name) {
		this(name, 55);
		System.out.println("Konstruktor von Person wird ausgefuehrt");
	}
	
	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
