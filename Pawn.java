package chess;
class Pawn extends Piece
{
	
	int kill=0;
	char description;
	String colour=new String();
	Pawn(String c)
	{
		description='p';
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
		if(x>7 || x<0 ||x1>7 || x1<0 ||y>7 || y<0 ||y1>7 || y1<0 )
			return false;
		else if(m1==1 && m2==0)
			return true;
		else if(m1==1 && m2==1)
		return true;
	else if(m1==2 && m2==0)
		return true;
	else
	  return false;
		/*else
		{
			if(box[x][y].colour=="white")
			{
				if(y==1 && x==2 || y==1 && x==1)
				{
					return true;
				}
				else if(y!=1 && x==1)
				{
					return true;
				}
				else if(box[x1][y1].piece!=null && x1-x==1 && y1-y==1)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			if(box[x][y].colour=="black")
			{
				if(y==6 && x==-2 || y==6 && x==-1)
				{
					return true;
				}
				else if(y!=6 && x==-1)
				{
					return true;
				}
				else if(box[x1][y1].piece!=null && x1-x==-1 && y1-y==-1)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}*/
	}
	
}