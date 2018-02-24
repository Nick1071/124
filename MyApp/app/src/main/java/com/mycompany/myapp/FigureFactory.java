package com.mycompany.myapp;
public class FigureFactory {
    private static final int[][][] figures = new int[][][]{
            {
                    {1, 1, 0},
                    {0, 1, 1},
                    {0, 0, 0}
            },
            {
                    {1, 0, 0},
                    {1, 1, 0},
                    {0, 1, 0}

            },
            {
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0}

            },
            {
                    {1, 1, 0},
                    {1, 1, 0},
                    {0, 0, 0}

            },
            {
                    {1, 1, 1},
                    {0, 1, 0},
                    {0, 0, 0}

            },
            {
                    {1, 1, 1},
                    {1, 1, 1},
                    {0, 0, 0}

            },
			{
					{0, 0, 1},
					{1, 1, 1},
					{0, 0, 0}

			},
			{
					{1, 0, 0},
					{1, 1, 1},
					{0, 0, 0}
 			},

			{
					{0, 1, 0},
					{1, 1, 1},
					{0, 1, 0}
			},
			
    };

    public static Figure creatRundomFigure(int x, int y){
        int i = (int) (Math.random()*9);
        return new Figure(x,y,figures[i]);
    }


}
