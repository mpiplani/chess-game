package chess;
class Knight extends Piece
{
	char description;
	String colour=new String();
	Knight(String c)
	{
			description='K';
			availability=true;
			colour=c;
	}
	char getdescription()
	{
		return description;
	}
	
	boolean isValidMove(int x,int y,int x1,int y1)
	{
		int m1 = Math.abs(x1-x);
	    int m2 = Math.abs(y1-y);
		if(x>7 || x<0 ||x1>7 || x1<0 ||y>7 || y<0 ||y1>7 || y1<0 ||(x==x1&&y==y1))
			return false;
		else if(m1==2 && m2==1)
		{
			return true;
		}
		else if(m2==2 && m1==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}