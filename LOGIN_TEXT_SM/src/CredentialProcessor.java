
public class CredentialProcessor {
	private String username;
    private String password;
    
    public CredentialProcessor() {
        this.username = "";
        this.password = "";
    }
    
    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() {
    	UseMongoDB useMongo = new UseMongoDB();
        return useMongo.login(username, password);
    }
    
    public boolean register() {
    	UseMongoDB useMongo = new UseMongoDB();
        return useMongo.register(username, password);
    }
    
    public String getUsername() {
        return username;
    }
}
