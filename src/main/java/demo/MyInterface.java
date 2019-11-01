package demo;

public interface MyInterface {

  String m1();

  default int m2() {
    m6();
    return 8;
  }

  private void m6() {
    System.out.println("jkhsdfkjhsd");
  }

  default int m5() {
    m6();
    return 1;
  }



  private static double m3() {
    return 0.0;
  }
}
