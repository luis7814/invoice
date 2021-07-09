package co.com.labsphanter.invoice.named;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.labsphanter.invoice.consumer.gateway.ConsumerGateway;
import co.com.labsphanter.invoice.dto.Invoice;
import co.com.labsphanter.invoice.dto.Product;
import lombok.Data;

@Data
@Named
@ViewScoped
public class MenuNamed implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ConsumerGateway<Invoice> invoiceConsumer;
	
	@Autowired
	private ConsumerGateway<Product> productConsumer;
	
	private String templateName;
	
	private MenuModel menuModel;
	private MenuModel menuBar;
	
	
	public MenuModel menuInformacion(String id) {
		
		try {
			
			menuModel = new DefaultMenuModel();
			
			DefaultSubMenu facturasSubMenu = DefaultSubMenu.builder().label("Facturas").build();
			menuFacturas(id, facturasSubMenu);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return menuModel;
		
	}
	
	
	private DefaultSubMenu menuFacturas(String id, DefaultSubMenu defaultSubMenu) {
		return null;
	}
	
	
	
	
	

}
