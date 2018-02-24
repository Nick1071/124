package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.util.*;
import android.widget.*;
import java.util.concurrent.*;
import android.widget.SearchView.*;
import android.view.*;


public class MainActivity extends Activity implements OnClickListener
{
	TextView txt;
	int count = 0;
	Button btn;

	@Override
	public void onClick(View p1)
	{
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					count++;
					
					btn.post(new Runnable(){

							@Override
							public void run()
							{
								String s = String.valueOf(count);
								txt.setText(s);
								// TODO: Implement this method
							}
						});
				}
				}).start();
		 
		// TODO: Implement this method
	}
	

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		txt = (TextView)findViewById(R.id.mainTextView1);
		txt.setText("qwerty");
		btn = (Button) findViewById(R.id.mainButton1);
		btn.setOnClickListener(this);
		

    }
}
