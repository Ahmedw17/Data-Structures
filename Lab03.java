import java.util.Scanner;

public class Lab6 {

   
    public static int sumDigits(int n) {

        
        if (n == 0) {
            return 0;
        }

        
        return (n % 10) + sumDigits(n / 10);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            int result = sumDigits(number);
            System.out.println("Sum of digits = " + result);
        }

        input.close();
    }
}
