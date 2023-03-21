
public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private double totalBalance;
    private static int accountCreated = 0;
    private static double totalAmount = 0;

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.totalBalance = 0;
        accountCreated++;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public static void getAccountsCreated() {
        System.out.println("Number of accounts created: " + accountCreated);
    }

    public static void printTotalAmount() {
        System.out.println("Total amount in account $" + totalAmount);
    }

    public double deposit(double amount, String account) {
        // if (!account.equals("checking") || !account.equals("savings")) {
        //     System.out.println("Please enter a proper account type: checking or savings");
        // }
        if (account.equals("checking")) {
            this.checkingBalance += amount;
            BankAccount.totalAmount += amount;
            return this.checkingBalance;
        } else if (account.equals("savings")) {
            this.savingsBalance += amount;
            BankAccount.totalAmount += amount;
            return this.savingsBalance;
        } else {
            return 404;
        }
    }

    public double withdraw(double amount, String account) {
        // if (!account.equals("checking") || !account.equals("savings")) {
        //     System.out.println("Please enter a proper account type: checking or savings");
        // }
        if (account.equals("checking")) {
            if (amount > this.checkingBalance) {
                System.out.println("Insufficient funds.");
                return this.checkingBalance;
            } else {
                this.checkingBalance -= amount;
                BankAccount.totalAmount -= amount;
                return this.checkingBalance;
            }
        } else if (account.equals("savings")) {
            if (amount > this.savingsBalance) {
                System.out.println("Insufficient funds.");
                return this.savingsBalance;
            } else {
                this.savingsBalance -= amount;
                BankAccount.totalAmount -= amount;
                return this.savingsBalance;
            }
        } else {
            return 404;
        }
    }

    public void printTotalBalance() {
        this.totalBalance = this.checkingBalance + this.savingsBalance;
        System.out.println(totalBalance);
    }

}
