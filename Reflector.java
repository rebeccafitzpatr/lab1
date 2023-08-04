
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
import java.util.ArrayList;

  

 public class Reflector {
  private Object instance;

  public void createInstance(String className) {
      try {
      Class c = Class.forName(className);

      instance = c.getConstructor().newInstance();
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  public ArrayList<String> findMethods(String className) {
    ArrayList<String> methodNames = new ArrayList<String>();
    try {
      Class c = Class.forName(className);

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
          methodNames.add(m[i].getName());

        }
      }
    } catch (Throwable e) {
      
      System.err.println(e);
    }
    return methodNames;
  }

  public void runMethod(String methodName) {
    try {
      Method method = instance.getClass().getMethod(methodName);
      method.invoke(instance);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      
      e.printStackTrace();
    } catch (IllegalArgumentException e) {

      e.printStackTrace();
    } catch (InvocationTargetException e) {
      
      e.printStackTrace();
    }

    
  }


 }