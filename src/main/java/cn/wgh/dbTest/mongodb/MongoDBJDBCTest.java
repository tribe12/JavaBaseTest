package cn.wgh.dbTest.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * 可参考：
 * http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/ 
 * http://blog.csdn.net/ererfei/article/details/50857103
 */
public class MongoDBJDBCTest {

	/**
	 * 连接数据库
	 * 
	 * @param dbName
	 *            数据库名称
	 * @return
	 * @throws Exception
	 */
	public MongoDatabase getConnectDB(String dbName) throws Exception {
		MongoDatabase mongoDatabase = null;
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			// 连接到数据库
			mongoDatabase = mongoClient.getDatabase(dbName);

			System.out.println("Connect to database:");
			String getDbName = mongoDatabase.getName();
			if (dbName.equals(getDbName)) {
				System.out.println("Successfully！  -- db:" + getDbName);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return mongoDatabase;
	}

	@Test
	public void testName() throws Exception {
		String dbName = "wghjdbc";

		MongoDatabase mongoDatabase = getConnectDB(dbName);

		try {
			// 创建集合

			String collectionName = "mytest";
			mongoDatabase.createCollection(collectionName);
			System.out.println("集合创建成功");

			MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

			// 插入文档
			/**
			 * 1. 创建文档 org.bson.Document 参数为key-value的格式
			 * 2. 创建文档集合List<Document> 
			 * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 
			 *    插入单个文档可以用 mongoCollection.insertOne(Document)
			 */
			Document document = new Document("title", "MongoDB").append("description", "database").append("likes", 100)
					.append("by", "tribe");
			List<Document> documents = new ArrayList<Document>();
			documents.add(document);
			collection.insertMany(documents);
			System.out.println("文档插入成功");

			// 检索所有文档
			/**
			 * 1. 获取迭代器FindIterable<Document>; 
			 * 2. 获取游标MongoCursor<Document>; 
			 * 3. 通过游标遍历检索出的文档集合;
			 */
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> mongoCursor = findIterable.iterator();
			while (mongoCursor.hasNext()) {
				System.out.println(mongoCursor.next());
			}

			// 修改文档
			// 更新文档 将文档中likes=100的文档修改为likes=200
			collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
			// 检索查看结果
			FindIterable<Document> findIterable2 = collection.find();
			MongoCursor<Document> mongoCursor2 = findIterable2.iterator();
			while (mongoCursor2.hasNext()) {
				System.out.println(mongoCursor2.next());
			}

		} catch (Exception e) {
			System.err.println(" --- error --- :" + e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	
	
	
	
	@Test
	public void testNameDelete() throws Exception {
		try {
			// 连接到数据库
			MongoDatabase mongoDatabase = getConnectDB("wghjdbc");

			MongoCollection<Document> collection = mongoDatabase.getCollection("mytest");
			System.out.println("集合mytest 选择成功");

			// 删除符合条件的第一个文档
			collection.deleteOne(Filters.eq("likes", 200));
			// 删除所有符合条件的文档
			collection.deleteMany(Filters.eq("likes", 200));
			// 检索查看结果
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> mongoCursor = findIterable.iterator();
			while (mongoCursor.hasNext()) {
				System.out.println(mongoCursor.next());
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}