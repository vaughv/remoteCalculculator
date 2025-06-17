import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator stub = (Calculator) registry.lookup("CalculatorService");

            System.out.println("Addition: " + stub.add(10.0, 5.0));
            System.out.println("Subtraction: " + stub.subtract(10.0, 5.0));
            System.out.println("Multiplication: " + stub.multiply(10.0, 5.0));
            System.out.println("Division: " + stub.divide(10.0, 5.0));

            System.out.println("Do this Yourself");
			
			
			// Stores two numbers
            double num1, num2;

           // Take input from the user
           Scanner sc = new Scanner(System.in);

          System.out.println("Enter the numbers:");

          // Take the inputs
          num1 = sc.nextDouble();
          num2 = sc.nextDouble();

          System.out.println("Enter the operator (+,-,*,/):");

          char op = sc.next().charAt(0);
          double o = 0;

            switch (op) {
              // case to add two numbers
              case '+':
                o = stub.add(num1, num2);
                break;

              // case to subtract two numbers
              case '-':
                o = stub.subtract(num1, num2);
                break;

              // case to multiply two numbers
              case '*':
                o = stub.multiply(num1, num2);
                break;

              // case to divide two numbers
                case '/':
                o = stub.divide(num1, num2);
                break;

              default:
                System.out.println("You enter wrong input");
            }

            System.out.println("The final result:");
            System.out.println();

            // print the final result
            System.out.println(num1 + " " + op + " " + num2 + " = " + o);
						   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
