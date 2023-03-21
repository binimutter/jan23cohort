public class Review {
    public static void main(String[] args) {
        System.out.println("Hey there class");
        int num = 24;
        String name = "Melissa";
        char character = 'a';
        double decimals = 24.24;
        boolean something = true;
        float num2 = 24.24f;

        if(num < 15) {
            System.out.println("Less than 15");
        } else {
            System.out.println("Not less than 15");
        }
        // Good for multiple conditions that use the same thing that it is comparing... ie like user in session or user level if it is 2 go here 4 go here and so on

        switch(character) {
            case 'b': 
                System.out.println("This is an b");
                break;
            default:
                System.out.println("This is not the letter we are looking for");
        }
        // Good for if/else but not multiple conditions
        System.out.println(something ? "It's Tuesday" : "Please let it not be Monday");
    }
}
