
public class Registration {
	private String username;
    private String password;
    
    public Registration() {
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

    private boolean validCredentialsChecker() {
		//check if username already in use
    	
    	return true;	// if username is free, else return false
    	
	}
    
    public void register(boolean valid, String username, String password) {
        if(valid) {
        	//add username and password to db
        }
    }
}
