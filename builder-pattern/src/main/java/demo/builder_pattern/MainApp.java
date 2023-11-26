package demo.builder_pattern;

import demo.builder_pattern.base.BankAccount;
import demo.builder_pattern.base.Widget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class MainApp {

	private static Logger log = LoggerFactory.getLogger(MainApp.class.getName());

	public static void main(String[] args) {

		log.info(" >> Start Apps for Builder Pattern ... ");

		BankAccount account1 = new BankAccount.BankAccountBuilder("name1", "MobileNumber01")
			.withAddress("The Address 01")
			.withEmail("email01@test.com")
			.wantNewsletter(true)
			.build();

		BankAccount account2 = new BankAccount.BankAccountBuilder("name2", "MobileNumber02")
			.build();

		BankAccount account3 = new BankAccount.BankAccountBuilder("name3", "MobileNumber03")
			.withAddress("The Address 03")
			.wantMobileBanking(true)
			.build();

		Widget widget = Widget.builder()
			.name("Name 01")
			.age(24)
			.birthday(new Date())
			.build();


		log.info("[MainApp] :: The account1: " + account1);
		log.info("[MainApp] :: The account2: " + account2);
		log.info("[MainApp] :: The account3: " + account3);


		log.info(" -------------------------------------------------");
		log.info(" Using @FreePattern ..............................");
		log.info(" TODO: Waiting :) ................................");

		log.info(" Using @Builder of Lombok.........................");
		log.info("[MainApp] :: The widget: {}", widget);


		log.info(" ------------ FINISH -------------");
	}

}
