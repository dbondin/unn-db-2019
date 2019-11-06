package ru.unn.jmongo;

import org.bson.BsonDocument;
import org.bson.BsonObjectId;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.codecs.BsonValueCodec;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {
	public static void main(String[] args) throws Throwable {
		
		ServerAddress saddr = new ServerAddress("192.168.99.100", 27017);
		MongoCredential cred = MongoCredential.createScramSha1Credential("dbondin", "test", "password".toCharArray());
		MongoClientOptions opts = MongoClientOptions.builder().build();
		MongoClient mc = new MongoClient(saddr, cred, opts);
		//ClientSession sess = mc.startSession();
		MongoDatabase db = mc.getDatabase("test");
		MongoCollection<Document> human = db.getCollection("human");
		MongoCollection<Document> food = db.getCollection("food");
		FindIterable<Document> it = human.find();
		it.iterator().forEachRemaining(doc -> {
			//System.out.println(doc);
			String name = doc.getString("name");
			double age = doc.getDouble("age");
			ObjectId ffid = doc.getObjectId("favoriteFood");
			Document af = doc.get("anotherFood", Document.class);
			
			BsonDocument q = new BsonDocument();
			q.append("_id", new BsonObjectId(ffid));
			String foodName = food.find(q).limit(1).iterator().next().getString("name");
			
			System.out.println("name=" + name + " age=" + age + " ffid=" + ffid + " food.name=" + foodName + 
					" anotherFoodName=" + af.getString("name"));
		});
//		Document nd = new Document();
//		nd.append("name", "Sasha");
//		nd.append("age", 35);
//		human.insertOne(nd);
//		human.updateOne(BsonDocument.parse("{'name': 'Sasha'}"), BsonDocument.parse("{$set: {'age' : 35.0}}"));
	}
}
