package utilities;

public class Validator {

	 public static boolean isValidEmail(String email) {
	        return email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
	    }

	    public static boolean isValidPhone(String phone) {
	        return phone.matches("^\\d{10}$");
	    }

	    public static boolean isValidPassword(String password) {
	        // Example: Minimum 8 chars, at least one digit, one uppercase, one lowercase, one special char
	        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
	    }

	    public static boolean areFieldsFilled(String... fields) {
	        for (String field : fields) {
	            if (field == null || field.trim().isEmpty()) return false;
	        }
	        return true;
	    }


}
