public class Account {
    private String name;
    private String address;
    private int balance;
    private long accountNumber;

    public Account(String name, int balance) {
        this.name = name;
        this.address = null;
        this.balance = balance;
        this.accountNumber = 0;
    }

    public Account(String name, String address, int balance, long accountNumber) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

}
