package hello;
import java.io.*;
import java.util.*;


	class add
	{

		public String Name,Stock,Type;
		public int T0,Texp,Qty,Price;
		public boolean Partial,cleaned=false;
		public int j,k;
		
	}
	
	class node
	{
		node a=null;
		add yup;
	}

	
	
	class qu 
	{
		
		 node first=null;
		 node last=null;
		
		 synchronized public node allthings(int a, node ins){
			 node ret=new node();
		node b=new node();
			 if(a==1)
				 b=enqueue(ins);
			 else if(a==2)
				 b=dequeue();
			 else if(a==3)
				 ret=retfirst();
			 
			 return ret;
				 
		 }
		 
		synchronized public node  enqueue(node ins)
		{
			node np=new node();
			node b=new node();
			if(first==null){
				np=ins;
				first=np;
				last=np;

			}		
			else
			{
			last.a=ins;
			last=ins;
			}
		return b;
		}
		
		synchronized public node dequeue()
		{
			node a=new node();
			if(first.a==null)
			{first=null;
			last=null;
			}
			else first=(first.a);
			
			return a;
		}
		
		synchronized public node retfirst()
		{
			return first;
		}
		
		
		
	}

	
	public class stock{
		int i=0 ;
		
		
		node makenode(add obj)
		{
			node cr=new node();
			cr.yup=obj;
			cr.a=null;
			
			return cr;
		}
		
		//Perform I/O operation
		
		public static qu q2 = new qu();
		test torun= new test();
		int flag=0;
		void performAction(String actionString){
	

		//doing inputs
		add obj= new add(); 
		Scanner s= new Scanner(actionString);	
		
		try{
		obj.T0=s.nextInt();
		obj.Name=s.next();
		if(obj.Name.compareTo("?")==0)
			throw new InputMismatchException();
		
		obj.Texp=s.nextInt();
		if(obj.Texp<0)
			throw new InputMismatchException() ;
		
		obj.Type=s.next();
		obj.Qty=s.nextInt();
		
		if(obj.Qty<0)
			throw new InputMismatchException() ;
		
		obj.Stock=s.next();
		if(obj.Stock.compareTo("?")==0)
			throw new InputMismatchException();
		obj.Price=s.nextInt();
		if(obj.Price<0)
			throw new InputMismatchException() ;
		String par=s.next();
		if(par.compareToIgnoreCase("T")==0)
			obj.Partial=true;
		else obj.Partial=false;
		}
		
		catch(Exception e){
			return ;
		
		}
		
		node ins=new node();
		ins=makenode(obj);
		
		
		q2.enqueue(ins);
		System.out.println(Thread.currentThread().getName()+" Succesfully Enqued "+ins.yup.Name);
		if(flag==0)
		{
			torun.totest();
			flag=1;
		}
		
		
		
		
	}
		
	
				
}
	


