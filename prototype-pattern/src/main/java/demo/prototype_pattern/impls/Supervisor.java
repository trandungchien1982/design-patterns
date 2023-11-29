package demo.prototype_pattern.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Supervisor extends Approver {

  Logger log = LoggerFactory.getLogger(getClass());

  @Override
  protected boolean canApprove(int numberOfDays) {
    return numberOfDays <= 3;
  }

  @Override
  protected void doApproving(LeaveRequest request) {
    log.info("[Supervisor] :: Leave request approved for " + request.getDays() + " days by Supervisor");
  }
}