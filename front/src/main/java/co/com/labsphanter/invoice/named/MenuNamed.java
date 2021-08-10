package co.com.labsphanter.invoice.named;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.com.labsphanter.invoice.model.Person;
import co.com.labsphanter.invoice.utils.Constants;
import lombok.Data;

@Data
@Named
@ViewScoped
public class MenuNamed {
	
	private static ExternalContext externalContext;
	
	private Person person;
	
	private String name;
	
	public MenuNamed() {
		
		externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		person = (Person) externalContext.getSessionMap().get("person");
		
		if (person == null) {
			permits();
		} else {
			name = person.getName();
		}
	}
	
	public static void permits() {
		try {
			Boolean flag = FacesContext.getCurrentInstance().getExternalContext().isResponseCommitted();
			
			if (!flag) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(Constants.INDEX);
			}else {
				logout();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String createInvoice() {
		return "/invoice/invoice/create?faces-redirect=true";
	}
	
	private static String logout() {
		externalContext.invalidateSession();
		return "/index?faces-redirect=true";
	}
}
