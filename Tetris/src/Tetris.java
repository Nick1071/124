import java.util.Arrays;

public class Tetris
{
	private Field field;
	private Figure figure;
	public static Tetris game;
	private boolean isGameOver;

	public Tetris(int weight, int height) {
		this.field = new Field(weight, height);
		this.figure = FigureFactory.creatRundomFigure(weight/2-1,0);
		this.isGameOver = false;
	}


	public Field getField()
	{
		return field;
	}

	public void print(){
		int[][] matrix = new int[field.getMatrix().length][field.getMatrix()[0].length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = field.getMatrix()[i][j];

		int[][] matrix2 = figure.getMatrix();

		for (int i = 0; i < matrix2.length; i++)
			for (int j = 0; j < matrix2[0].length; j++)
				if (matrix2[i][j] == 1)
					matrix[figure.getY()+i][figure.getX()+j] = 1;

		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("X");
			System.out.println();
		}
	}

	public void run(){
		KeyboardObserver keyboardObserver = new KeyboardObserver();
		while (!isGameOver){
			print();
			switch (keyboardObserver.getMove()){
				case LEFT: figure.left();break;
				case RIGHT: figure.right();break;
				case DOWNMAX: figure.downMaximum();break;
				case ROTATE: figure.rotate();break;
			}
			step();
			}
		System.out.println("Game over.");
		}

	public void step(){
		figure.down();
		
	}
	
	public static void main(String[] args)
	{
		game = new Tetris(10,12);
		game.run();
	}
}
