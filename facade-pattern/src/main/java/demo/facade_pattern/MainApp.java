package demo.facade_pattern;

import demo.facade_pattern.facade.ShopFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {

	private static Logger log = LoggerFactory.getLogger(MainApp.class.getName());

	public static void main(String[] args) {

		log.info(" >> Start Apps for Facade Pattern ... ");
		log.info(" ------------------------------------------------------------------------------");
		ShopFacade.getInstance().buyProductByCashWithFreeShipping("contact@gpcoder.com");

		log.info(" ------------------------------------------------------------------------------");
		ShopFacade.getInstance().buyProductByPaypalWithStandardShipping(
			"gpcodervn@gmail.com", "0988.999.999");

		log.info(" ------------ FINISH -------------");
	}

}
