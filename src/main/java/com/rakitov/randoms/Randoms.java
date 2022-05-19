package com.rakitov.randoms;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Generating random numbers.
 *
 * @author Stanislav Rakitov
 */
public class Randoms {

  /**
   * Generates random integer number.
   *
   * @param min minimum number
   * @param max maximum number (inclusive)
   * @return random int number
   */
  public static int getRandomInt(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  /**
   * Generates an array of random integers.
   *
   * @param min minimum int number
   * @param max maximum int number (inclusive)
   * @param arraySize size of array
   * @return array of random integers
   */
  public static int[] getIntArray(int min, int max, int arraySize) {
    int[] array = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
      array[i] = getRandomInt(min, max);
    }
    return array;
  }


}
