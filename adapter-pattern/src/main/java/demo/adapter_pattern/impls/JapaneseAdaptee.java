package demo.adapter_pattern.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JapaneseAdaptee {

  Logger log = LoggerFactory.getLogger(getClass());

  public void receive(String words) {
    log.info("[JapaneseAdaptee] :: Retrieving words from Adapter ... " + words);
    log.info("[JapaneseAdaptee] :: Try to process next step with words: " + words);
  }

}