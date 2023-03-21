import java.util.ArrayList;

public class TestIceCreamParlor {
    public static void main(String[] args) {
        IceCreamParlor HoneyBeePlace = new IceCreamParlor();
        IceCreamParlor DanasPlace = new IceCreamParlor();


        HoneyBeePlace.sellIceCream();
        HoneyBeePlace.createArrayList();
        DanasPlace.createArrayList();

        HoneyBeePlace.orderIceCream("chocolate");
        DanasPlace.orderIceCream("ROCKY ROAD");
        HoneyBeePlace.orderIceCream("Raspberry");
        DanasPlace.orderIceCream("Chocolate");
    }
}
