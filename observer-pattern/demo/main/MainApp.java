package demo.main;

import demo.base.Observer;
import demo.impls.Observer01;
import demo.impls.Observer02;
import demo.impls.Observer03;
import demo.impls.SubjectTopic;

import java.util.logging.Logger;

public class MainApp {

  static Logger log = Logger.getLogger(MainApp.class.getName());

  public static void main(String[] args) {
    log.info(" >> Start Apps for Observer ... ");

    Observer subscriber01 = new Observer01();
    Observer subscriber02 = new Observer02();
    Observer subscriber03 = new Observer03();

    SubjectTopic sTopic = new SubjectTopic();
    sTopic.attach(subscriber01);
    sTopic.attach(subscriber02);
    sTopic.attach(subscriber03);
    sTopic.publish("The message 01 from Topic ... ");

    log.info(" ------------- Remove subscriber02 out of list of subscribers ---------- ");
    sTopic.detach(subscriber02);
    sTopic.publish("New message IX from Topic ... ");
    log.info(" ------------ FINISH -------------");
  }


}