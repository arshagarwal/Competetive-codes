package competetive_prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import javax.print.DocFlavor.INPUT_STREAM;

public class check {
	public static int getPower(int N,int t) {
		int x=1;
		int ans=0;
		while(Math.pow(t, x)<=N) {
			int p=(int)Math.pow(t, x);
			ans+=N/p;
			x++;
		}
		return ans;
	}
	public static void main(String[] args) {
		double a = (double)1/3;
		System.out.print(Math.cbrt(997));
	}}
	
