package com.neusoft.planewar.util;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			for(int i=0;i<28;i++)
				System.out.print("  ");
			System.out.println("¾Å¾Å³Ë·¨±í");
			System.out.print("   ");
			for(int i=1;i<10;i++)
				System.out.format("%2s"," "+i+"\t");
			System.out.println("");
			for(int i=0;i<35;i++)
				System.out.print("--");
			System.out.println();
			for(int i=1;i<10;i++){
				System.out.print(i+"| ");
				for(int j=1;j<10;j++){
					System.out.format("%2s\t",i*j);
				}
				System.out.println("");
			}
	}

}