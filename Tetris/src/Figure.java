public class Figure
{
	private int x;
	private int y;
	private int [][] matrix;

	public Figure(int x, int y, int[][] matrix)
	{
		this.x = x;
		this.y = y;
		this.matrix = matrix;
	}
	
	public void left(){}
	public void right(){}
	public void up(){}
	public void down(){}
	public void diwnMaximum(){}
	public void rotate(){}
	public boolean isCurrentPositionAvailable(){
		return true;
	}
	public void landed(){}
	
}
