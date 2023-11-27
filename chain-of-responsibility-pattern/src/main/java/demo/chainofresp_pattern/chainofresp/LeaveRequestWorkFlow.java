package demo.chainofresp_pattern.chainofresp;

import demo.chainofresp_pattern.impls.Approver;
import demo.chainofresp_pattern.impls.DeliveryManager;
import demo.chainofresp_pattern.impls.Director;
import demo.chainofresp_pattern.impls.Supervisor;

public class LeaveRequestWorkFlow {
  public static Approver getApprover() {
    Approver supervisor = new Supervisor();   // 1st
    Approver manager = new DeliveryManager(); // 2nd
    Approver director = new Director();       // 3rd

    supervisor.setNext(manager);
    manager.setNext(director);

    return supervisor;
  }
}
