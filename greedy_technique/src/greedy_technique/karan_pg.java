package greedy_technique;

import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class karan_pg {
	public static class time{
		int hour;
		int minute;
	}
	public static class friend{
		time low=new time();
		time high=new time();
	}
	public static boolean bigger(time a,time b) {
		if(a.hour>b.hour) {
			return true;
		}
		else if(a.hour==b.hour) {
			if(a.minute>b.minute) {return true;}
			else {return false;}
		}
		else {
			return false;
		}
	}
	public static boolean smaller(time a,time b) {
		return !bigger(a, b);
	}
	// to add R minutes
	public static time add(time a,int R) {
		int hours=(R+a.minute)/60;
		int minutes=(R+a.minute)%60;
		a.hour+=hours;
		a.minute=minutes;
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int k=0;k<T;k++) {
        int N=scanner.nextInt();
        // intime of the pg
        String s_intime=scanner.next();
        time intime=new time()	;
        intime.hour=Integer.parseInt(s_intime.substring(0,2));
        intime.minute=Integer.parseInt(s_intime.substring(3));
        // waking up time
        time wake_up=new time();
        String s_wake_up=scanner.next();
         wake_up.hour=Integer.parseInt(s_wake_up.substring(0,2));
         wake_up.minute=Integer.parseInt(s_wake_up.substring(3));
         // store opening time
         time store_time=new time();
         String s_storetime=scanner.next();
         store_time.hour=Integer.parseInt(s_storetime.substring(0,2));;
         store_time.minute=Integer.parseInt(s_wake_up.substring(3));
         // travel time to the store
         int R=scanner.nextInt();
         // time taken to select a new slipper
         int S=scanner.nextInt();
         friend[] input=new friend[N];
         for(int i=0;i<input.length;i++) {
        	 input[i]=new friend();
        	 String input_1=scanner.next();
        	 input[i].low.hour=Integer.parseInt(input_1.substring(0,2));
        	 input[i].low.minute=Integer.parseInt(input_1.substring(3));
        	 String input_2=scanner.next();
        	 input[i].high.hour=Integer.parseInt(input_2.substring(0,2));
        	 input[i].high.minute=Integer.parseInt(input_2.substring(3));
        	 
         }
   for(int i=0;i<input.length;i++) {
	   //case 1 if wake up time is less than busy time
	   if(!bigger(wake_up, input[i].low)){
		   if(smaller(add(wake_up,R+S),intime) && smaller(add(wake_up,R), input[i].low) && bigger((add(wake_up, R/2)),store_time)){
            System.out.println(i+1);
            break;
		   }
	   }
	   // case 2 when wake up time is more than busy time  
	   else if(bigger(wake_up, input[i].high)) {
		   if(smaller(add(wake_up,R+S),intime) && bigger(add(wake_up, R/2), store_time)) {
			   System.out.println(i+1);
			   break;
		   }
	   }
	   else {
		   if(smaller(add(input[i].high,R+S), intime) && bigger(add(input[i].low, R/2),store_time)) {
			   System.out.println(i+1);
			   break;
		   }
	   }
	   if(i==input.length-1) {
		   System.out.println(-1);
	   }
	   
   }}         
        
        
	}

}
