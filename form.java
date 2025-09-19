import java.util.regex.Pattern;

public class AuthValidation {

    // Validate username
    public static String validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            return "Username cannot be empty.";
        }
        if (username.length() < 3) {
            return "Username must be at least 3 characters.";
        }
        if (!Pattern.matches("^[a-zA-Z0-9_]+$", username)) {
            return "Username can only contain letters, numbers, and underscores.";
        }
        return null; // null means valid
    }

    // Validate email
    public static String validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return "Email cannot be empty.";
        }
        String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        if (!Pattern.matches(emailRegex, email)) {
            return "Invalid email format.";
        }
        return null;
    }

    // Validate password
    public static String validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return "Password must be at least 8 characters.";
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return "Password must contain at least one uppercase letter.";
        }
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return "Password must contain at least one lowercase letter.";
        }
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return "Password must contain at least one digit.";
        }
        if (!Pattern.compile("[\\W_]").matcher(password).find()) {
            return "Password must contain at least one special character.";
        }
        return null;
    }

    // Confirm password matches
    public static String confirmPassword(String password, String confirmPassword) {
        if (password == null || !password.equals(confirmPassword)) {
            return "Passwords do not match.";
        }
        return null;
    }

    // Signup validation pipeline
    public static String signupPipeline(String username, String email, String password, String confirmPassword) {
        String result;

        result = validateUsername(username);
        if (result != null) return result;

        result = validateEmail(email);
        if (result != null) return result;

        result = validatePassword(password);
        if (result != null) return result;

        result = confirmPassword(password, confirmPassword);
        if (result != null) return result;

        return "Signup successful!";
    }

    // Login validation pipeline (simple check)
    public static String loginPipeline(String username, String password) {
        if (username == null || username.isEmpty()) {
            return "Username is required.";
        }
        if (password == null || password.isEmpty()) {
            return "Password is required.";
        }
        // Here you would normally check username and password against a database
        return "Login successful!";
    }

    public static void main(String[] args) {
        // Test signup
        String signupMessage = signupPipeline(
                "user_123",
                "user@example.com",
                "StrongPass1!",
                "StrongPass1!"
        );
        System.out.println("Signup: " + signupMessage);

        // Test login
        String loginMessage = loginPipeline("user_123", "StrongPass1!");
        System.out.println("Login: " + loginMessage);
    }
}
