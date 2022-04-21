package net.esper;

import com.espertech.esper.client.EventBean;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {
    
    public void writeAprori(EventBean[] newEvents, int number){
        try {
            System.out.println("Janela " + number + " Criada");
            FileWriter fw = new FileWriter("../Arquivos/Janelamento/janela"+number+ ".csv");
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (EventBean line : newEvents) {
                
                bw.write(line.get("transLine")+"\r"); 
            }
            
            bw.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
