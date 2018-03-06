package chess;
import java.util.Scanner;
class Game 
{
	public static void main(String args[])
	{
		board b1=new board();
		b1.create();
		//int player[]=new int[2];
		//0 means white
		//1 means black;
		//player[0]=0;
		//player[1]=1;
		int initialx=0;
		int initialy=0;
		int finalx=0;
		int finaly=0;
		Scanner scan=new Scanner( System.in);
		while(true)
		{
			b1.displayboard();
			System.out.println();
			System.out.print("Player white turn");
			while(true)
			{
				try
				{
				System.out.println();	
				System.out.println("please enter the initial coordinates ");
				initialx=scan.nextInt();
				initialy=scan.nextInt();
				System.out.println();
				System.out.println("please enter the final coordinates ");
				finalx=scan.nextInt();
				finaly=scan.nextInt();
				if(b1.turn(0,initialx,initialy))
				{
					b1.displayboard();
					if(b1.Move(initialx,initialy,finalx,finaly))
					{
						if(b1.validity(initialx,initialy,finalx,finaly))
						{
							if(!b1.checkm(initialx,initialy,finalx,finaly))
							{/*if(b1.myturn(initialx,initialy,finalx,finaly)){*/
								System.out.println("valid move");
								b1.updateboard(initialx,initialy,finalx,finaly);
								b1.displayboard();
					
								break;
							}
							else
									{
										System.out.println("check on me");
										if(b1.myturn(initialx,initialy,finalx,finaly)){
											System.out.println("valid move");
										b1.updateboard(initialx,initialy,finalx,finaly);
										b1.displayboard();
					
										break;}
									}
						}
						
						else
						{
							System.out.println("invalid move by validity");
							System.out.println("enter again");
					
						}
					}
					
			 
						
						else
						{
							System.out.println("invalid moveby move");
							System.out.println("enter again");
					
						}
					
				}
				else
				{
					System.out.println("wrong turn");
				}
			}
			catch(Exception e)
			{
				System.out.println("wrong input");
				scan.next();
			}
			}
			/*	if(b1.gameover(finalx,finaly))
				{
					break;
				}*/
			if(b1.check(initialx,initialy,finalx,finaly))
			{
				        System.out.print("check is being called");
			
					
			}
			System.out.println();
			System.out.print("Player black turn");
			while(true)
			{
				try{
					System.out.println();
				System.out.println("please enter the initial coordinates ");
				initialx=scan.nextInt();
				initialy=scan.nextInt();
				System.out.println();
				System.out.println("please enter the final coordinates ");
				finalx=scan.nextInt();
				finaly=scan.nextInt();
				//there shud be a function to return the piece at initialx and initialy
				//suppose it is stored in variable Piece p
				//i think this shud be in class board;;;
				if(b1.turn(1,initialx,initialy))
				{
					if(b1.Move(initialx,initialy,finalx,finaly))
					{
						if(b1.validity(initialx,initialy,finalx,finaly))
							{
								if(!b1.checkm(initialx,initialy,finalx,finaly))
									{
										/*if(b1.myturn(initialx,initialy,finalx,finaly)){*/
										System.out.println("valid move");
										b1.updateboard(initialx,initialy,finalx,finaly);
										b1.displayboard();
					
										break;
									}
									else
									{
										System.out.println("check on me");
										if(b1.myturn(initialx,initialy,finalx,finaly)){
											System.out.println("valid move");
										b1.updateboard(initialx,initialy,finalx,finaly);
										b1.displayboard();
					
										break;}
									}
							}
			 
				
							else
							{
								System.out.print("invalid move by validity");
								System.out.println("enter again");
							}
					}
					else
					{
						System.out.print("invalid move by move");
						System.out.println("enter again");
					}
				}
			
				else
				{
					System.out.println("wrong turn");
				}
				}
				catch(Exception e)
				{
					System.out.println("wrong input");
					scan.next();
				}
			}
			/*if(b1.gameover(finalx,finaly))
			{
				break;
			}*/
			if(b1.check(initialx,initialy,finalx,finaly))
			{
				System.out.print("check is being called");
						
			}
		}
	}
}
		