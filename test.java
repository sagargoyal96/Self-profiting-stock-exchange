package hello;
import java.io.*;
import java.util.*;
class Time{
	synchronized static long getTime(){
		return test.time ;
	}
}
class order extends Thread 
	{
		int n=0;
		FileOutputStream os;
		PrintWriter ord;
		 
		node c=new node();
		
		 public order()
		{
			 try {
				os=new FileOutputStream("out.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 ord= new PrintWriter(os);
	
		
		
		}
		
		
		
		public void run()
		{
			node b=new node();
			c=stock.q2.allthings(3,b);
			//System.out.println(c.yup.Name);

			while(n==0)
			{if(System.currentTimeMillis()-Time.getTime()>25)
			n=1;
			
			} 
			//while(System.currentTimeMillis()-Time.getTime()<7000){
				
			while(c!=null)
			{
				
			//System.out.println(System.currentTimeMillis()-Time.getTime() + " " + c.yup.T0*1000 +" "+ ((c.yup).T0*1000+(c.yup).Texp*1000));
			if((System.currentTimeMillis()-Time.getTime()) >= c.yup.T0*1000 )
				{
				if((System.currentTimeMillis()-Time.getTime()) <((c.yup).T0*1000+(c.yup).Texp*1000))
					{//System.out.println(System.currentTimeMillis()-Time.getTime());
				//System.out.println(c.yup.Name);
				test.q1.allthings(1,c);
			    //System.out.println(Thread.currentThread().getName()+ " Success "+c.yup.Name);
				
					   ord.println(System.currentTimeMillis()-test.time + " " + c.yup.T0
							   +" " + c.yup.Name + " "+ c.yup.Texp+" "+ c.yup.Type+" "
							   + c.yup.Qty+" "+ c.yup.Stock+" "+c.yup.Price +" " + c.yup.Partial);
				 
					   ord.flush();
					   
						c=c.a;
					
					}
				else 
					{
						c=c.a;
					}
				}
			
			}
			test.lasttime=stock.q2.last.yup.T0+stock.q2.last.yup.Texp;
			
		}
		
	}

	class exchang extends Thread
	{
		Exchange ex = new Exchange();
		
		public void run()
		{
			node a=new node();
			while(test.q1.allthings(3,a)==null)
			{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(test.q1.allthings(3,a)!=null)
			ex.exentry(test.q1);
			
			
			
		}
	}

	class clean extends Thread
	{
		Exchange exe = new Exchange();
		
		public void run()
		{
			
			exe.cleanup();
		}
	}

	
	
		public class test {
	//Thread wrapper class
		static long time;
		static int lasttime;
		int flag=0;
		public static qu q1= new qu();

		void totest()
		{ 
		
			if(flag==0)
			{
				time=System.currentTimeMillis();
				flag=1;
			}
			lasttime=stock.q2.last.yup.T0+stock.q2.last.yup.Texp;
			order ord= new order();
			exchang excha=new exchang();
			clean cle = new clean();
			
			
			ord.start();
			excha.start();
			while(System.currentTimeMillis()-test.time<20){}
			
			cle.start();
			
		    
			}
			
			
			
			
		
		}
	
		

	

