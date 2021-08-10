package co.com.labsphanter.invoice.consumer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.com.labsphanter.invoice.model.Invoice;

@Service
public class InvoiceConsumer {
	
	private HttpClient httpClient;
	
	public InvoiceConsumer() {
		httpClient = HttpClient.newHttpClient();
	}
	
	
	public Invoice create(Invoice invoice) {
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8083/invoice"))
				.POST(BodyPublishers.ofString(new Gson().toJson(invoice)))
				.setHeader("Content-Type", "application/json")
				.build();
		
		HttpResponse<String> httpResponse = null;
		
		try {
			httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new Gson().fromJson(httpResponse.body(), Invoice.class);
		
	}
	
	public Invoice update(Invoice invoice) {
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8083/invoice"))
				.PUT(BodyPublishers.ofString(new Gson().toJson(invoice)))
				.setHeader("Content-Type", "application/json")
				.build();
		
		HttpResponse<String> httpResponse = null;
		
		try {
			httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new Gson().fromJson(httpResponse.body(), Invoice.class);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Invoice> listAll() {
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8083/invoice"))
				.setHeader("Content-Type", "application/json")
				.build();
		
		HttpResponse<String> httpResponse = null;
		
		try {
			httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Type invoiceListType = new TypeToken<ArrayList<Invoice>>(){}.getType();

		return new Gson().fromJson(httpResponse.body(), invoiceListType);
		
	}


}
