
public class Authenticator {
	private String username;
    private String password;
    
    public Authenticator() {
        // Initialize with empty credentials
        this.username = "";
        this.password = "";
    }
    
    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean authenticate() {
        // Your authentication logic here
        // For demonstration, we're just checking if both username and password are non-empty
        return !username.isEmpty() && !password.isEmpty();
    }
}
