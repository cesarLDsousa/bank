import java.util.*;

public class BankSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Branch branch = new Branch(1, "New York");
    private static final List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = Integer.parseInt(scanner.nextLine());
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
        System.out.print("Escolha uma opção: ");
    }

    private static void addCustomer() {
        System.out.print("ID do Cliente: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Telefone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, phone);
        customers.add(customer);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void removeCustomer() {
        System.out.print("ID do Cliente: ");
        String id = scanner.nextLine();

        customers.removeIf(customer -> customer.getId().equals(id));
        System.out.println("Cliente removido com sucesso!");
    }

    private static void addAccount() {
        System.out.print("Número da Conta: ");
        int accNo = scanner.nextInt();

        System.out.print("Saldo Inicial: ");
        double balance = scanner.nextDouble();

        System.out.print("Tipo de Conta (1 - Poupança, 2 - Corrente): ");
        int accountType = scanner.nextInt();

        scanner.nextLine();

        System.out.print("ID do Cliente: ");
        String customerId = scanner.nextLine();

        Customer customer = customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst()
                .orElse(null);

        if (customer == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        Account account;

        if (accountType == 1) {
            System.out.print("Saldo Mínimo: ");
            double minBalance = scanner.nextDouble();

            scanner.nextLine();

            System.out.print("Data de Abertura: ");
            String dateOfOpening = scanner.nextLine();

            account = new SavingsAccount(accNo, balance, minBalance, dateOfOpening);
        } else {
            System.out.print("Taxa de Juros: ");
            double interestRate = scanner.nextDouble();

            scanner.nextLine();

            System.out.print("Data de Abertura: ");
            String dateOfOpening = scanner.nextLine();

            account = new CurrentAccount(accNo, balance, interestRate, dateOfOpening);
        }

        account.addCustomer(customer);
        branch.addAccount(account);
        System.out.println("Conta adicionada com sucesso!");
    }

    private static void removeAccount() {
        System.out.print("Número da Conta: ");
        int accNo = scanner.nextInt();

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
