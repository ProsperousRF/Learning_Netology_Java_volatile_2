import java.util.concurrent.Callable;

/**
 * @author Stanislav Rakitov
 */
public class Counter implements Callable<Integer> {
  private int sum;
  private final int[] array;

  public Counter(int[] array) {
    this.array = array;
  }

  @Override
  public Integer call() {
    for (int j : array) {
      sum += j;
    }
    return sum;
  }
}