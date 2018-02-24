package com.mycompany.myapp;
import java.util.*;
public class Field
{
	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	private int weight;
	private int height;
	private int [][] matrix;

	public Field(int weight, int height)
	{
		this.weight = weight;
		this.height = height;
		this.matrix = new int [height][weight];
	}
	

	
	public synchronized int removeFullLines(){
		int[] zeroLine = new int [weight];
		List<int[]> list = new LinkedList <>();
		for(int i=0;i < height; i++)
			for(int j = 0; j < weight; j++)
				if(matrix [i][j] == 0){
					list.add(matrix[i]);
					break;
					}
		int i = height-list.size();
		while(list.size() < height)
			((LinkedList)list).addFirst(zeroLine);
		matrix = list.toArray(new int[0][]);
		return i;
	}
}
