package co.com.labsphanter.invoice.named;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.labsphanter.invoice.consumer.InvoiceConsumer;
import co.com.labsphanter.invoice.consumer.ProductConsumer;
import co.com.labsphanter.invoice.consumer.ProductTypeConsumer;
import co.com.labsphanter.invoice.consumer.TableConsumer;
import co.com.labsphanter.invoice.model.Product;
import co.com.labsphanter.invoice.model.ProductType;
import co.com.labsphanter.invoice.model.Table;
import co.com.labsphanter.invoice.model.Invoice;
import co.com.labsphanter.invoice.model.Person;
import co.com.labsphanter.invoice.model.Invoice.InvoiceDetail;
import co.com.labsphanter.invoice.utils.Constants;
import lombok.Data;

@Data
@Named
@ViewScoped
public class InvoiceNamed {
	
	
	@Autowired
	private TableConsumer tableConsumer;
	
	@Autowired
	private ProductTypeConsumer productTypeConsumer;
	
	@Autowired
	private ProductConsumer productConsumer;
	
	@Autowired
	private InvoiceConsumer invoiceConsumer;
	
	
	private String tableNumber;
	private String productType;
	private String product;
	private Integer amount;
	private String description;
	private Integer priceProduct;
	private Integer total;
	
	private String name;
	
	private List<InvoiceDetail> invoiceDetails;
	private List<Invoice> invoices;
	
	private Person person;
	
	private HashMap<String, String> tables;
	private HashMap<String, String> productsType;
	private HashMap<String, String> products;
	
	private ExternalContext externalContext; 
	
	@PostConstruct
	public String init() {
		
		validateSession();
		
		invoiceDetails = new ArrayList<InvoiceDetail>();
		invoices = new ArrayList<Invoice>();
		
		listTablesEnabled();
		listProductsType();
		
		return null;
		
	}
	
	private void validateSession() {
		
		externalContext = FacesContext.getCurrentInstance().getExternalContext();
		person = (Person) externalContext.getSessionMap().get("person");
		
		if (person == null) 
			MenuNamed.permits();
		
		name = person.getName();
	}
	
	public void listTablesEnabled() {
		
		List<Table> listTables = tableConsumer.findAll().stream()
				.filter(value -> value.getStatus().equals(Constants.AVAILABLE_TABLE))
				.collect(Collectors.toList());
		
		tables = new HashMap<String, String>();
		
		listTables.forEach((value) -> {
			tables.put(value.getNumber(), value.getNumber());
		});
	}
	
	public void listProductsType() {
		
		List<ProductType> productTypes = productTypeConsumer.findAll();
		
		productsType = new HashMap<String, String>();
		
		productTypes.forEach((value) -> {
			productsType.put(value.getName(), value.getName());
		});
	}
	
	public void listProductForType() {
		
		List<Product> listProducts = productConsumer.findAll().stream()
				.filter(value -> value.getType().equals(productType))
				.collect(Collectors.toList());
		
		products = new HashMap<String, String>();
		
		listProducts.forEach((value) -> {
			products.put(value.getName(), value.getName());
			priceProduct = value.getPrice();
		});
	}
	
	public void subTotal() {
		
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		invoiceDetail.setAmount(amount);
		invoiceDetail.setDescription(description);
		invoiceDetail.setPrice(priceProduct);
		invoiceDetail.setProduct(product);
		invoiceDetail.setTotal(priceProduct * amount);
		
		invoiceDetails.add(invoiceDetail);
		
	}
	
	public void deleteList(String product) {
		invoiceDetails.removeIf(value -> value.getProduct().equals(product));
	}
	
	public void registerInvoice() {
		
		total = 0;
		invoiceDetails.forEach((value) -> {
			total = total + value.getTotal();
		});
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		
		Invoice invoice = new Invoice();
		invoice.setDate(simpleDateFormat.format(new Date()));
		invoice.setId("");
		invoice.setMessage("");
		invoice.setPerson(name);
		invoice.setState(Constants.INVOICE_RECEIVED);
		invoice.setTable(tableNumber);
		invoice.setTotal(total + "");
		invoice.setInvoiceDetails(invoiceDetails);
		
		invoiceConsumer.create(invoice);
		
		
	}
	
	public void listAll() {
		invoices = invoiceConsumer.listAll().stream()
				.filter(value -> Constants.INVOICE_RECEIVED.equals(value.getState())
						|| Constants.INVOICE_IN_PREPARATION.equals(value.getState()))
				.collect(Collectors.toList());
		
	}
	
	public List<InvoiceDetail> invoiceId(String id) {
		
		List<Invoice> invoiceList = invoices.stream()
				.filter(value -> value.getId().equals(id))
				.collect(Collectors.toList());
		
		return invoiceList.get(0).getInvoiceDetails();
	}
	
	public void updateState(String id, String state) {
		
		Optional<Invoice> invoice = invoices.stream()
				.filter(value -> value.getId().equals(id))
				.findFirst();
		
		if(invoice.isPresent()) {
			Invoice request = invoice.get();
			request.setState(state);
			invoiceConsumer.update(request);
			
			listAll();
		}
		
		
	}
	
}
