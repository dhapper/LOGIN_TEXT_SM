import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.types.ObjectId;

public class UseMongoDB {
	
	public static void main(String[] args) {
		UseMongoDB a = new UseMongoDB();
	}
	
	public boolean register(String username, String password) {
		if(inDB(username, password) == "FREE") {
			addToDB(username, password);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean login(String username, String password) {
		if(inDB(username, password) == "VALID")
			return true;
		else
			return false;
	}
	
	public String addPost(String username, String postString) {
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
			MongoDatabase database = mongoClient.getDatabase("LOGIN_TEXT_SM_DB");
            MongoCollection<Document> collection = database.getCollection("posts");
            
            Document post = new Document();
            post.append("username", username).append("post", postString).append("globalPostCount", incrementCount());
            collection.insertOne(post);
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public int getCount() {
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
			MongoDatabase database = mongoClient.getDatabase("LOGIN_TEXT_SM_DB");
            MongoCollection<Document> collection = database.getCollection("general data");
            
            String id = "66411a0b77dbc6445bc03766";
            Document query = new Document("_id", new ObjectId(id));
            MongoCursor<Document> cursor = collection.find(query).iterator();
            if (cursor.hasNext()) {
                Document countDoc = cursor.next();
                return countDoc.getInteger("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}
	
	public int incrementCount() {
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
			MongoDatabase database = mongoClient.getDatabase("LOGIN_TEXT_SM_DB");
            MongoCollection<Document> collection = database.getCollection("general data");
            
            String id = "66411a0b77dbc6445bc03766";
            Document query = new Document("_id", new ObjectId(id));
            Document update = new Document("$inc", new Document("count", 1));
            
            UpdateResult result = collection.updateOne(query, update);
            
            Document updatedDoc = collection.find(query).first();
            Integer count = updatedDoc.getInteger("count");
            return count;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
	
	public void addToDB(String username, String password) {
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
			MongoDatabase database = mongoClient.getDatabase("LOGIN_TEXT_SM_DB");
            MongoCollection<Document> collection = database.getCollection("credentials");
            
            Document newUser = new Document("username", username).append("password", password);
            collection.insertOne(newUser);
		} catch (Exception e) {
            e.printStackTrace();
        }
	}

}
