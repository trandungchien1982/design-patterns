package demo.chainofresp_pattern;

import demo.chainofresp_pattern.chainofresp.LeaveRequestWorkFlow;
import demo.chainofresp_pattern.impls.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {

	private static Logger log = LoggerFactory.getLogger(MainApp.class.getName());

	public static void main(String[] args) {

		log.info(" >> Start Apps for Chain of Responsibility Pattern ... ");
		log.info(" ------------------------------------------------------------------------------");
		Approver mainApprover = LeaveRequestWorkFlow.getApprover();

		log.info(" ---------------------------------------------");
		mainApprover.approveLeave(new LeaveRequest(2));

		log.info(" ---------------------------------------------");
		mainApprover.approveLeave(new LeaveRequest(5));

		log.info(" ---------------------------------------------");
		mainApprover.approveLeave(new LeaveRequest(7));

		log.info(" ------------ FINISH -------------");
	}

}
