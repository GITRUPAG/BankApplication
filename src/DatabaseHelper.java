import java.sql.*;

public class DatabaseHelper {
    // Method to check if a user ID is unique in the database
    public static boolean isUserIdUnique(String userId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection (replace connection details accordingly)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication");

            // Prepare the SQL query to count occurrences of the user ID
            String query = "SELECT COUNT(*) AS count FROM customer WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check the result
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count == 0; // If count is 0, user ID is unique; otherwise, it's not
            }
        } finally {
            // Close resources
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return false; // Default return value (failed to check uniqueness)
    }
}

