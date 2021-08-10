package co.com.labsphanter.invoice.consumer;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import co.com.labsphanter.invoice.model.Person;

@Service
public class PersonConsumer {
	
	private HttpClient httpClient;
	private HttpResponse<String> httpResponse = null;
	
	
	public PersonConsumer() {
		httpClient = HttpClient.newHttpClient();
	}
	
	
	public Person findByAccount(String authentication) {
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8083/person/" + authentication + "/a"))
				.build();
		
		try {
			httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	
		return new Gson()
				.fromJson(httpResponse.body(), Person.class);
		
	}

}
