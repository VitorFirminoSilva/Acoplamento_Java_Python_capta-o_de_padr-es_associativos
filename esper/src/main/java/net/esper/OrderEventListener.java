package net.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class OrderEventListener implements UpdateListener {
    
        private static Integer i = 0; 
	
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
                i+=1;
                System.out.println("\nJanela T" + i);
                
                WriteFile wf = new WriteFile();
                
                wf.writeAprori(newEvents, i);
                
                System.out.println(newEvents.length);
                /*for (EventBean event : newEvents) {
                    System.out.print("Transação= " + event.get("transLine"));
                    System.out.println(" ");
                }*/
	}
}
