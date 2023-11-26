package demo.facade_pattern.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountService {

  Logger log = LoggerFactory.getLogger(getClass());

  public void getAccount(String email) {
    log.info("[AccountService] :: Getting the account of " + email);
  }

}