

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    

    Reflector reflector = new Reflector();
    
    
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    while (true) {
      System.out.println("Enter username");

      String className = scanner.nextLine();  // Read user input
      


      reflector.findMethods(className);
    }
  }
}