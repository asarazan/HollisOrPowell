package com.sarazan.hollisorpowell.parsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sarazan.hollisorpowell.route.RouteManager;

public class RouteXmlHandler extends DefaultHandler {
	
	private RouteManager routeManager;
	
	public RouteXmlHandler(RouteManager routeManager) {
		this.routeManager=routeManager;
	}

    @Override
    public void startDocument() throws SAXException {
    
    }
	
    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {
    	System.out.println("ohai");
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
    	
    }
}
