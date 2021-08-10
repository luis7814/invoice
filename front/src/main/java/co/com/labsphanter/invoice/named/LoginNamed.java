package co.com.labsphanter.invoice.named;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.labsphanter.invoice.consumer.PersonConsumer;
import co.com.labsphanter.invoice.model.Person;
import co.com.labsphanter.invoice.utils.Routes;
import co.com.labsphanter.invoice.utils.Utilities;
import lombok.Data;

@Data
@Named
@ViewScoped
public class LoginNamed {
	
	
	private String login;
	private String password;
	
	private ExternalContext externalContext;
	
	@Autowired
	private PersonConsumer personConsumer;
	
	@PostConstruct
	public void init() {
		System.out.println("Ingresó a la clase -->");
	}
	
	public String register() {
		
		String authentication = Utilities.encodeBase64(login + ";" + password);
		
		Person person = Optional.ofNullable(
				personConsumer.findByAccount(authentication))
				.orElse(new Person());
		
		if (person.getLogin() != null && person.getLogin().equals(login)) {
			
			externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.getSessionMap().put("person", person);
			
			return Routes.MENU;
			
		} else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", "Información no encontrada"));
			
			return "";
			
		}
	}
	
}
