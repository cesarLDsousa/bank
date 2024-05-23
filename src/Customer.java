public final class Customer implements Comparable<Customer>, IdAutoIncrements {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.id = nextId;

        incrementNextId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void incrementNextId() {
        nextId++;
    }

    @Override
    public int compareTo(Customer otherCustomer) {
        return this.name.compareTo(otherCustomer.name);
    }
}
