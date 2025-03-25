public class Main {
    public static void main(String[] args) {
        BankCustomers bank = new BankCustomers();

        SavingsAccount savings1 = new SavingsAccount("SAV001", "Arad Shafiee", 1000);
        SavingsAccount savings2 = new SavingsAccount("SAV002", "Sepehr Alizade", 2000);
        SavingsAccount savings3 = new SavingsAccount("SAV003", "Parsa Mahdavi", 3000);

        TransactionAccount transaction1 = new TransactionAccount("TRA001", "Kaveh Saedi", 1500);
        TransactionAccount transaction2 = new TransactionAccount("TRA002", "Artin Zarif", 2500);
        TransactionAccount transaction3 = new TransactionAccount("TRA003", "Kian Zamani", 3500);

        bank.addAccount(savings1);
        bank.addAccount(savings2);
        bank.addAccount(savings3);
        bank.addAccount(transaction1);
        bank.addAccount(transaction2);
        bank.addAccount(transaction3);

        System.out.println("\n--- Searching accounts ---");
        bank.findAccount("SAV002");
        bank.findAccount("TRA999");

        System.out.println("\n--- Account operations ---");
        BankAccount account = bank.findAccount("SAV001");
        if (account != null) {
            System.out.println("Initial balance: " + account.getBalance());
            account.deposit(500);
            System.out.println("Balance after deposit: " + account.getBalance());
        }

        bank.findAccount("TRA002").deposit(-100);

        System.out.println("\n--- Interest calculation ---");
        savings1.calculateInterest();
        transaction1.calculateInterest();

        System.out.println("\n--- Withdrawals ---");

        savings2.withdraw(300);
        transaction2.withdraw(400);

        savings3.withdraw(-50);
        transaction3.withdraw(0);

        savings1.withdraw(5000);
        transaction1.withdraw(3000);

        System.out.println("\n--- Final account status ---");
        bank.showAllBalances();
    }
}