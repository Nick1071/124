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

            }
    };

    public static Figure creatRundomFigure(){
        int i = (int) (Math.random()*6);
        return new Figure(0,0,figures[i]);
    }


}
