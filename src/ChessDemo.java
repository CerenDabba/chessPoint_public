import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//class that has main method
public class ChessDemo
{
    //Main method. Takes input file from user, reads and saves the file into the chess board,
    //then calls the calculate method.
    public static void main(String[] args)
    {
        System.out.println("--------CS-TECH CHESS TASK--------");
        System.out.println("Please write the txt file's absolute path: ");

        //taking input from user
        Scanner scanner = new Scanner(System.in);
        String inputFileName=scanner.nextLine();

        //creates a chess board object,
        ChessBoard cb=new ChessBoard();
        //saves input file into the chess board
        readInputAndSave(cb,inputFileName);
        //calls its calculate method
        cb.calculate();

        //closes the Scanner
        scanner.close();
    }

    //reads the input file and saves it into the chess board by calling ChessBoard class's saveIntoChessBoard() method.
    //takes ChessBoard object and input filename as parameters
    private static void readInputAndSave(ChessBoard cb, String filename)
    {
        try
        {
            //creating a File object and a BufferReader object to read input file
            File file = new File(filename);
            BufferedReader br= new BufferedReader(new FileReader(file));

            //readLine method reads a single line at a time from input file
            String line = br.readLine();

            //Specifies which row of the chessboard to insert the line.
            int row=0;
            while(line!=null)
            {
                //seperating line by spaces, thus every element of cells array is one chess piece.
                String[] cells=line.split(" ");
                //calling ChessBoard class's method to save each chess piece into the board.
                cb.saveIntoChessBoard(row,cells);
                //reads new line of input file
                line=br.readLine();
                row++;
            }
            //closing BufferReader
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
