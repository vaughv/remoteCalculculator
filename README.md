# Java RMI-Based Calculator with GUI

This is a simple distributed calculator application built using **Java RMI (Remote Method Invocation)**. The calculator supports basic arithmetic operations (Addition, Subtraction, Multiplication, Division) and features a **Java Swing GUI** on the client side. All operations are processed remotely by the server.

## 🧩 Project Structure

| File Name            | Description                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| `Calculator.java`     | Remote interface defining arithmetic operations.                           |
| `CalculatorImpl.java` | Implementation of the remote interface.                                    |
| `Server.java`         | RMI server that binds the implementation to the RMI registry.              |
| `Client.java`         | RMI client that connects to the server and invokes remote methods.         |
| `ClientGUI.java`      | Swing-based GUI that interacts with the RMI client.                        |
| `Output.png`          | Screenshot of the running calculator GUI.                                  |
| `remoteCalculator.docx` | Documentation/report of the project (optional for review).                |

## 🚀 Features

- Remote method execution using Java RMI.
- Interactive and user-friendly calculator GUI using Swing.
- Modular design separating interface, implementation, GUI, and networking logic.
- Validates user input and handles exceptions gracefully.

## 🛠️ How to Run

### Prerequisites

- Java JDK (8 or higher)
- RMI Registry (comes with JDK) 
