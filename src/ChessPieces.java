//class that defines the common attributes of pieces in chess.
public class ChessPieces
{
    //points the row location of chess piece on chess board
    private int row;

    //points the column location of chess piece on chess board
    private int column;

    //defines the color of chess piece
    private String color;

    //defines the point of chess piece according to given table in exam document.
    private double point;

    //constructor method
    public ChessPieces(int row, int column, String color, double point)
    {
        this.row=row;
        this.column=column;
        this.color=color;
        this.point=point;
    }

    //getter and setter methods for private members
    public double getPoint() {
        return point;
    }
    public void setPoint(double point) {
        this.point = point;
    }
    public int getRow() { return row; }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() { return column; }
    public void setColumn(int column) {
        this.column = column;
    }
    public String getColor() { return color; }
    public void setColor(String color) {
        this.color = color;
    }
}
