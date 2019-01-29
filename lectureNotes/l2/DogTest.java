public class DogTest{
	public void bark(){
		System.out.println("Moo");
	}
	public static void runFast(){
		System.out.println("Ruff Run");
	}
	
	public static void main(String[] args) {
		DogTest poppa = new DogTest();
 		poppa.bark();
 		//Dog.bark();
 		poppa.runFast();
 		DogTest.runFast();
	}
 }