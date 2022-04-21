package net.esper;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class EsperEngine {

	private EPServiceProvider epService;
	
	public void start(){
		Configuration config = new Configuration();
		config.addEventTypeAutoName("net.esper");
		epService = EPServiceProviderManager.getDefaultProvider(config);
		registerListeners();
	}

	private void registerListeners() {
                String expression = "select transLine from MarketEvent#time_length_batch(1 sec, 5960)";
		EPStatement statement = epService.getEPAdministrator().createEPL(expression);
		statement.addListener(new OrderEventListener());           
	}
	
	public EPServiceProvider getEpService() {
		return epService;
	}
}

