import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

        class BankAccount {
            private String accountNumber;
            private String accountHolderName;
            private double balance;

            public BankAccount(String accountNumber, String accountHolderName, double balance) {
                this.accountNumber = accountNumber;
                this.accountHolderName = accountHolderName;
                this.balance = balance;
            }

            public String getAccountNumber() {
                return accountNumber;
            }

            public String getAccountHolderName() {
                return accountHolderName;
            }

            public double getBalance() {
                return balance;
            }

            public void deposit(double amount) {
                balance += amount;
            }

            public void withdraw(double amount) {
                if (balance >= amount) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient balance!");
                }
            }
        }

        class Customer {
            private String customerId;
            private String name;
            private Map<String, BankAccount> accounts;

            public Customer(String customerId, String name) {
                this.customerId = customerId;
                this.name = name;
                this.accounts = new HashMap<>();
            }

            public String getCustomerId() {
                return customerId;
            }

            public String getName() {
                return name;
            }

            public void addAccount(BankAccount account) {
                accounts.put(account.getAccountNumber(), account);
            }

            public BankAccount getAccount(String accountNumber) {
                return accounts.get(accountNumber);
            }

            public Map<String, BankAccount> getAccounts() {
                return accounts;
            }
        }

        class BankingSystem {
            private Map<String, Customer> customers;

            public BankingSystem() {
                this.customers = new HashMap<>();
            }

            public void addCustomer(Customer customer) {
                customers.put(customer.getCustomerId(), customer);
            }

            public Customer getCustomer(String customerId) {
                return customers.get(customerId);
            }

            public void displayCustomerDetails(String customerId) {
                Customer customer = getCustomer(customerId);
                if (customer == null) {
                    System.out.println("Customer not found.");
                } else {
                    System.out.println("Customer ID: " + customer.getCustomerId());
                    System.out.println("Name: " + customer.getName());
                    System.out.println("Accounts:");
                    for (BankAccount account : customer.getAccounts().values()) {
                        System.out.println("  Account Number: " + account.getAccountNumber());
                        System.out.println("  Balance: " + account.getBalance());
                    }
                }
            }
        }

        public class Main {
            public static void main(String[] args) {
                BankingSystem bankingSystem = new BankingSystem();

                // Create customers and bank accounts
                Customer customer1 = new Customer("CUST001", "John Doe");
                Customer customer2 = new Customer("CUST002", "Jane Smith");

                BankAccount account1 = new BankAccount("ACC001", "Savings Account", 1000.0);
                BankAccount account2 = new BankAccount("ACC002", "Checking Account", 500.0);

                // Add accounts to customers
                customer1.addAccount(account1);
                customer2.addAccount(account2);

                // Add customers to the banking system
                bankingSystem.addCustomer(customer1);
                bankingSystem.addCustomer(customer2);

                Scanner scanner = new Scanner(System.in);

                // Prompt the user to enter a customer ID
                System.out.print("Enter customer ID: ");
                String customerId = scanner.nextLine();

                // Display customer details
                bankingSystem.displayCustomerDetails(customerId);

                // Perform a deposit and withdrawal operation on one of the accounts
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account1.deposit(depositAmount);

                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                account1.withdraw(withdrawAmount);

                // Display customer details after the operations
                bankingSystem.displayCustomerDetails(customerId);
            }
        }
    }
}
