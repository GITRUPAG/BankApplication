// File: User.java
public class User {
    private String id;
    private String password;
    private String name;
    private double balance;

    public User(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public double getBalance() { return balance; }





    public void setId(String id) { this.id = id; }
    public void setPassword(String password) { this.password = password; }
    public void setName(String name) { this.name = name; }
    public void setBalance(double balance) { this.balance = balance; }
}
