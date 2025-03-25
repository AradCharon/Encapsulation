public class SavingsAccount extends BankAccount {
    private final double interestRate = 0.03; // 3%

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        deposit(interest);
        System.out.printf("Interest of %.2f added to savings account %s%n", interest, getAccountNumber());
    }
}