import java.util.ArrayList;

public class IceCreamParlor {
    public void sellIceCream() {
        System.out.println("1 ice cream sold");
    }
    public void createArrayList() {
        ArrayList<String> flavors = new ArrayList<>();
        flavors.add("Raspberry");
        flavors.add("Chocolate");
        flavors.add("Cookies and Cream");
        flavors.add("Rocky Road");

        // for flavor in flavors
        // for item in flavors
        for(String item : flavors){
            System.out.println(item);
        }
    }
    public void orderIceCream(String flavor) {
        if(flavor.toLowerCase().equals("rocky road")) {
            System.out.println("That is free on the house today..");
        }
        else if (flavor.toUpperCase().equals("CHOCOLATE")) {
            System.out.println("$1 please");
        }
        else {
            System.out.println("$2 please");
        }
    }
    String[] daysWeek = { "Sunday", "Monday", "Tuesday", "Wed", "Thurs", "Fri", "Sat" };

}
