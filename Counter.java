
public class Counter {
  public int _ctr;
  public int _multiplier;
  public String word = "pp";
  public String secondWord;
  private int twenty = 20;
  
  //method increments _ctr
  public void increment() {
    _ctr--; //faulty increment
  }
  //method decrements _ctr
  public void decrement() {
    _ctr++; //faulty decrement
  }
  //method resets _ctr
  public void reset() {
    _ctr = 1; //faulty reset, _ctr should rather be 0
  }
  //method multiplies _ctr by a number
  public void multiplyBy(int multiplier) {
    _multiplier = multiplier; //no fault here
    _ctr = _ctr * _multiplier; //no fault here
  }
}