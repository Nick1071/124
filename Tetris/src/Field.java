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
	

	
	public void removeFullLines(){
		
	}
	
	public int getValue(int x,int y){
		
		return 0;
	}
	
	public void setValue(int x,int y,int value){
		
	}
	
	
}
