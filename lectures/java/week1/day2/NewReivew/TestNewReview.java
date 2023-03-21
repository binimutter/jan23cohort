import java.util.ArrayList;

public class TestNewReview {
    public static void main(String[] args) {
        NewReview shop = new NewReview();

        shop.createArrayList();
        shop.orderFood("Pizza", "Med Basket");

        shop.displayWeek();
    }
}
