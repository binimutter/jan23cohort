import java.util.ArrayList;
import java.util.Date;

public class Dog {
    public static int dogCount = 0;
    public static ArrayList<Dog> allDogs = new ArrayList<>();

    // using a private access modifier meaning it can't be used outside of this class we will need getters and setters to use them
    private String name;
    private String breed;
    private boolean goodDog = true;
    private int age;
    // Homework Challenge: instead of inputting the age of the dog, input the birthdate and then have age be calculated on subtracting the birthdate from today's date
    private boolean houseBroken;
    private Owner owner = new Owner("Melissa"); // Creating a default owner name
    private ArrayList<String> toys = new ArrayList<>(); // Creating a empty list where we can add toys too

    // constructor 
    public Dog(String name, String breed, int age, boolean houseBroken) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.houseBroken = houseBroken;
        Dog.dogCount += 1; // Using the static methods above to increase the dog count every time a new dog is created
        Dog.allDogs.add(this); // Also using the static method above to add the new dog to the list of all dogs created.
    }
    // overloaded constructor
    public Dog(String name, String breed, int age, boolean houseBroken, String ownerName){
        this(name, breed, age, houseBroken);
        this.owner.setOwnerName(ownerName); 
    }

    // getter for the name 
    public String getName(){
        return this.name;
    }
    // setter for the name
    public void setName(String name){
        this.name = name;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getGoodDog(){
        return this.goodDog;
    }
    public void setGoodDog(boolean goodDog) {
        this.goodDog = goodDog;
    }

    public boolean getHouseBroken(){
        return this.houseBroken;
    }

    public void setHouseBroken(boolean houseBroken) {
        this.houseBroken = houseBroken;
    }

    public String getOwner(){
        return this.owner.getOwnerName();
    }
    public void setOwner(String owner) {
        this.owner.setOwnerName(owner); 
    }

    public void giveToy(String toy){
        this.toys.add(toy);
        System.out.printf("%s now has the following toys:%n", this.name);
        for (String t : this.toys) {
            System.out.println(t);   
        }
    }

    public void houseBreak(){
        this.setHouseBroken(true);
    }

    public String stats(){
        return String.format("Stats: %nName: %s%nAge: %s%nHousebroken: %s%nOwner: %s", this.name, this.age, this.houseBroken, this.owner.getOwnerName());
    }

    // static methods
    public static int getDogCount(){
        return Dog.dogCount;
    }

    public static void displayAllDogInfo(){
        for (Dog dog : Dog.allDogs) {
            System.out.println(dog.stats()+"\n");
        }
    }
}
