package demo.chainofresp_pattern.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Approver {

  Logger log = LoggerFactory.getLogger(getClass());

  protected Approver nextApprover;

  public void approveLeave(LeaveRequest request) {
    log.info("[Approver] :: Checking permission for " + this.getClass().getSimpleName());
    if (this.canApprove(request.getDays())) {
      log.info("[Approver] :: GOOD, leave request can be approved by " + this.getClass().getSimpleName());
      this.doApproving(request);
    } else if (nextApprover != null) {
      nextApprover.approveLeave(request);
    }
  }

  public void setNext(Approver approver) {
    this.nextApprover = approver;
  }

  protected abstract boolean canApprove(int numberOfDays);

  protected abstract void doApproving(LeaveRequest request);

}