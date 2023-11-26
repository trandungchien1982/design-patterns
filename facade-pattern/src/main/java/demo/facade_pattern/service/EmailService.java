package demo.facade_pattern.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailService {

  Logger log = LoggerFactory.getLogger(getClass());

  public void sendMail(String mailTo) {
    log.info("[EmailService] :: Sending an email to " + mailTo);
  }

}