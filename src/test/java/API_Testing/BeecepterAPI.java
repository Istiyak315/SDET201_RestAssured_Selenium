package API_Testing;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BeecepterAPI {
	
@Test

public void RegisterSuccefuly() {
	
	JSONObject json = new JSONObject();
	json.put("username","user123");
	json.put("password","securepassword");
	json.put("email","user@example.com");
	RestAssured.baseURI="https://crypto-wallet-server.mock.beeceptor.com";
	given()
	.header("Accept","application/json")
	.contentType(ContentType.JSON).body(json.toJSONString()).when().post("/api/v1/register").then().statusCode(200).log().all();
	
}

@Test
public void loginSuccessfully() {
	
	JSONObject json = new JSONObject();
	json.put("username","user123");
	json.put("password","securepassword");

	
	RestAssured.baseURI="https://crypto-wallet-server.mock.beeceptor.com";
	given()
	.header("Accept","application/json")
	.contentType(ContentType.JSON).body(json.toJSONString()).when().post("/api/v1/login").then().statusCode(200).log().all();
	//.when().get("/api/v1/register").then().statusCode(200).log().all();

}
@Test

public void RetrieveBalance() {
	RestAssured.baseURI="https://crypto-wallet-server.mock.beeceptor.com";
	given().get("/api/v1/balance").then().statusCode(200).log().all();

	
}

@Test
public void ListTransactions() {
	RestAssured.baseURI="https://crypto-wallet-server.mock.beeceptor.com";
	given().get("/api/v1/transactions").then().statusCode(200).log().all();

	
}


@Test
public void Transfer() {
	
	JSONObject json = new JSONObject();
	json.put("recipient_address","0x1234567890ABCDEF");
	json.put("amount",5.0);
	json.put("currency","ETH");
	RestAssured.baseURI="https://crypto-wallet-server.mock.beeceptor.com";
	given()
	.header("Accept","application/json")
	.contentType(ContentType.JSON).body(json.toJSONString()).when().post("/api/v1/transactions").then().statusCode(200).log().all();

	
}

@Test
public void Calculation() {
	
	JSONObject json = new JSONObject();
	json.put("amount",2.5);
	json.put("currency","BTC");
	json.put("recipient_address","0x1234567890ABCDEF");
	RestAssured.baseURI="https://crypto-wallet-server.mock.beeceptor.com";
	given()
	.header("Accept","application/json")
	.contentType(ContentType.JSON).body(json.toJSONString()).when().post("/api/v1/transaction_fee").then().statusCode(200).log().all();
	
}

@Test
public void CurrencyExchange() {
	
	RestAssured.baseURI="https://crypto-wallet-server.mock.beeceptor.com";
	given().get("/api/v1/exchange_rates").then().statusCode(200).log().all();

	
}


}