package chess;
import java.lang.*;
class board 
{
	Box box[][]=new Box[8][8];
	King king[]=new King[2];
	Queen queen[]=new Queen[2];
	Bishop bishop[]=new Bishop[4];
	Pawn pawn[]=new Pawn[16];
	Rook rook[]=new Rook[4];
	Knight knight[]=new Knight[4];
	int kingx=0;
	int kingy=0;
	
	
        board()
		{
			king[0] = new King("white");
			king[1] = new King("black");
			queen[0] = new Queen("white");
			queen[1] = new Queen("black");
			rook[0] = new Rook("white");
			rook[1] = new Rook("white");
			rook[2] = new Rook("black");
			rook[3] = new Rook("black");
			bishop[0] = new Bishop("white");
			bishop[1] = new Bishop("white");
			bishop[2] = new Bishop("black");
			bishop[3] = new Bishop("black");
			knight[0] = new Knight("white");
			knight[1] = new Knight("white");
			knight[2] = new Knight("black");
			knight[3] = new Knight("black");
  
  for(int i=0;i<8;i++)
	  pawn[i] = new Pawn("white");
 
  for(int i=8;i<16;i++)
	  pawn[i] = new Pawn("black");
  
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					box[i][j]=new Box();
					box[i][j].colour=" ";
					
					//box[i][j].description=box[i][j].piece.getdescription();
				}
			}
			
		}
		//0,1 means white
		//2,3 means black 
	void create()
	{
		                                                                             
	   box[0][0].piece=rook[0];
	   box[0][0].colour="white";
	   box[0][0].description=box[0][0].piece.getdescription();
	   box[0][1].piece=knight[0];
	   box[0][1].description=box[0][1].piece.getdescription();
	   box[0][1].colour="white";
	   box[0][2].piece=bishop[0];
	   box[0][2].description=box[0][2].piece.getdescription();
	   box[0][2].colour="white";
	   box[0][3].piece=queen[0];
	   box[0][3].colour="white";
	   box[0][3].description=box[0][3].piece.getdescription();
	    box[0][4].piece=king[0];
	   box[0][4].colour="white";
	   box[0][4].description=box[0][4].piece.getdescription();
	    box[0][5].piece=bishop[1];
	   box[0][5].colour="white";
	   box[0][5].description=box[0][5].piece.getdescription();
	    box[0][6].piece=knight[1];
	   box[0][6].colour="white";
	   box[0][6].description=box[0][6].piece.getdescription();
	    box[0][7].piece=rook[1];
	   box[0][7].colour="white";
	   box[0][7].description=box[0][7].piece.getdescription();
	   for(int i=0;i<8;i++)
	   {
			box[1][i].piece=pawn[i];
			box[1][i].colour="white";
			box[1][i].description=box[1][i].piece.getdescription();
		}
		box[7][0].piece=rook[2];
	   box[7][0].colour="black";
	   box[7][0].description=box[7][0].piece.getdescription();
	   box[7][1].piece=knight[2];
	   box[7][1].colour="black";
	   box[7][1].description=box[7][1].piece.getdescription();
	   box[7][2].piece=bishop[2];
	   box[7][2].colour="black";
	   box[7][2].description=box[7][2].piece.getdescription();
	   box[7][3].piece=queen[1];
	   box[7][3].colour="black";
	   box[7][3].description=box[7][3].piece.getdescription();
	    box[7][4].piece=king[1];
		box[7][4].description=box[7][4].piece.getdescription();
	   box[7][4].colour="black";
	    box[7][5].piece=bishop[3];
	   box[7][5].colour="black";
	   box[7][5].description=box[7][5].piece.getdescription();
	    box[7][6].piece=knight[3];
	   box[7][6].colour="black";
	   box[7][6].description=box[7][6].piece.getdescription();
	    box[7][7].piece=rook[3];
	   box[7][7].colour="black";
	   box[7][7].description=box[7][7].piece.getdescription();
	   for(int i=0;i<8;i++)
	   {
			box[6][i].piece=pawn[8+i];
			box[6][i].colour="black";
			box[6][i].description=box[6][i].piece.getdescription();
		}
	}
	boolean turn(int t,int x,int y)
	{
		if(t==0)
		{
			//white
			if(box[x][y].colour=="white")
				return true;
			else 
				return false;
		}
		else if(t==1)
		{
			//black
			if(box[x][y].colour=="black")
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	void updateboard(int x,int y,int x1,int y1)
	{
		if(box[x1][y1].piece!=null)
		{
			box[x1][y1].piece.availability=false;
		}
		
		box[x1][y1].piece=box[x][y].piece;
		box[x1][y1].colour=box[x][y].colour;
		box[x1][y1].description=box[x][y].description;
		box[x][y].piece=null;
		box[x][y].colour=" ";
		box[x][y].description='\0';
	}
	void displayboard()
	{
		for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					if(box[i][j].piece==null)
						System.out.print("  -\t");
					else
					System.out.print(box[i][j].description+""+box[i][j].colour+"\t ");
				}
				System.out.println();
				System.out.println();System.out.println();
				System.out.println();
				
				
			}	
	}
	boolean Move(int x,int y,int x1,int y1)
	{
		if(box[x][y].piece==null)
			return false;
		if(box[x1][y1].piece!=null)
		{
			if(box[x1][y1].colour==box[x][y].colour)
			{
			return false;
			}
			else 
				return true;
		}
			
		if(box[x][y].piece.isValidMove(x,y,x1,y1))
			return true;
		else
			return false;
	}
	boolean validity(int x,int y,int x1,int y1)
	{
		if(box[x][y].piece==queen[0] || box[x][y].piece==queen[1])
		{
			if(y1-y==0 || x1-x==0)
			{
				if(y1-y==0)
				{
					for(int i=Math.min(x,x1);i<Math.max(x,x1);i++)
					{
						for(int j=y;j<=y1;j++)
						{
						
							if(box[i][j].piece!=null && box[i][j].piece!=box[x][y].piece && i!=x1)
							{
								return false;
							}
						}
				
					}
				}
				if(x1-x==0)
				{
					for(int i=Math.min(y,y1);i<Math.max(y,y1);i++)
					{
						for(int j=x;j<=x1;j++)
						{
						
							if(box[j][i].piece!=null && box[j][i].piece!=box[x][y].piece && i!=y1)
							{
								return false;
							}
						}
				
					}
				}
				return true;
			}
			if(Math.abs(x1-x)==Math.abs(y1-y))
			{
				for(int i=Math.min(x,x1);i<=Math.max(x,x1);i++)
				{
					for(int j=Math.min(y,y1);j<=Math.max(y,y1);j++)
					{
						if(i==j && i>Math.min(x,x1) && i<=Math.max(x,x1) && j>Math.min(y,y1) && j<=Math.max(y,y1))
						{
							if(box[i][j].piece!=null && box[i][j].piece!=box[x][y].piece)
							{
						
								return false;
							}
							else if(box[x1][y1].colour==box[x][y].colour)
								
								{
									return false;
								}
								else 
									return true;
						}
					}
				}
				
			}
				
		
		}
		else if(box[x][y].piece==king[0]|| box[x][y].piece==king[1])
		{
			if(box[x1][y1].colour==box[x][y].colour)
				return false;
			return true;
		}
		else if(box[x][y].piece==rook[0] || box[x][y].piece==rook[1] || box[x][y].piece==rook[2] || box[x][y].piece==rook[3])
		{
			if(y1-y==0)
			{
				for(int i=Math.min(x,x1);i<Math.max(x,x1);i++)
				{
					for(int j=y;j<=y1;j++)
					{
						
						if(box[i][j].piece!=null && box[i][j].piece!=box[x][y].piece && i!=x1)
						{
							return false;
						}
					}
				
				}
			}
			if(x1-x==0)
			{
				for(int i=Math.min(y,y1);i<Math.max(y,y1);i++)
				{
					for(int j=x;j<=x1;j++)
					{
						
						if(box[j][i].piece!=null && box[i][j].piece!=box[x][y].piece && i!=y1)
						{
							return false;
						}
					}
				
				}
			}
			return true;
		}
		else if(box[x][y].piece==bishop[0] || box[x][y].piece==bishop[1] || box[x][y].piece==bishop[2] || box[x][y].piece==bishop[3])
		{
			for(int i=Math.min(x,x1);i<=Math.max(x,x1);i++)
				{
					for(int j=Math.min(y,y1);j<=Math.max(y,y1);j++)
					{
						if(i==j && i>Math.min(x,x1) && i<=Math.max(x,x1) && j>Math.min(y,y1) && j<=Math.max(y,y1))
						{
							if(box[i][j].piece!=null && box[i][j].piece!=box[x][y].piece)
							{
						
								return false;
							}
							else if(box[x1][y1].colour==box[x][y].colour)
								
								{
									return false;
								}
								else 
									return true;
						}
					}
				}
				
		}
		else if(box[x][y].piece==knight[0] || box[x][y].piece==knight[1] || box[x][y].piece==knight[2] || box[x][y].piece==knight[3])
		{
			if(box[x1][y1].colour==box[x][y].colour)
				return false;
			return true;
		}
		else if(box[x][y].piece==pawn[0] || box[x][y].piece==pawn[1] || box[x][y].piece==pawn[2] || box[x][y].piece==pawn[3] || box[x][y].piece==pawn[4] || box[x][y].piece==pawn[5] || box[x][y].piece==pawn[6] || box[x][y].piece==pawn[7]|| box[x][y].piece==pawn[8] || box[x][y].piece==pawn[9] || box[x][y].piece==pawn[10] || box[x][y].piece==pawn[11] || box[x][y].piece==pawn[12] || box[x][y].piece==pawn[13] || box[x][y].piece==pawn[14] || box[x][y].piece==pawn[15])
		{
			if(box[x][y].colour=="white")
			{
				if(y1-y==0 && x1-x==2  && x==1|| y1-y==0 && x1-x==1)
				{
					return true;
				}
				
				else if(box[x1][y1].piece!=null && x1-x==1 && (y1-y==1 || y1-y==-1) && box[x1][y1].colour!=box[x][y].colour)
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
				if(y1-y==0 && x1-x==-2 && x==6 || y1-y==0 && x1-x==-1)
				{
					return true;
				}
				
				else if(box[x1][y1].piece!=null && x1-x==-1 && (y1-y==1 || y1-y==-1) && box[x1][y1].colour!=box[x][y].colour)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
	    
			return true;
	}
	void getkingposition(String c)
	{
		//System.out.println("function called"+c);
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(c=="white")
				{
					if(box[i][j].piece==king[1])
					{
						kingx=i;
						kingy=j;
					}
				}
				else if(c=="black")
				{
					if(box[i][j].piece==king[0])
					{
						kingx=i;
						kingy=j;
					}
				}
			}
		}
	}
	boolean check(int x,int y,int x1,int y1)
	{
		//System.out.print(box[x1][y1].colour);
		getkingposition(box[x1][y1].colour);
		//System.out.println(kingx+" " +kingy);
		/*if((box[x1][y1].piece==king[0] && box[x][y].piece!=king[0])|| ( box[x1][y1].piece==king[1] && box[x][y].piece!=king[1] ) && box[x1][y1].colour!=box[x][y].colour)
		{
			System.out.println("game over");
			return true;
		}*/
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(box[i][j].piece!=null && box[i][j].colour!=box[kingx][kingy].colour && box[i][j].piece!=king[0] && box[i][j].piece!=king[1])
				{
				System.out.println("checking piece "+i+" "+j);
					if(box[i][j].piece.isValidMove(i,j,kingx,kingy))
					{
						System.out.println("piece move valid");
						if(validity(i,j,kingx,kingy))
						{
							System.out.println(i+" "+j);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	/*boolean checkm(int x,int y,int x1,int y1)
	{
		boolean ch;

		//System.out.println("box colour"+box[x][y].colour);
		if(box[x][y].colour=="white")
		{
		//	System.out.println("w");
			getkingposition("black");
		}
	    else
		{
			//System.out.println("w");
			getkingposition("white");
		}			
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(box[i][j].piece!=null && box[i][j].colour!=box[kingx][kingy].colour && box[i][j].piece!=king[0] && box[i][j].piece!=king[1])
				{
					//System.out.println("checking piece "+i+" "+j);
					if(box[i][j].piece.isValidMove(i,j,kingx,kingy))
					{
					//	System.out.println("piece move valid");
						if(validity(i,j,kingx,kingy))
						{
							System.out.println(i+" "+j);
							return true;
						}
					}
				}
			}
		}
		return false;
		
	}*/
	boolean checkm(int x,int y,int x1,int y1)
	{
		boolean ch;

		//System.out.println("box colour"+box[x][y].colour);
		if(box[x][y].colour=="white")
		{
		//	System.out.println("w");
			getkingposition("black");
		}
	    else
		{
			//System.out.println("w");
			getkingposition("white");
		}			
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(box[i][j].piece!=null && box[i][j].colour!=box[kingx][kingy].colour && box[i][j].piece!=king[0] && box[i][j].piece!=king[1])
				{
					//System.out.println("checking piece "+i+" "+j);
					if(box[i][j].piece.isValidMove(i,j,kingx,kingy))
					{
					//	System.out.println("piece move valid");
						if(validity(i,j,kingx,kingy))
						{
							System.out.println(i+" "+j);
							return true;
							
						}
					}
				}
			}
		}
		return false;
	}
		boolean myturn(int x,int y,int x1,int y1)
		{
			System.out.println("my turn function called");
						if(box[x][y].piece.isValidMove(x,y,x1,y1))
						{
							if(validity(x,y,x1,y1))
							{
								System.out.println("move valid");
								//updateboard(x,y,x1,y1);
								if(!checkm( x1, y1,0,0))
								{
									System.out.println("now no check");
								return true;
								}
							}
						}
					
				
			return false;
			
		}
	/*boolean gameover(int x1,int y1)
	{
		if(box[x1][y1].piece!=null)
		{
			if(box[x1][y1].piece==king[0] || box[x1][y1].piece==king[1]  && box[x][y])
				return true;
			else
				return false;
		}
		else
			return false;
	}*/
}
//checkm mein voh condition daalo ki agar jis position se check aa raha hai usko koi maar paye toh check hatv jaana chahiye..//put try catch in input in game class