public class StringsArrays {
    public static void main(String[] args) {
        String lucy = "Poor Lucy got hurt again.";
        System.out.println(lucy.length());

        String string1 = "My name is ";
        String string2 = "Melissa";
        String string3 = string1.concat(string2);
        System.out.println(string3);
        // will output My name is Michael

        String ninja = "Welcome to Coding Dojo!";
        int a = ninja.indexOf("Coding"); // a is 11
        int b = ninja.indexOf("co"); // b is 3
        int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found
        System.out.println(ninja.length());
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        String sentence = "   spaces everywhere!   ";
        System.out.println(sentence.trim());

        String d = "HELLO";
        String e = "world";
        System.out.println(d.toLowerCase()); // hello
        System.out.println(e.toUpperCase()); // WORLD

        // Normal string assignment
        String f = "same string";
        String g = "same string";
        System.out.println(f == g); // true
        System.out.println(f.equals(g));
        // Creating new strings as separate objects (another way to create a String)
        f = new String("same letters");
        g = new String("same letters");
        System.out.println(f == g); // false. Not the same object in memory.
        System.out.println(f.equals(g)); // true. same exact characters.

        public void typeCast(){
            // explicit big to small
            // implicit small to big
            int x = 33;
            byte b = (byte)x;
            System.out.println(x);
        }
        int[] myArray;  // creating a iteger array var
        myArray = new int[5]; // actually creating the array and stating its length
        myArray[3] = 6; // providing a value to the 3rd index of thw array
        // System.out.println(myArray);
    }
}
