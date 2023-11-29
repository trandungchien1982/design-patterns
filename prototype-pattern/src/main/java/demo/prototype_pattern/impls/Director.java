package demo.prototype_pattern.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Computer implements Cloneable {
  private String os;
  private String office;
  private String antivirus;
  private String browser;
  private String others;

  public Computer(String os, String office, String antivirus, String browser, String other) {
    super();
    this.os = os;
    this.office = office;
    this.antivirus = antivirus;
    this.browser = browser;
    this.others = other;
  }

  @Override
  public Computer clone() {
    try {
      return (Computer) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String toString() {
    return "Computer [os=" + os + ", office=" + office + ", antivirus=" + antivirus + ", browser=" + browser
      + ", others=" + others + "]";
  }

  public void setOthers(String others) {
    this.others = others;
  }
}

public class ITApp {

  public static void main(String[] args) {
    Computer computer1 = new Computer("Window 10", "Word 2013", "BKAV", "Chrome v69", "Skype");
    Computer computer2 = computer1.clone();
    computer2.setOthers("Skype, Teamviewer, FileZilla Client");

    System.out.println(computer1);
    System.out.println(computer2);
  }
}