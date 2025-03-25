import java.util.ArrayList;

public class BankCustomers {
    private ArrayList<BankAccount> accountsList = new ArrayList<>();

    public void addAccount(BankAccount account) {
        if (account == null) {
            System.out.println("Cannot add null account");
            return;
        }
        accountsList.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added successfully");
    }

    public void showAllBalances() {
        if (accountsList.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        System.out.println("All account balances:");
        for (BankAccount account : accountsList) {
            System.out.printf("Account: %s | Holder: %s | Balance: %.2f%n",
                    account.getAccountNumber(),
                    account.getAccountHolderName(),
                    account.getBalance());
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accountsList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.printf("Account found: %s | Holder: %s | Balance: %.2f%n",
                        account.getAccountNumber(),
                        account.getAccountHolderName(),
                        account.getBalance());
                return account;
            }
        }
        System.out.println("Account not found: " + accountNumber);
        return null;
    }
}