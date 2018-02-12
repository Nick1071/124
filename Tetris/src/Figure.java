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

	public void down(){
		y++;
		if(!isCurrentPositionAvailable())
			y--;
	}

	public void downMaximum(){
		while(isCurrentPositionAvailable())
			y++;
		y--;	
	}

	public void rotate(){}

	public boolean isCurrentPositionAvailable(){
		Field field = Tetris.game.getField();
		for(int i = 0; i < 3; i++)
			for(int j = 0;j < 3; j++)
				if((matrix [i][j] == 1) && (x + j > field.getWeight()-1 || x +j < 0 || y + i > field.getHeight()-1))
					return false;
		return true;
	}

	public void landed(){}
}
