package com.sarazan.hollisorpowell;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        BusStop start = new BusStop(BusStop.StopPixar, BusStop.DirInbound);
        BusStop end = new BusStop(BusStop.StopMacArthur, BusStop.DirInbound);
        
        NextBusScraper scraper = new NextBusScraper(NextBusScraper.RouteHollis, NextBusScraper.DirInbound, start, end);
        
        TextView tv = new TextView(this);
        tv.setText(scraper.execute());
        setContentView(tv);
    }
}