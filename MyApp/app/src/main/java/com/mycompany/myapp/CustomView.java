package com.mycompany.myapp;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.view.View.*;
import java.lang.reflect.*;
import android.util.*;
import android.widget.*;
import android.app.*;
import android.os.*;

public class CustomView extends View implements Runnable, OnTouchListener
{
	private static Field field;
	private static Figure figure;
	private static boolean isGameAvelable;
	//private Handler handler = new Handler();
	private boolean repeat;
	private TextView txt;
	
	public CustomView(Context context, AttributeSet attrs){
		super(context,attrs);
		this.field = new Field(10,15);
		this.figure = FigureFactory.creatRundomFigure(field.getWeight()/2,0);
		isGameAvelable = false;
		repeat = false;
		txt = (TextView) findViewById(R.id.mainTextView1);

	}

	public static void setIsGameAvelable(boolean isGameAvelable)
	{
		CustomView.isGameAvelable = isGameAvelable;
	}

	public static boolean isGameAvelable()
	{
		return isGameAvelable;
	}
	

	public static void setFigure(Figure figure)
	{
		CustomView.figure = figure;
	}

	public static Figure getFigure()
	{
		return figure;
	}

	public static void setField(Field field)
	{
		CustomView.field = field;
	}

	public static Field getField()
	{
		return field;
	}
	
	public synchronized void newGame(){
		this.field = new Field(10, 15);
		this.figure = FigureFactory.creatRundomFigure(field.getWeight()/2,0);
		repeat = false;
		isGameAvelable = true;
	}
	
	public void move(View p1){
		switch (p1.getId()){
			case R.id.mainButtonLeft: figure.left() ;break;
			case R.id.mainButtonRight: figure.right();break;
			case R.id.mainButtonRotate: figure.rotate();break;
			case R.id.mainButtonDown: {
					figure.down();
					if(!figure.isCurrentPositionAvailable()){
						figure.up();
						figure.landed();
						field.removeFullLines();
						figure = FigureFactory.creatRundomFigure(field.getWeight()/2,0);
						if(!figure.isCurrentPositionAvailable())
							gameFinish();
						}
					}
		}
	}

	@Override
	public boolean onTouch(final View p1, MotionEvent p2){
			
		if (isGameAvelable && p2.getAction() == MotionEvent.ACTION_DOWN){
			repeat = true;
			
			new Thread(new Runnable(){

				@Override
				public void run()
				{
					while (repeat)
					{
					 move(p1);
					 postInvalidate();
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException e)
						{}
					}
					 
				}
			}).start();
		
		}
		if (isGameAvelable && p2.getAction() == MotionEvent.ACTION_UP)
			repeat = false;
		return false;
	}
	
	public synchronized void gameFinish(){
		isGameAvelable = false;
	}

	@Override
	public void run()
	{
		int i = 0;
		while(i <4){
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{}
			figure.down();
			if(!figure.isCurrentPositionAvailable()){
				figure.up();
				figure.landed();
				//TextView v = (TextView) findViewById(R.id.mainTextView1);
				//txt.setText("qwerty");
				//txt.postInvalidate();
				field.removeFullLines();
				figure = FigureFactory.creatRundomFigure(field.getWeight()/2,0);
				if(!figure.isCurrentPositionAvailable()){
					gameFinish();
				}
			}
			i++;
			//postInvalidate();
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		int a = getWidth()/(field.getWeight()+2);
		int b = getHeight()/(field.getHeight()+2);
		int fieldSize = (a<b)? a : b;
		
		Paint paint = new Paint();
		canvas.drawColor(Color.WHITE);
		int[][] matrix = new int[field.getMatrix().length][field.getMatrix()[0].length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = field.getMatrix()[i][j];

		int[][] matrix2 = figure.getMatrix();

		for (int i = 0; i < matrix2.length; i++)
			for (int j = 0; j < matrix2[0].length; j++)
				if (matrix2[i][j] == 1)
					matrix[figure.getY()+i][figure.getX()+j] = 1;
		
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawRect(fieldSize,fieldSize,field.getWeight()*fieldSize+fieldSize,field.getHeight()*fieldSize+fieldSize,paint);
		paint.setStyle(Paint.Style.FILL);
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 1)
					canvas.drawRect((j+1)*fieldSize,(i+1)*fieldSize,(j+2)*fieldSize,(i+2)*fieldSize,paint);
		}
}
