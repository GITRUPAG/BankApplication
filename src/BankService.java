
// File: BankService.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankService {
    public void createAccount(String name, double initialBalance,String id) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO customer (UserId,Name, Balance) VALUES (?,?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, initialBalance);
            pstmt.executeUpdate();
            System.out.println("Account created successfully for " + name);
        }
    }

    public void deposit(String userId, double amount) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "UPDATE customer SET balance = balance + ? WHERE UserId = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
            System.out.println("Deposited ₹ " + amount + " to user ID " + userId);
        }
    }

    public void withdraw(String userId, double amount) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            // Check balance first
            String checkSql = "SELECT balance FROM customer WHERE UserId = ?";
            PreparedStatement checkPstmt = con.prepareStatement(checkSql);
            checkPstmt.setString(1, userId);
            ResultSet rs = checkPstmt.executeQuery();
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                if (balance >= amount) {
                    String sql = "UPDATE customer SET balance = balance - ? WHERE UserId = ?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setDouble(1, amount);
                    pstmt.setString(2, userId);
                    pstmt.executeUpdate();
                    System.out.println("Withdrew ₹ " + amount + " from user ID " + userId);
                } else {
                    System.out.println("Insufficient balance for user ID " + userId);
                }
            }
        }
    }

    public void checkBalance(String userId) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT balance FROM customer WHERE UserId = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                System.out.println("The balance for user ID " + userId + " is ₹" + balance);
            } else {
                System.out.println("User ID " + userId + " not found.");
            }
        }
    }
}
