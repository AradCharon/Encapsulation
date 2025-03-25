public abstract class BankAccount {
    private final String accountNumber;
    private String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public abstract void calculateInterest();

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount for deposit: " + amount);
            return;
        }
        balance += amount;
        System.out.printf("Amount %.2f deposited to account %s%n", amount, accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount for withdrawal: " + amount);
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal: " + amount);
            return;
        }
        balance -= amount;
        System.out.printf("Amount %.2f withdrawn from account %s%n", amount, accountNumber);
    }

    // Getters
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
}