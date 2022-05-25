import com.rakitov.randoms.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Stanislav Rakitov
 */
public class Main {

  private static final int MAX_TASKS_AND_THREADS = 3;
  private static final int MIN_SALES = 1;
  private static final int MAX_SALES = 10_000;
  private static final int MIN_PRICE = 1;
  private static final int MAX_PRICE = 1_000;

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    List<int[]> arrays = new ArrayList<>();

    // Генерация 3 массивов целых положительных чисел
    for (int i = 0; i < MAX_TASKS_AND_THREADS; i++) {
      arrays.add(
          Randoms.getIntArray(
              Randoms.getRandomInt(MIN_PRICE, MAX_PRICE), // Минимальное значение цены
              Randoms.getRandomInt(MIN_PRICE, MAX_PRICE), // Максимальное значение цены
              Randoms.getRandomInt(
                  MIN_SALES, MAX_SALES))); // Количество продаж (он же размер массива)
    }

    // Атомарная сумма массивов
    LongAdder adder = new LongAdder();

    // Создание трех потоков, которые суммируют выручку (каждый по своему массиву) в общий отчет
    ExecutorService executorService = Executors.newFixedThreadPool(MAX_TASKS_AND_THREADS);

    for (int[] array : arrays) {
      adder.add(executorService.submit(new Counter(array)).get());
    }

    executorService.shutdown();

    System.out.println("Выручка по всем магазинам: " + adder.sum());
  }
}
