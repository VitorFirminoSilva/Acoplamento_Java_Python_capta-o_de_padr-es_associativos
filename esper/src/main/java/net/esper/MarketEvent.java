package net.esper;

public class MarketEvent {
	private String clientName;
	private String transLine;

    public MarketEvent(String clientName, String transLine) {
        this.clientName = clientName;
        this.transLine = transLine;
    }

    public String getClientName() {
        return clientName;
    }

    public String getTransLine() {
        return transLine;
    }	
}