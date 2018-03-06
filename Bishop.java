package chess;
class Bishop extends Piece
{
	char description;
	String colour=new String();
	Bishop(String c)
	{
		description='b';
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
		else
		{
			if(m1==m2 && m1<8&&m1>0)
			{
				/*for(int i=x;i<=x1;i++)
				{
					for(int j=y;j<=y1;j++)
					{
						if(i==j)
						{
							if(box[i][j].piece!=null)
							{
						
								return false;
							}
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