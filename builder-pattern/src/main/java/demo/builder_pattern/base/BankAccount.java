package demo.builder_pattern.base;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class BankAccount {
  private String name; // required
  private String accountNumber; // required
  private String address;
  private String email;
  private boolean newsletter;
  private boolean mobileBanking;

  private BankAccount() {}
  public BankAccount(String name, String accountNumber) {
    this.name = name;
    this.accountNumber = accountNumber;
  }

  // Builder class
  public static class BankAccountBuilder {

    Logger log = LoggerFactory.getLogger(getClass());

    private String name; // required
    private String accountNumber; // required
    private String address;
    private String email;
    private boolean newsletter;
    private boolean mobileBanking;

    public BankAccountBuilder(String name, String accountNumber) {
      log.info("-------------------------------------------------------------");
      log.info("[BankAccountBuilder] :: Setting name/accountNumber");
      this.name = name;
      this.accountNumber = accountNumber;
    }

    public BankAccountBuilder withAddress(String address) {
      log.info("[BankAccountBuilder] :: Setting address");
      this.address = address;
      return this;
    }

    public BankAccountBuilder withEmail(String email) {
      log.info("[BankAccountBuilder] :: Setting email");
      this.email = email;
      return this;
    }

    public BankAccountBuilder wantNewsletter(boolean newsletter) {
      log.info("[BankAccountBuilder] :: Setting newsletter");
      this.newsletter = newsletter;
      return this;
    }

    public BankAccountBuilder wantMobileBanking(boolean mobileBanking) {
      log.info("[BankAccountBuilder] :: Setting mobileBanking");
      this.mobileBanking = mobileBanking;
      return this;
    }

    public BankAccount build() {
      log.info("[BankAccountBuilder] :: Try to build concrete Bank Account object: ... ");
      BankAccount bankAccount = new BankAccount(this.name, this.accountNumber);
      bankAccount.setAddress(address);
      bankAccount.setEmail(email);
      bankAccount.setNewsletter(newsletter);
      bankAccount.setMobileBanking(mobileBanking);

      return bankAccount;
    }
  }

  @Override
  public String toString() {
    return "BankAccount [name=" + name + ", accountNumber=" + accountNumber + ", address=" + address + ", email="
      + email + ", newsletter=" + newsletter + ", mobileBanking=" + mobileBanking + "]";
  }
}