import java.util.concurrent.atomic.LongAdder;

/**
 * @author Stanislav Rakitov
 */
public class Counter implements Runnable {
  private final int[] array;
  private final LongAdder counter;

  public Counter(int[] array, LongAdder counter) {
    this.array = array;
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int j : array) {
      counter.add(j);
    }
  }
}
