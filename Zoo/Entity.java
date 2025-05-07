package Zoo;

public class Entity extends Animal {
	boolean flag = true;

	public void addAnimal(String name, int age, int weight, String sound, String sepcialBehaviour) {
		setName(name);
		setAge(age);
		setWeight(weight);
		setSound(sound);
		setSepcialBehaviour(sepcialBehaviour);
	}

	public void addAnimal(String name, int age, int weight, String sound) {
		setName(name);
		setAge(age);
		setWeight(weight);
		setSound(sound);
		flag = false;
	}

	public void info() {
		System.out.println("Name\t: " + getName());
		System.out.println("Age\t: " + getAge());
		System.out.println("Weight\t: " + getWeight());
		System.out.println("Sound\t: " + getSound());
		if (flag) {
			System.out.println("Sepcial Bhaviour\t: " + getSepcialBehaviour());
		}
	}
}
