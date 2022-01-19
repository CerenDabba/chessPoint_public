//class that represents chess board
public class ChessBoard
{
    //chess board size, it has 8 rows and 8 columns
    private final int size=8;
    //array represents the chess board, stores chess pieces
    private ChessPieces[][] chessBoard;

    //constructor method
    public ChessBoard()
    {
        chessBoard=new ChessPieces[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                chessBoard[i][j]=null;
            }
        }
    }
    //calculates the total points for white and black
    //prints the results
    public void calculate()
    {
        //total points for black
        double totalPointBlack=0.0;
        //total points for white
        double totalPointWhite=0.0;

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(chessBoard[i][j]!=null)
                {
                    if(isInDanger(chessBoard[i][j])==true)
                    {
                        //found a piece that in danger thus add half of the point
                        if(chessBoard[i][j].getColor().equals("black"))
                        {
                            totalPointBlack=totalPointBlack+(chessBoard[i][j].getPoint()/2.0);
                        }
                        else
                        {
                            totalPointWhite=totalPointWhite+(chessBoard[i][j].getPoint()/2.0);
                        }
                    }
                    else
                    {
                        //piece not in danger thus add the point directly
                        if(chessBoard[i][j].getColor().equals("black"))
                        {
                            totalPointBlack=totalPointBlack+(chessBoard[i][j].getPoint());
                        }
                        else
                        {
                            totalPointWhite=totalPointWhite+(chessBoard[i][j].getPoint());
                        }
                    }
                }
            }
        }
        //printing results
        System.out.println("Total point for black: " + totalPointBlack);
        System.out.println("Total point for white: " + totalPointWhite);
    }

    /*  Takes a chess piece that on board as a parameter and decides if it's in danger or not
        first it decides if it's in danger by a pawn,
        if it's not then it looks for knight and if it's not in danger by knight it looks for queen.
        Returns true if the piece is in danger, otherwise returns false */
    private boolean isInDanger(ChessPieces item)
    {
        boolean isInDanger=isInDangerByPawn(item);
        if(isInDanger==false)
        {
            isInDanger=isInDangerByKnight(item);
        }
        if(isInDanger==false)
        {
            isInDanger=isInDangerByQueen(item);
        }
        return isInDanger;
    }

    //takes a chess piece as a parameter and decides if it is in danger by a knight or not
    //returns true if it is in danger otherwise returns false
    private boolean isInDangerByKnight(ChessPieces item)
    {
        //checks upper left side for horizontal L
        int irow=item.getRow()-1;
        int icolumn=item.getColumn()-2;
        if(irow>-1 && icolumn>-1)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        //checks upper right side for horizontal L
        icolumn=item.getColumn()+2;
        if(irow>-1 && icolumn<size)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        //checks lower left side for horizontal L
        irow=item.getRow()+1;
        icolumn=item.getColumn()-2;
        if(irow<size && icolumn>-1)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        //checks lower right side for horizontal L
        icolumn=item.getColumn()+2;
        if(irow<size && icolumn<size)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        //checks upper left side for vertical L
        irow=item.getRow()-2;
        icolumn=item.getColumn()-1;
        if(irow>-1 && icolumn>-1)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        //checks upper right side for vertical L
        icolumn=item.getColumn()+1;
        if(irow>-1 && icolumn<size)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        //checks lower left side for vertical L
        irow=item.getRow()+2;
        icolumn=item.getColumn()-1;
        if(irow<size && icolumn>-1)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        //checks lower right side for vertical L
        icolumn=item.getColumn()+1;
        if(irow<size && icolumn<size)
        {
            if((chessBoard[irow][icolumn] instanceof Knight) && (!item.getColor().equals(chessBoard[irow][icolumn].getColor())))
            {
                return true;
            }
        }
        return false;
    }

    //takes a chess piece as a parameter and decides if it is in danger by a queen or not
    //returns true if it is in danger otherwise returns false
    private boolean isInDangerByQueen(ChessPieces item)
    {
        boolean isInDanger=false;
        ChessPieces itemD=null;

        //checks down side
        for(int i=item.getRow()+1;i<size;i++)
        {
            itemD=chessBoard[i][item.getColumn()];
            if((itemD instanceof Queen) && (!item.getColor().equals(itemD.getColor())))
            {
                //in danger
                isInDanger=true;
                return isInDanger;
            }
            else if(itemD!=null)
            {
                isInDanger=false;
                break;
            }
        }
        //checks up side
        for(int i=item.getRow()-1;i>-1;i--)
        {
            itemD=chessBoard[i][item.getColumn()];
            if((itemD instanceof Queen) && (!item.getColor().equals(itemD.getColor())))
            {
                //in danger
                isInDanger=true;
                return isInDanger;
            }
            else if(itemD!=null)
            {
                isInDanger=false;
                break;
            }
        }
        //checks right side
        for(int i=item.getColumn()+1;i<size;i++)
        {
            itemD=chessBoard[item.getRow()][i];
            if((itemD instanceof Queen) && (!item.getColor().equals(itemD.getColor())))
            {
                //in danger
                isInDanger=true;
                return isInDanger;
            }
            else if(itemD!=null)
            {
                isInDanger=false;
                break;
            }
        }
        //checks left side
        for(int i=item.getColumn()-1;i>-1;i--)
        {
            itemD=chessBoard[item.getRow()][i];
            if((itemD instanceof Queen) && (!item.getColor().equals(itemD.getColor())))
            {
                //in danger
                isInDanger=true;
                return isInDanger;
            }
            else if(itemD!=null)
            {
                isInDanger=false;
                break;
            }
        }
        //checks upper left side
        int i=item.getRow()-1;
        int j=item.getColumn()-1;
        while(i>-1 && j>-1)
        {
            if((chessBoard[i][j] instanceof Queen) && (!chessBoard[i][j].getColor().equals(item.getColor())))
            {
                isInDanger=true;
                return isInDanger;
            }
            else if(chessBoard[i][j]!=null)
            {
                isInDanger=false;
                break;
            }
            i--;
            j--;
        }
        //checks upper right side
        i=item.getRow()-1;
        j=item.getColumn()+1;
        while(i>-1 && j<size)
        {
            if(chessBoard[i][j] instanceof Queen && !chessBoard[i][j].getColor().equals(item.getColor()))
            {
                isInDanger=true;
                return isInDanger;
            }
            else if(chessBoard[i][j]!=null)
            {
                isInDanger=false;
                break;
            }
            i--;
            j++;
        }
        //checks lower left side
        i=item.getRow()+1;
        j=item.getColumn()-1;
        while(i<size && j>-1)
        {
            if(chessBoard[i][j] instanceof Queen && !chessBoard[i][j].getColor().equals(item.getColor()))
            {
                isInDanger=true;
                return isInDanger;
            }
            else if(chessBoard[i][j]!=null)
            {
                isInDanger=false;
                break;
            }
            i++;
            j--;
        }
        //checks lower right side
        i=item.getRow()+1;
        j=item.getColumn()+1;
        while(i<size && j<size)
        {
            if(chessBoard[i][j] instanceof Queen && !chessBoard[i][j].getColor().equals(item.getColor()))
            {
                isInDanger=true;
                return isInDanger;
            }
            else if(chessBoard[i][j]!=null)
            {
                isInDanger=false;
                break;
            }
            i++;
            j++;
        }
        return isInDanger;
    }

    //takes a chess piece as a parameter and decides if it is in danger by a pawn or not
    //returns true if it is in danger otherwise returns false
    private boolean isInDangerByPawn(ChessPieces item)
    {
        boolean isInDanger=false;
        ChessPieces itemD=null;
        if(item.getRow()>0)
        {
            if(item.getColumn()>0)
            {
                //checks upper left side
                itemD=chessBoard[item.getRow()-1][item.getColumn()-1];
                if(itemD instanceof Pawn && (!item.getColor().equals(itemD.getColor())))
                {
                    isInDanger=true;
                    return isInDanger;
                }
            }
            if(item.getColumn()<size-1)
            {
                //checks upper right side
                itemD=chessBoard[item.getRow()-1][item.getColumn()+1];
                if(itemD instanceof Pawn && (!item.getColor().equals(itemD.getColor())))
                {
                    isInDanger=true;
                    return isInDanger;
                }
            }
        }
        if(item.getRow()<size-1)
        {
            if(item.getColumn()>0)
            {
                //checks lower left side
                itemD=chessBoard[item.getRow()+1][item.getColumn()-1];
                if(itemD instanceof Pawn && (!item.getColor().equals(itemD.getColor())))
                {
                    isInDanger=true;
                    return isInDanger;
                }
            }
            if(item.getColumn()<size-1)
            {
                //checks lower right side
                itemD=chessBoard[item.getRow()+1][item.getColumn()+1];
                if(itemD instanceof Pawn && (!item.getColor().equals(itemD.getColor())))
                {
                    isInDanger=true;
                    return isInDanger;
                }
            }
        }
        return isInDanger;
    }

    //takes a integer row index and a String array as parameters
    //for every element in cells array creates an appropriate object with given row index and same column index as in cells array
    //specifies the color of piece and the point of piece while creating the object.
    //adds these object in chessBoard array. For empty cells(representing with --) it adds null.
    public void saveIntoChessBoard(int row,String[] cells)
    {
        for(int i=0;i<cells.length;i++)
        {
            if(cells[i].equals("ks"))
            {
                chessBoard[row][i]=new Rook(row,i,"black",5.0);
            }
            else if(cells[i].equals("as"))
            {
                chessBoard[row][i]=new Knight(row,i,"black",3.0);
            }
            else if(cells[i].equals("fs"))
            {
                chessBoard[row][i]=new Bishop(row,i,"black",3.0);
            }
            else if(cells[i].equals("vs"))
            {
                chessBoard[row][i]=new Queen(row,i,"black",9.0);
            }
            else if(cells[i].equals("ss"))
            {
                chessBoard[row][i]=new King(row,i,"black",100.0);
            }
            else if(cells[i].equals("ps"))
            {
                chessBoard[row][i]=new Pawn(row,i,"black",1.0);
            }
            else if(cells[i].equals("--"))
            {
                chessBoard[row][i]=null;
            }
            else if(cells[i].equals("kb"))
            {
                chessBoard[row][i]=new Rook(row,i,"white",5.0);
            }
            else if(cells[i].equals("ab"))
            {
                chessBoard[row][i]=new Knight(row,i,"white",3.0);
            }
            else if(cells[i].equals("fb"))
            {
                chessBoard[row][i]=new Bishop(row,i,"white",3.0);
            }
            else if(cells[i].equals("vb"))
            {
                chessBoard[row][i]=new Queen(row,i,"white",9.0);
            }
            else if(cells[i].equals("sb"))
            {
                chessBoard[row][i]=new King(row,i,"white",100.0);
            }
            else if(cells[i].equals("pb"))
            {
                chessBoard[row][i]=new Pawn(row,i,"white",1.0);
            }
        }
    }

    //this is an unused method for printing chess board
    //it can be called from outside of the class using ChessBoard object.
    public void printBoard()
    {
        System.out.println("*****chess board start*****");
        for(int i=0;i<chessBoard.length;i++)
        {
            for(int j=0;j<chessBoard[i].length;j++)
            {
                System.out.print(chessBoard[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("*****chess board  end*****");
    }
}
