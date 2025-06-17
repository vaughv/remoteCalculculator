import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientGUI extends JFrame {
    private Calculator stub;

    private JTextField num1Field = new JTextField(10);
    private JTextField num2Field = new JTextField(10);
    private JComboBox<String> operatorBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
    private JButton calculateButton = new JButton("Calculate");
    private JLabel resultLabel = new JLabel("Result: ");

    public ClientGUI() {
        setTitle("RMI Calculator GUI");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            stub = (Calculator) registry.lookup("CalculatorService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to RMI Server:\n" + e.getMessage());
            System.exit(1);
        }

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Enter Number 1:"));
        panel.add(num1Field);
        panel.add(new JLabel("Enter Number 2:"));
        panel.add(num2Field);
        panel.add(new JLabel("Select Operator:"));
        panel.add(operatorBox);
        panel.add(new JLabel(""));
        panel.add(calculateButton);
        panel.add(new JLabel("Output:"));
        panel.add(resultLabel);

        add(panel);

        calculateButton.addActionListener(e -> calculateResult());
    }

    private void calculateResult() {
        try {
            double num1 = Double.parseDouble(num1Field.getText().trim());
            double num2 = Double.parseDouble(num2Field.getText().trim());
            String operator = (String) operatorBox.getSelectedItem();

            double result = switch (operator) {
                case "+" -> stub.add(num1, num2);
                case "-" -> stub.subtract(num1, num2);
                case "*" -> stub.multiply(num1, num2);
                case "/" -> stub.divide(num1, num2);
                default -> throw new UnsupportedOperationException("Invalid operator");
            };

            resultLabel.setText("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Remote operation failed:\n" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientGUI().setVisible(true));
    }
}
  
