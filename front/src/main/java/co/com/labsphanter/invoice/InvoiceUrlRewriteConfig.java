package co.com.labsphanter.invoice;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;



@RewriteConfiguration
public class InvoiceUrlRewriteConfig extends HttpConfigurationProvider {

	@Override
	public Configuration getConfiguration(final ServletContext context) {
		
		return ConfigurationBuilder.begin()
				.addRule(Join.path("/").to("/index.xhtml"))
				.addRule(Join.path("/menu").to("/xhtml/menu.xhtml"))
				.addRule(Join.path("/invoice/invoice/create").to("/xhtml/invoice/invoice_create.xhtml"))
				.addRule(Join.path("/invoice/invoice/active").to("/xhtml/invoice/invoice_list_active.xhtml"));
	}

	@Override
	public int priority() {
		return 10;
	}
	
	
	

}
