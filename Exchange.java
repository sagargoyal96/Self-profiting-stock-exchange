package hello;
import java.io.*;
import java.util.*;
public class Exchange {
	
	node faltu=new node();
	
	static qu buy=new qu();
	static qu sell = new qu();
	int totalprofit=0;
	FileOutputStream ou;
	PrintWriter exch;
	
	
	FileOutputStream clean;
	PrintWriter cleanup;
	
	public Exchange()
	{
		
		
		
		try {
			ou=new FileOutputStream("exc.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	exch=new PrintWriter(ou);
	
	try {
		clean=new FileOutputStream("cleanup.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	cleanup=new PrintWriter(clean);
	
	
	}
	
	
	
		//match orders
	public void exentry(qu q1)
	{
		int profit;
		
		node store=new node();
		
		node tr =new node();
		tr=q1.allthings(3, faltu);
		node trblist=new node();
		trblist=buy.allthings(3,faltu);
		node trslist= new node();
		trslist=sell.allthings(3,faltu);
		
		String tell="";
		
		System.out.println("reached the exchange class");
		//test.lasttime=stock.q2.last.yup.T0+stock.q2.last.yup.Texp;
		
		
		while(tr!=null){
			int maxprofit=0;
			tell= " ";
			if((System.currentTimeMillis()-Time.getTime()) >= tr.yup.T0*1000 &&(System.currentTimeMillis()-Time.getTime())< (tr.yup.T0+tr.yup.Texp)*1000){			
			    {if(tr.yup.Type.compareToIgnoreCase("sell")==0)
			    {
				tell=" ";
			while(trblist!=null)
			{
			
			if(trblist.yup.Stock.compareTo(tr.yup.Stock)==0 && (System.currentTimeMillis()-Time.getTime())<(trblist.yup.T0+trblist.yup.Texp)*1000)
				{
				if(trblist.yup.Qty==tr.yup.Qty )
				{
					profit=trblist.yup.Qty *(trblist.yup.Price - tr.yup.Price);
					if(profit>maxprofit )
						{maxprofit=profit;
						store=trblist;
						tell="chill";
						}
					
				}
				
				else if(trblist.yup.Qty<tr.yup.Qty && tr.yup.Partial==true && trblist.yup.Qty>0)
				{
					profit=trblist.yup.Qty *(trblist.yup.Price - tr.yup.Price);
					if(profit>maxprofit)
					{
						maxprofit=profit;
						store=trblist;
						tell="subfrom_tr";
					}
				}
				
				else if(trblist.yup.Qty>tr.yup.Qty && trblist.yup.Partial==true)
				{
					profit=tr.yup.Qty *(trblist.yup.Price - tr.yup.Price);
					if(profit>maxprofit)
					{
						maxprofit=profit;
						store=trblist;
						tell="subfrom_trlist";
					}
				}
				
				
			}
			trblist=trblist.a;
			}
			
			trblist=buy.allthings(3,faltu);
		
			if(maxprofit>=0 && tell.compareTo("subfrom_tr")==0)
			{
				
				sell.allthings(1,tr);
				
			//cleanup store
				exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
					store.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
						tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty+ " "+ 
					tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
				
				exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
						store.yup.Qty+" "+store.yup.T0 +" "+ store.yup.Name+" "+ 
							store.yup.Texp+" "+ store.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
						store.yup.Stock +" " + store.yup.Price+" "+ store.yup.Partial );
				
				tr.yup.Qty=tr.yup.Qty-store.yup.Qty;
				
				exch.println("S "+ (System.currentTimeMillis() - test.time) + " " + 
						tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
							tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty+ " "+ 
						tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
				
				
				store.yup.Qty=0;
				
				q1.allthings(2,tr);
				totalprofit+=maxprofit;
				
				exch.flush();
			}
			
			else if(maxprofit>=0 && tell.compareToIgnoreCase("subfrom_trlist")==0)
					{
						
						
						exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
								tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
									tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty+ " "+ 
								tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
						
						exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
								store.yup.Qty+" "+store.yup.T0 +" "+ store.yup.Name+" "+ 
									store.yup.Texp+" "+ store.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
								store.yup.Stock +" " + store.yup.Price+" "+ store.yup.Partial );
						
						store.yup.Qty=store.yup.Qty-tr.yup.Qty;
						
						exch.flush();
						
						q1.allthings(2,tr);
						totalprofit+=maxprofit;
						//cleanup
					}
			
			else if(maxprofit>=0 && tell.compareToIgnoreCase("chill")==0)
			{
				totalprofit+=maxprofit;
				
				exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
						tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
							tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty+ " "+ 
						tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
				
				exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
						store.yup.Qty+" "+store.yup.T0 +" "+ store.yup.Name+" "+ 
							store.yup.Texp+" "+ store.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
						store.yup.Stock +" " + store.yup.Price+" "+ store.yup.Partial );
				
				store.yup.Qty=0;
				
				exch.flush();
				//transaction
				q1.allthings(2,tr);
				//cleanup
			}
			
			else if(maxprofit==0)
			{
				exch.println("S "+ (System.currentTimeMillis() - test.time) + " " + 
						tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
							tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty+ " "+ 
						tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
				
				
				
				exch.flush();
				sell.allthings(1,tr);
				q1.allthings(2,tr);
				
				
				//print in transaction
				
			}
			tr=q1.allthings(3,tr);
			tell=" ";
		
			} 
		
		//if sell wala
			

					
			else if(tr.yup.Type.compareToIgnoreCase("buy")==0)
			{
				tell=" ";
				while(trslist!=null)
				{
				if(tr.yup.Stock.compareTo(trslist.yup.Stock)==0 && (System.currentTimeMillis()-Time.getTime())<(trslist.yup.T0+trslist.yup.Texp)*1000)
				{
					if(trslist.yup.Qty==tr.yup.Qty)
					{
						profit=trslist.yup.Qty *(tr.yup.Price-trslist.yup.Price );
						if(profit>maxprofit)
							{maxprofit=profit;
							store=trblist;
							tell="chill";
							}
						
					}
					
					else if(trslist.yup.Qty<tr.yup.Qty && tr.yup.Partial==true && trslist.yup.Qty>0)
					{
						profit=trslist.yup.Qty *(tr.yup.Price-trslist.yup.Price);
						if(profit>maxprofit)
						{
							maxprofit=profit;
							store=trslist;
							tell="subfrom_tr";
						}
					}
					
					else if(trslist.yup.Qty>tr.yup.Qty && trslist.yup.Partial==true)
					{
						profit=tr.yup.Qty *(tr.yup.Price-trslist.yup.Price );
						
						if(profit>maxprofit)
						{
							maxprofit=profit;
							store=trslist;
							tell="subfrom_trlist";
						}
					}
					
					
				}
				trslist=trslist.a;
				}
				
				trslist=sell.allthings(3,trslist);
			
				if(maxprofit>=0 && tell.compareTo("subfrom_tr")==0)
				{
					
					buy.allthings(1,tr);
					
					exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
							store.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
								tr.yup.Texp+" "+ tr.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
							tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
					
					exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
							store.yup.Qty+" "+store.yup.T0 +" "+ store.yup.Name+" "+ 
								store.yup.Texp+" "+ store.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
							store.yup.Stock +" " + store.yup.Price+" "+ store.yup.Partial );
					
					tr.yup.Qty=tr.yup.Qty-store.yup.Qty;
					exch.println("B "+ (System.currentTimeMillis() - test.time) + " " + 
							tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
								tr.yup.Texp+" "+ tr.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
							tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
					

					
					store.yup.Qty=0;
					exch.flush();
					q1.allthings(2,tr);
					totalprofit+=maxprofit;
					//cleanup store
					//transactyion
				}
				
				else if(maxprofit>=0 && tell.compareToIgnoreCase("subfrom_trlist")==0)
						{
							store.yup.Qty=store.yup.Qty-tr.yup.Qty;
							//transaction
							
							exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
									tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
										tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty +  " " + 
									tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
							
							exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
									store.yup.Qty+" "+store.yup.T0 +" "+ store.yup.Name+" "+ 
										store.yup.Texp+" "+ store.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
									store.yup.Stock +" " + store.yup.Price+" "+ store.yup.Partial );
							
							
							exch.flush();
							q1.allthings(2,tr);
							totalprofit+=maxprofit;
							//cleanup
						}
				
				else if(maxprofit>=0 && tell.compareToIgnoreCase("chill")==0)
				{
					totalprofit+=maxprofit;
					
					exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
							tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
								tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty +  " " + 
							tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
					
					exch.println("T "+ (System.currentTimeMillis() - test.time) + " " + 
							store.yup.Qty+" "+store.yup.T0 +" "+ store.yup.Name+" "+ 
								store.yup.Texp+" "+ store.yup.Type +" "+ (tr.yup.Qty + store.yup.Qty)+ " "+ 
							store.yup.Stock +" " + store.yup.Price+" "+ store.yup.Partial );
					
					
					store.yup.Qty=0;
					exch.flush();
					//transaction
					q1.allthings(2,tr);
					//cleanup
				}
				
				else if(maxprofit==0)
				{
					buy.allthings(1,tr);
					exch.println("B "+ (System.currentTimeMillis() - test.time) + " " + 
							tr.yup.Qty+" "+tr.yup.T0 +" "+ tr.yup.Name+" "+ 
								tr.yup.Texp+" "+ tr.yup.Type +" "+ tr.yup.Qty +  " " + 
							tr.yup.Stock +" " + tr.yup.Price+" "+ tr.yup.Partial );
					
					exch.flush();
					q1.allthings(2,tr);
					//print in transaction
					
				}
			
				tr=q1.allthings(3,faltu);
				tell= " ";
			}
			
			    }
			
			}
			
			
		}
		System.out.println("total profit = " + totalprofit);
		}
		
	
	public void cleanup()
	{
		node prev= new node();
		node prevs=new node();
		node trb=new node();
		node trs=new node();
		int b=1,s=1;
		
		
		prev=buy.allthings(3, faltu);
		prevs=sell.allthings(3, faltu);
		
		while(prev==null || prevs==null)
			try {
				Thread.sleep(10);
				prev=buy.allthings(3, faltu);
				prevs=sell.allthings(3, faltu);
				trb=buy.allthings(3, faltu);
				trs=sell.allthings(3, faltu);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//System.currentTimeMillis()-Time.getTime()<test.lasttime*1000
		while(s==1 || b==1)
		{
						while(prev!=null){
				
			if((prev.yup.Qty==0 || (prev.yup.T0+prev.yup.Texp)*1000<System.currentTimeMillis()-Time.getTime() )&& prev.yup.cleaned==false)
			{
				
				cleanup.println(System.currentTimeMillis()-Time.getTime() + " " + prev.yup.T0 +" "+ prev.yup.Name + " " + prev.yup.Texp + " " + prev.yup.Type 
						+ " " + prev.yup.Qty + " " + prev.yup.Stock + " " + prev.yup.Price + " " + prev.yup.Partial);
			cleanup.flush();
				prev.yup.cleaned=true;
				System.out.println(prev.yup.Name);
				
			}
			
			prev=prev.a;
			}
			prev=buy.allthings(3, faltu);
			
			while(prevs!=null)
			{
				if((prevs.yup.Qty==0 || (prevs.yup.T0+prevs.yup.Texp)*1000<System.currentTimeMillis()-Time.getTime() ) && prevs.yup.cleaned==false)
				{
					cleanup.println(System.currentTimeMillis()-Time.getTime() + " " + prevs.yup.T0 +" "+ prevs.yup.Name + " " + prevs.yup.Texp + " " + prevs.yup.Type 
							+ " " + prevs.yup.Qty + " " + prevs.yup.Stock + " " + prevs.yup.Price + " " + prevs.yup.Partial);
				
					prevs.yup.cleaned=true;
				cleanup.flush();
				System.out.println(prevs.yup.Name);
				}
				prevs=prevs.a;
				
			}
			
			prevs=sell.allthings(3, faltu);
			
			s=0;b=0;
			trb=buy.allthings(3, faltu);
			trs=sell.allthings(3, faltu);
			
			while(trb!=null)
			{
			if(trb.yup.cleaned==false)
				{b=1;
				break;
				}
			else trb=trb.a;
			}
			
			while(trs!=null)
			{

				if(trs.yup.cleaned==false)
				{
					s=1;
					break;
					
				}
				else trs=trs.a;
			}
			
			
			
			
			
			
		}
		
		
	}
	

	
		}

		
		
	
	
