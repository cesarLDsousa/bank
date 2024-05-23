public final class SavingsAccount extends Account {
    private double minBalance;
    private String dateOfOpening;
    private Customer customer;

    public SavingsAccount(int number, double balance, double minBalance, String dateOfOpening) {
        super(number, balance);
        this.minBalance = minBalance;
        this.dateOfOpening = dateOfOpening;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(String dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void addCustomer(Customer customer) {
        this.customer = customer;
    }

    public void removeCustomer() {
        this.customer = null;
    }
}