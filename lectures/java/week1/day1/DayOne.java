public class DayOne {

	public static void main(String[] args) {
        System.out.println("Whats UP class?");
		System.out.println("Hanging out with the class");

		// Data Types
		int age = 44; // An integer
		double altAge = 44.5; // integer with decimals
		System.out.println(age);
		System.out.println(altAge);
		// System.out.println(age, altAge);
		// System.out.println(age + altAge);
		System.out.printf("%s and %s", age,altAge);
		System.out.print(age + "\n" + altAge);
		char test = 'a';
		String myString = "This is a string";
		hi();
		String name = "Melissa";
		int num = 24;
		System.out.println(favNum(name, num));
		if(num < 15) {
			System.out.println("less than 15");
		}
		else if(num < 25) {
			System.out.println("less than 25");
		} 
		else if(num < 30) {
			System.out.println("less than 30");
		} else {
			System.out.println("Big number");
		}
	}
	public static void hi() {
		System.out.println("\nHello my old friends.");
	}
	// Function called favNum that will return something after accepting 2 arguments
	// The return statement that is returning a string that is formated and using the passed in arguments
	// Both returns will work...just not at the same time please.
	public static String favNum(String name, int num) {
		// return String.format("Hey everyone guess what? " + name + " has a favorite number of " + num);
		return "Hey everyone guess what? " + name + " has a favorite number of " + num;
	}
	// 1-100
	// divisible by 3 print fizz
    // divisible by 5 print buzz
    // divisible by both print fizz buzz
    // else just print the number
}
// all if statements will be checked. If else is where it will check the if and then else if, stopping when it finds a true else if