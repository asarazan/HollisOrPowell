package com.sarazan.hollisorpowell.utils;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.sax.Element;

import com.sarazan.hollisorpowell.R;
import com.sarazan.hollisorpowell.parsing.RouteXmlHandler;
import com.sarazan.hollisorpowell.route.RouteManager;

public class XmlRouteParser {
	private RouteManager routeManager;

	public XmlRouteParser(RouteManager routeManager) {
		this.routeManager = routeManager;
	}

	public void execute() {
		XmlParseTask task = new XmlParseTask();
		task.execute(routeManager);
	}

	private class XmlParseTask extends AsyncTask<RouteManager, Void, Void> {

		@Override
		protected Void doInBackground(RouteManager... params) {
			android.os.Debug.waitForDebugger();
			//I really hate working with this system. I'm just going to can the data for now because what a miserable process...
			return null;
		}
		
		protected void onPostExecute(Void arg) {
			routeManager.parseComplete();
		}
	}
}