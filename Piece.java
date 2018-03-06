package chess;
abstract public class Piece
{
	String colour=new String();
	char description;
	boolean availability;
	abstract boolean isValidMove(int x,int y,int x1,int y1);
	abstract char getdescription();
}