package demo.adapter_pattern;

import demo.adapter_pattern.adapter.TranslatorAdapter;
import demo.adapter_pattern.impls.JapaneseAdaptee;
import demo.adapter_pattern.impls.VietnameseTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {

	private static Logger log = LoggerFactory.getLogger(MainApp.class.getName());

	public static void main(String[] args) {

		log.info(" >> Start Apps for Adapter Pattern ... ");
		log.info(" ------------------------------------------------------------------------------");
		VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());

		String vnWords = "Xin chào!";
		log.info("[Client] :: Try to send words: " + vnWords);
		client.send(vnWords);

		log.info(" ------------ FINISH -------------");
	}

}
