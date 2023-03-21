public class NewCode {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Integer sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        long end = System.currentTimeMillis();
        double total = (double) (end - start) / 1000;
        System.out.println("Time of execution: " + total + " seconds");

        boolean isRaining = true;
        boolean isCold = true;
        if(isRaining && isCold) {
            System.out.println("Bring an umbrella, Wear a coat..");
        }
        else if(isRaining) {
            System.out.println("Bring an umbrella.");
        }
        else if(isCold) {
            System.out.println("Wear a coat.");
        }
        else {
            System.out.println("Have fun!");
}
    }
}
