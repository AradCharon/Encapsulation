public class TransactionAccount extends BankAccount {
    private final double overDraftLimit = 500;

    public TransactionAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("No interest for transaction account " + getAccountNumber());
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount for withdrawal: " + amount);
            return;
        }
        if (amount > (balance + overDraftLimit)) {
            System.out.println("Withdrawal amount exceeds overdraft limit: " + amount);
            return;
        }
        balance -= amount;
        System.out.printf("Amount %.2f withdrawn from transaction account %s%n", amount, getAccountNumber());
    }
}