// package assignments.java.week1.BankAccount;

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        // BankAccount account2 = new BankAccount();
        // BankAccount account3 = new BankAccount();
        // BankAccount account4 = new BankAccount();
        // BankAccount.getAccountsCreated();

        System.out.println(account1.deposit(200, "checking"));
        System.out.println(account1.deposit(200, "savings"));
        System.out.println(account1.withdraw(150, "checking"));
        System.out.println(account1.withdraw(150, "savings"));
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        account1.printTotalBalance();

    }
}
