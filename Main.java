

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    

    Reflector reflector = new Reflector();

    
    
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    
      System.out.println("Enter username");

      String className = scanner.nextLine();  // Read user input

      reflector.createInstance(className);

      while (true) {
      ArrayList<String> methodNames = reflector.findMethods(className);
      
      System.out.println("Enter a method to run:");
      String methodName = scanner.nextLine();
      if (isMemberOf(methodNames, methodName) ) {
        reflector.runMethod(methodName);
      }
    }
  }

  public static boolean isMemberOf(ArrayList<String> items, String target) {
    for (String item: items ) {
      if (item.equals(target)) {
        return true;
      }
    }

    return false;
  
  }
}