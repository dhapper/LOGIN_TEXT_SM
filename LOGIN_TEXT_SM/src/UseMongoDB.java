import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class UseMongoDB {
	
	public boolean register(String username, String password) {
		if(inDB(username, password) == "FREE") {
			addToDB(username, password);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean login(String username, String password) {
		if(inDB(username, password) == "VALID") {
			return true;
		} else if(inDB(username, password) == "USERNAME") {
			return false;
		} else {
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
		return null;
	}
	
	public String addToDB(String username, String password) {
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
			MongoDatabase database = mongoClient.getDatabase("LOGIN_TEXT_SM_DB");
            MongoCollection<Document> collection = database.getCollection("credentials");
            
            Document newUser = new Document("username", username).append("password", password);
            collection.insertOne(newUser);
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

}
