public class SwitchTernary {
    public static void main(String[] args) {
        int day = 2;
        day = 5;
        int altDay = 2;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("There are only seven days in a week...");
        }
        // boolean isRaining = true;
        boolean isRaining = false;
            
        // if(isRaining) {
        //     System.out.println("Bring an umbrella.");
        // }
        // else {
        //     System.out.println("Have fun!");
        // }
        System.out.println(isRaining ? "Bring an umbrella" : "Have fun!");

    }
}
