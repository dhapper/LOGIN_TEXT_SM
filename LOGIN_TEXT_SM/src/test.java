import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class test {
    public static void main(String[] args) {
        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            MongoDatabase database = mongoClient.getDatabase("LOGIN_TEXT_SM_DB"); // Update database name
            MongoCollection<Document> collection = database.getCollection("credentials"); // Update collection name

            // Create a new document with username and password
            Document newUser = new Document("username", "hibi").append("password", "jibi");

            // Insert the document into the collection
            collection.insertOne(newUser);
            System.out.println("Document inserted successfully.");

            // List all documents in the collection after insertion
            System.out.println("All documents in the collection:");
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    System.out.println(document.toJson());
                }
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
