public class DogLauncher {
	public static void main(String[] args) {
		Dog d1 = new Dog(20);
		Dog d2 = new Dog(8);

		Dog maxdog = Dog.maxDog(d1,d2);
		maxdog.makeNoise();
	}
}