package com.mycompany.myapp;
import android.view.*;
import java.util.zip.*;

public class Figure
{
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	private int [][] matrix;

	public Figure(int x, int y, int[][] matrix)
	{
		this.x = x;
		this.y = y;
		this.matrix = matrix;
	}
	
	public void left(){
		x--;
		if(!isCurrentPositionAvailable()) 
			x++;
	}
	public void right(){
		x++;
		if(!isCurrentPositionAvailable())
			x--;
	}

	public synchronized void  down(){
		y++;
	}
	
	public synchronized void up(){
		y--;
	}

	public void rotate(){
		int [][] matrixTmp = new int [3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0;j < 3; j++)
				matrixTmp [i][j] = matrix[i][j];
		matrix [2][0] = matrixTmp [0][0];
		matrix [1][0] = matrixTmp [0][1];
		matrix [0][0] = matrixTmp [0][2];
		matrix [2][1] = matrixTmp [1][0];
		matrix [0][1] = matrixTmp [1][2];
		matrix [2][2] = matrixTmp [2][0];
		matrix [1][2] = matrixTmp [2][1];
		matrix [0][2] = matrixTmp [2][2];
		
		if(!isCurrentPositionAvailable())
			matrix=matrixTmp;
	}

	public synchronized boolean isCurrentPositionAvailable(){
		Field field = CustomView.getField();
		for(int i = 0; i < 3; i++)
			for(int j = 0;j < 3; j++)
				if((matrix [i][j] == 1) && (x + j > field.getWeight()-1 || x +j < 0 || y + i > field.getHeight()-1 || y+i <0 || field.getMatrix() [y+i][x+j] == 1))
					return false;
		return true;
	}

	public synchronized void landed(){
		Field field = CustomView.getField();
		for(int i = 0; i < 3; i++)
			for(int j = 0;j < 3; j++)
				if(matrix [i][j] == 1) field.getMatrix()[y+i][x+j] = 1;
	}
}
