package demo.facade_pattern.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsService {

  Logger log = LoggerFactory.getLogger(getClass());

  public void sendSMS(String mobilePhone) {
    log.info("[SMSService] :: Sending an mesage to " + mobilePhone);
  }


}