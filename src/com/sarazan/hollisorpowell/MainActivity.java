package com.sarazan.hollisorpowell;

import com.sarazan.hollisorpowell.route.BusLine;
import com.sarazan.hollisorpowell.route.BusRoute;
import com.sarazan.hollisorpowell.route.BusStop;
import com.sarazan.hollisorpowell.route.RouteManager;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public static RouteManager routeManager;
	
	private TextView tv; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        routeManager = new RouteManager();
        
        BusLine line = routeManager.lineAtIndex(0);
        BusStop stop = line.stopAtIndex(0);
        BusRoute route = new BusRoute(stop);
        
        new ScrapeTask().execute(route);
        
        line = routeManager.lineAtIndex(1);
        stop = line.stopAtIndex(0);
        route = new BusRoute(stop);
        
        new ScrapeTask().execute(route);

        line = routeManager.lineAtIndex(1);
        stop = line.stopAtIndex(1);
        route = new BusRoute(stop);
        
        new ScrapeTask().execute(route);
        
        tv = new TextView(this);
        setContentView(tv);
    }
    
    private class ScrapeTask extends AsyncTask<BusRoute, Integer, NextBusScraper> {

		@Override
		protected NextBusScraper doInBackground(BusRoute... params) {
			BusRoute route = params[0];
			NextBusScraper scraper = new NextBusScraper(route);
			scraper.execute();
			
			return scraper;
		}
		
		@Override
		protected void onPostExecute(NextBusScraper result) {
			CharSequence text = tv.getText() + "\n" + result.toString();
			tv.setText(text);
		}    	
    }
}