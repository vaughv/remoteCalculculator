import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            CalculatorImpl calc = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", calc);
            System.out.println("CalculatorService is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
