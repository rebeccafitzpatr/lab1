
/**
 * SE283 Assignment 1 Task 1 Reflector - Instructions
 *  
 * This class should be implemented to contain the reflection functionality described in the
 * assignment hand-out. 
 * This class must be called by T1Main for executing the desired reflection for a given class e.g. class Counter. * 
 * All changes required for Task 1 must be performed on a new branch named "T1Branch". 
 * You can create this new branch from our IDE.
 * 
 * @author Author Name: [YOUR NAME] Author UPI: [YOUR UPI]
 * @version Date: [CURRENT DATE] 
 */
import java.lang.reflect.*;

 public class Reflector {

  public void findMethods(String className) {
    try {
      Class c = Class.forName(className);

      Object instance = c.getConstructor().newInstance();

      Field[] fields = c.getDeclaredFields();
      for (Field field : fields) {
        field.setAccessible(true);
        if (Modifier.isPublic(field.getModifiers())) {
          System.out.println("Name: " + field.getName() + ", Value: " + field.get(instance));
        }
      }
      Method[] m = c.getDeclaredMethods();

      for (int i = 0; i < m.length; i++) {
        if (m[i].toString().contains("()")) {
          System.out.println(m[i].getName());
        }
      }
    } catch (Throwable e) {
      System.err.println(e);
    }
  }
 }