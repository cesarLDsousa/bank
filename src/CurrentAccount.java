public class CurrentAccount extends Account {
    private double interestRate;
    private String dateOfOpening;
    private Customer customer;

    public CurrentAccount(int number, double balance, double interestRate, String dateOfOpening) {
        super(number, balance);
        this.interestRate = interestRate;
        this.dateOfOpening = dateOfOpening;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
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

    @Override
    public void addCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void removeCustomer(Customer customer) {
        this.customer = null;
    }
}