package co.com.labsphanter.invoice.consumer.gateway;

import java.util.List;

public interface ConsumerGateway<T> {
	
	public T save(T object);
	public T update(T object);
	public T findById(String id);
	public List<T> findAll();

}
