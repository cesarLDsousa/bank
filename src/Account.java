public abstract class Account {
    private int number;
    private double balance;

    public Account(int number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void debitAmount(double value) {
        this.balance -= value;
    }

    public void creditAmount(double value) {
        this.balance += value;
    }

    public abstract void addCustomer(Customer customer);

    public abstract void removeCustomer(Customer customer);
}
