package co.com.labsphanter.invoice.consumer.gateway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Consumer<T> implements ConsumerGateway<T>{
	
	
	@Autowired
	private RestTemplate restTemplate; 
	
	private HttpHeaders httpHeaders;
	
	public Consumer() {
		
		httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T save(T object) {
		
		HttpEntity<T> entity = new HttpEntity<T>(object, httpHeaders);
		return (T) restTemplate.exchange("URL", HttpMethod.POST, entity, Object.class).getBody();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public T update(T object) {
	
		HttpEntity<T> entity = new HttpEntity<T>(object, httpHeaders);
		return (T) restTemplate.exchange("URL", HttpMethod.PUT, entity, Object.class).getBody();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(String id) {
	
		HttpEntity<T> entity = new HttpEntity<T>(httpHeaders);
		return (T) restTemplate.exchange("URL", HttpMethod.GET, entity, Object.class).getBody();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		
		HttpEntity<T> entity = new HttpEntity<T>(httpHeaders);
		return (List<T>) restTemplate.exchange("URL", HttpMethod.GET, entity, Object.class).getBody();
		
	}
	
	

}
