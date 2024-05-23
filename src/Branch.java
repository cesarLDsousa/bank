import java.util.ArrayList;
import java.util.List;

public final class Branch {
    private int code;
    private String city;
    private final ArrayList<Account> accounts;

    public Branch(int branchCode, String city) {
        this.code = branchCode;
        this.city = city;
        this.accounts = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(int number) {
        accounts.removeIf(account -> account.getNumber() == number);
    }

    public Account getAccount(int number) {
        return accounts.stream()
                .filter(account -> account.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

    public List<Account> getAccountsSortedByNumber() {
        return accounts.stream()
                .sorted((acc1, acc2) -> Integer.compare(acc1.getNumber(), acc2.getNumber()))
                .toList();
    }
}
