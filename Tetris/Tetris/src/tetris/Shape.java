package tetris;

import java.util.Random;
import java.lang.Math;


public class Shape {

    enum Tetrominoes { NoShape, ZShape, SShape, LineShape,// this is information about a tetris piece. 
               TShape, SquareShape, LShape, MirroredLShape };//The Tetrominoes enum holds all seven tetris shapes. Plus the empty shape called here NoShape.

    private Tetrominoes pieceShape;
    private int coords[][];
    private int[][][] coordsTable;


    public Shape() {   //This is the constructor of the this class.

        coords = new int[4][2];//The coords array holds the actual coordinates of a Tetris piece.
        setShape(Tetrominoes.NoShape);

    }

    public void setShape(Tetrominoes shape) { 

         coordsTable = new int[][][] { // The coordsTable -> array holds  all possible coordinate values of our tetris pieces.
            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },//This is a template from which all pieces take their coordiate values.
            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
        };

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordsTable[shape.ordinal()][i][j];//Here we put one row of the coordiate values from the coordsTable                                                                
            }                                                     //to a coords array of a tetris piece.                                                
        }                                //Note we use of the ordinal() method. because in Java enums are full classes.
        pieceShape = shape;             // And the ordinal() method returns the current position of the enum type in the enum object.

    }

    private void setX(int index, int x) { coords[index][0] = x; }
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    public Tetrominoes getShape()  { return pieceShape; }

    public void setRandomShape()
    {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoes[] values = Tetrominoes.values(); 
        setShape(values[x]);
    }

    public int minX()
    {
      int m = coords[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = coords[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][1]);
      }
      return m;
    }

    public Shape rotateLeft()//This code rotates the piece to the left. The square does not have to be rotated. 
    {                        //That's why we simply return the reference to the current object.
        if (pieceShape == Tetrominoes.SquareShape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    public Shape rotateRight()//This code rotates the piece to the right.
    {                         
        if (pieceShape == Tetrominoes.SquareShape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}