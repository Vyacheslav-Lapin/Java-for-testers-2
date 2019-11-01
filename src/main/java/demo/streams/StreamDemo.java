package demo.streams;

import java.util.Arrays;
import java.util.Comparator;

public class StreamDemo {

  public static void main(String... __) {
    Arrays.stream(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            .split("\\s"))
//        .max(Comparator.comparingInt(String::length))
        .sorted(Comparator.comparingInt(String::length).reversed())
        .limit(3)
        .forEachOrdered(System.out::println);
  }
}
