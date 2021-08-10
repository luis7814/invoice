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

import co.com.labsphanter.invoice.model.ProductType;

@Service
public class ProductTypeConsumer {
	
	private HttpClient httpClient;
	private HttpResponse<String> httpResponse = null;
	
	
	public ProductTypeConsumer() {
		httpClient = HttpClient.newHttpClient();
	}
	
	
	public List<ProductType> findAll() {
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8083/productType"))
				.build();
		
		try {
			httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
		
		Type type = new TypeToken<ArrayList<ProductType>>(){}.getType();
		
		return new Gson()
				.fromJson(httpResponse.body(), type);
		
	}

}
