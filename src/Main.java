import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size: ");
        int size = s.nextInt();

        String regex = "^(?=.{2,}[a-z])(?=.{2,}[A-Z])(?=.{2,}[0-9])(?=.{2,}[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
        String pwd = "";
        final int lowerAscii = 35, highestAscii = 126;

        while (!pwd.matches(regex) && pwd.length() != size) {
            pwd = new Random()
                    // Generates a stream of random integers.
                    .ints(size, lowerAscii, highestAscii)
                    // Maps and converts the integer to a String.
                    .mapToObj(i -> String.valueOf((char)i))
                    // Collects the String objects into a single String.
                    .collect(Collectors.joining());
        }
        System.out.println(pwd);
        s.close();
    }
}