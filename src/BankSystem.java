import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankSystem {
    private static final Branch branch = new Branch(1, "New York");
    private static final List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        int option;

        do {
            showMenu();
            option = InputReader.readInt("Escolha uma opção:");

            switch (option) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    addAccount();
                    break;
                case 4:
                    removeAccount();
                    break;
                case 5:
                    generateAccountsReport();
                    break;
                case 6:
                    generateCustomersReport();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 0);
    }

    private static void showMenu() {
        System.out.println("CESAR & VITOR BANK - Menu Principal");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Adicionar Conta");
        System.out.println("4. Remover Conta");
        System.out.println("5. Gerar Relatório de Contas");
        System.out.println("6. Gerar Relatório de Clientes");
        System.out.println("0. Sair");
    }

    private static void addCustomer() {
        String name = InputReader.readString("Nome: ");
        String phone = InputReader.readString("Telefone: ");

        Customer customer = new Customer(name, phone);
        customers.add(customer);

        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void removeCustomer() {
        int id = InputReader.readInt("ID do Cliente: ");
        customers.removeIf(customer -> customer.getId() == id);

        System.out.println("Cliente removido com sucesso!");
    }

    private static void addAccount() {
        int accNo = InputReader.readInt("Número da Conta: ");
        double balance = InputReader.readDouble("Saldo Inicial: ");
        int accountType = InputReader.readInt("Tipo de Conta (1 - Poupança, 2 - Corrente): ");

        int customerId = InputReader.readInt("ID do Cliente: ");

        Customer customer = customers.stream()
                .filter(c -> c.getId() == customerId)
                .findFirst()
                .orElse(null);

        if (customer == null) {
            System.out.println("Cliente não encontrado!");

            return;
        }

        Account account;

        String dateOfOpening = InputReader.readString("Data de Abertura: ");

        if (accountType == 1) {
            double minBalance = InputReader.readDouble("Saldo Mínimo: ");
            account = new SavingsAccount(accNo, balance, minBalance, dateOfOpening);
        } else {
            double interestRate = InputReader.readDouble("Taxa de Juros: ");
            account = new CurrentAccount(accNo, balance, interestRate, dateOfOpening);
        }

        account.addCustomer(customer);
        branch.addAccount(account);

        System.out.println("Conta adicionada com sucesso!");
    }

    private static void removeAccount() {
        int accNo = InputReader.readInt("Número da Conta: ");
        branch.removeAccount(accNo);

        System.out.println("Conta removida com sucesso!");
    }

    private static void generateAccountsReport() {
        List<Account> accounts = branch.getAccountsSortedByNumber();
        System.out.println("Relatório de Contas:");

        for (Account account : accounts) {
            System.out.println("Número da Conta: " + account.getNumber() + ", Saldo: " + account.getBalance());
        }
    }

    private static void generateCustomersReport() {
        customers.sort(Comparator.naturalOrder());
        System.out.println("Relatório de Clientes:");

        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId() + ", Nome: " + customer.getName() + ", Telefone: " + customer.getPhone());
        }
    }
}
