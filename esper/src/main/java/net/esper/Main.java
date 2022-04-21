package net.esper;


import com.espertech.esper.client.EPServiceProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {
        EsperEngine engine = new EsperEngine();
        engine.start();
        sendEvents(engine.getEpService());
    }
     
    private static void sendEvents(EPServiceProvider epService) throws FileNotFoundException, IOException {
        
        try(BufferedReader br = new BufferedReader(new FileReader("../Arquivos/Fluxos de dados/BMS_WebView_1_59602.txt"))) {
            String line = br.readLine();

            while (line != null) {
                epService.getEPRuntime().sendEvent(new MarketEvent("ClientNAN", line.replace(" ", ",")));
                line = br.readLine();
            }
        }
    }
    
}
