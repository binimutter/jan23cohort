import java.util.ArrayList;

public class CafeUtil {
    public static int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    public static double getOrderTotal(double[] prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuitems) {
        System.out.println(menuitems);
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.print("Hello " + userName + "!");
        System.out.print("There are " + customers.size() + " people in front of you.");
        customers.add(userName);
        System.out.println(customers);
    }
}
