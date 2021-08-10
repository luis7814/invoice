package co.com.labsphanter.invoice.consumer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.com.labsphanter.invoice.model.Table;

@Service
public class TableConsumer {
	
	private HttpClient httpClient;
	private HttpResponse<String> httpResponse = null;
	
	
	public TableConsumer() {
		httpClient = HttpClient.newHttpClient();
	}
	
	
	public List<Table> findAll() {
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8083/table"))
				.build();
		
		try {
			httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
		
		Type type = new TypeToken<ArrayList<Table>>(){}.getType();
		
		return new Gson()
				.fromJson(httpResponse.body(), type);
		
	}

}
