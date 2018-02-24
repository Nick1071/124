package com.mycompany.myapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity
{ 
	CustomView v;
	Handler h;
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		v =(CustomView)findViewById(R.id.mainCustomView1);
		Button left = (Button)findViewById(R.id.mainButtonLeft);
		left.setOnTouchListener(v);
		Button right = (Button)findViewById(R.id.mainButtonRight);
		right.setOnTouchListener(v);
		Button rotate = (Button)findViewById(R.id.mainButtonRotate);
		rotate.setOnTouchListener(v);
		Button down = (Button)findViewById(R.id.mainButtonDown);
		down.setOnTouchListener(v);
		h= new Handler();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(0,1,1,"New game");
		menu.add(0,2,2,"Exit");
		return super.onCreateOptionsMenu(menu);
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		switch(item.getItemId()){
			case 1: {
				//h= new Handler();
				//v.newGame();
				h.post(v);
				break;
				}
			case 2: finish();
		}
		return super.onOptionsItemSelected(item);
	} 
}
