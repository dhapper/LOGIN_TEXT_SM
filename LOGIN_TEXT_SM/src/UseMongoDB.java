import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class UseMongoDB {
	
	public static void main(String[] args) {
		UseMongoDB useMongo = new UseMongoDB();
		boolean test = useMongo.login("hibi", "jibi");
		System.out.println(test);
	}
	
	public boolean register(String username, String password) {
		if(inDB(username, password) == "FREE") {
			System.out.println("Registed new account!");
			return true;
		} else {
			System.out.println("Username already in use");
			return false;
		}
	}
	
	public boolean login(String username, String password) {
		if(inDB(username, password) == "VALID") {
			System.out.println("valid login");
			return true;
		} else if(inDB(username, password) == "USERNAME") {
			System.out.println("incorrect password");
			return false;
		} else {
			System.out.println("incorrect credentials");
			return false;
		}
	}
	
	public String inDB(String username, String password) {
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
			MongoDatabase database = mongoClient.getDatabase("LOGIN_TEXT_SM_DB");
            MongoCollection<Document> collection = database.getCollection("credentials");
            
            Document query = new Document("username", username).append("password", password);
            MongoCursor<Document> cursor = collection.find(query).iterator();
            
            if(cursor.hasNext())
            	return "VALID";
            
            query = new Document("username", username);
            cursor = collection.find(query).iterator();
            
            if(cursor.hasNext())
            	return "USERNAME";
            else
            	return "FREE";
            
            
		} catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("Error: Can't access MongoDB");
		return null;
	}

}