package chess;
class King extends Piece
{
	char description;
	int kill=0;
	String colour=new String();
	King(String c)
	{
			description='k';
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
			 if(m1==1 && m2==0 || m1==0 && m2==1)
				 
				 {
					 return true;
				 }
				 else if(m1==m2 && m1==1)
					 
					 {
						 return true;
					 }
			 else
			     return false;
		 }
	}
}