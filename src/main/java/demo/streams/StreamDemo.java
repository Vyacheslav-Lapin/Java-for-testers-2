package demo.streams;

import java.util.Arrays;

public class StreamDemo {

  public static void main(String... __) {
    Arrays.stream(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            .split("\\s"))
        .map(String::length)
        .max(Integer::compareTo)
        .ifPresent(System.out::println);
  }
}
