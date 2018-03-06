package chess;
public class Rook extends Piece
{
	
	
	char description;
	boolean availability;
	String colour=new String();
	Rook(String c)
	{
		description='r';
		availability=true;
		colour=c;
	}
	char getdescription()
	{
		return description;
	}
	boolean isValidMove(int x,int y,int x1,int y1)
	{
		if(x>7 || x<0 ||x1>7 || x1<0 ||y>7 || y<0 ||y1>7 || y1<0 )
			return false;
		else
		{
		int m1 = Math.abs(x1-x);
	    int m2 = Math.abs(y1-y);
		if(m1<8 && m2==0 && m1>0 || m2<8 && m1==0 && m2>0)
		{
			/*for(int i=x;i<=x1;i++)
			{
				for(int j=y;j<=y1;j++)
				{
					if(box[i][j].piece!=null)
					{
						return false;
					}
				}
				
			}*/
			return true;
		}
		else
			return false;
		
		
		}
		
	}
	
}