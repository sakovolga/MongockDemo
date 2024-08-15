package com.example.demo;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableMongock
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MongockDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@AfterAll
	public void cleanUp() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("TestData");

		for (String collectionName : database.listCollectionNames()) {
			database.getCollection(collectionName).drop();
			System.out.println("Удалена коллекция: " + collectionName);
		}
		System.out.println("Все коллекции удалены.");

		mongoClient.close();
	}

}
