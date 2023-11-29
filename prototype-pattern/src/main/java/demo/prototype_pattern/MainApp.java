package demo.prototype_pattern;

import demo.prototype_pattern.prototype.LeaveRequestWorkFlow;
import demo.prototype_pattern.impls.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {

	private static Logger log = LoggerFactory.getLogger(MainApp.class.getName());

	public static void main(String[] args) throws Exception {

		log.info(" >> Start Apps for Chain of Responsibility Pattern ... ");
		log.info(" ------------------------------------------------------------------------------");
		Computer computer1 = new Computer("Window 10", "Word 2013", "BKAV", "Chrome v69", "Skype");
		Computer computer2 = computer1.clone();
		computer2.setOthers("Skype, Teamviewer, FileZilla Client");

		System.out.println(computer1);
		System.out.println(computer2);

		log.info(" ------------ FINISH -------------");


	}

}
