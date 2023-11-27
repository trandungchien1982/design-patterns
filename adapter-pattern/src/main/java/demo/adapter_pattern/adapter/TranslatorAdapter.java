package demo.adapter_pattern.adapter;

import demo.adapter_pattern.impls.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranslatorAdapter implements VietnameseTarget {
  Logger log = LoggerFactory.getLogger(getClass());

  private JapaneseAdaptee jpAdaptee;

  public TranslatorAdapter(JapaneseAdaptee jpAdaptee) {
    this.jpAdaptee = jpAdaptee;
  }

  @Override
  public void send(String words) {
    log.info("[TranslatorAdapter] :: Reading Words: " + words);
    String jpWords = this.translate(words);

    log.info("[TranslatorAdapter] :: Sending JP Words: " + jpWords);
    jpAdaptee.receive(jpWords);
  }

  private String translate(String vnWords) {
    log.info("[TranslatorAdapter] :: Translated! the VN words: " + vnWords);
    return vnWords + "[こんにちは]";
  }

}
