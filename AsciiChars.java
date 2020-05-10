public class AsciiChars {
    
    public static void printNumbers() {
        for (int i = 0; i < 128; i++) 
            if (Character.isDigit((char)i))
                System.out.print((char)i + " ");
    }

    public static void printLowerCase() {

        for (int i = 0; i < 128; i++) 
            if (Character.isLowerCase((char)i))
                System.out.print((char)i + " ");
    }

    public static void printUpperCase() {
        
        for (int i = 0; i < 128; i++) 
            if (Character.isUpperCase((char)i))
                System.out.print((char)i + " ");
    }

}