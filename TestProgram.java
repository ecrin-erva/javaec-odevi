package odev;

import java.util.Date;
class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this(0, 0, 0);
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account"
                + "\nHesap numarasi: " + id
                + "\nBakiye: " + balance
                + "\nYillik faiz orani: " + annualInterestRate
                + "\nOlusturulma tarihi: " + dateCreated;
    }
}

class SavingsAccount extends Account {

    public SavingsAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount\n"
                + "Hesap numarasi: " + getId()
                + "\nBakiye: " + getBalance()
                + "\nYillik faiz orani: " + getAnnualInterestRate()
                + "\nOlusturulma tarihi: " + getDateCreated();
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int id, double balance,
                           double annualInterestRate, double overdraftLimit) {
        super(id, balance, annualInterestRate);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() - amount >= -overdraftLimit) {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount\n"
                + "Hesap numarasi: " + getId()
                + "\nBakiye: " + getBalance()
                + "\nYillik faiz orani: " + getAnnualInterestRate()
                + "\nEksi bakiye limiti: " + overdraftLimit
                + "\nOlusturulma tarihi: " + getDateCreated();
    }
}
 
public class TestProgram {
    public static void main(String[] args) {

        Account account = new Account(1001, 5000, 0.05);

        SavingsAccount savings = new SavingsAccount(1002, 3000, 0.04);

        CheckingAccount checking =
                new CheckingAccount(1003, 1000, 0.03, 500);

        System.out.println("===== ACCOUNT =====");
        System.out.println(account);

        System.out.println("\n===== SAVINGS ACCOUNT =====");
        System.out.println(savings);

        System.out.println("\n===== CHECKING ACCOUNT =====");
        System.out.println(checking);

        System.out.println("\n===== PARA CEKME TESTLERI =====");

        savings.withdraw(3500);
        System.out.println("Tasarruf hesabi bakiyesi: "
                + savings.getBalance());

        checking.withdraw(1200);
        System.out.println("Vadesiz hesap bakiyesi: "
                + checking.getBalance());

        checking.withdraw(500);
        System.out.println("Vadesiz hesap bakiyesi: "
                + checking.getBalance());
    }
}