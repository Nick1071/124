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
	}
	public void right(){
		x++;
	}

	public void down(){
		y++;
	}

	public void downMaximum(){}

	public void rotate(){}

	public boolean isCurrentPositionAvailable(){
		return true;
	}

	public void landed(){}
}
