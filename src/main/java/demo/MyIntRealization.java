package demo;

public class MyIntRealization implements My2Interface, MyInterface {

  @Override
  public Integer m4() {
    return null;
  }

  @Override
  public int m2() {
    return MyInterface.super.m2();
  }

  @Override
  public String m1() {
    return null;
  }
}
