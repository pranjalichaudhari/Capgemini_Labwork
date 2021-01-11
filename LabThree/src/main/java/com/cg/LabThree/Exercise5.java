/**
 * @author	: Pranjali Chaudhari
 * Desc		: : Write a Java program that displays the
 *  number of characters, lines and words in a text 
 */
package com.cg.LabThree;

import java.util.*;
import java.io.*;
public class Exercise5
{
	
	public static void calc(String filename)throws IOException {
		
		int nl=1,nw=0;           
        char ch;
       
        FileInputStream f=new FileInputStream(filename);
        int n=f.available();
        for(int i=0;i<n;i++)
        {
                    ch=(char)f.read();
                    if(ch=='\n')
                    nl++;
                    else if(ch==' ')
                                nw++;
                                                       
        }
        System.out.println("\nNumber of lines : "+nl);
        System.out.println("\nNumber of words : "+(nl+nw));
        System.out.println("\nNumber of characters : "+n);
	}
            public static void main(String args[]) throws IOException
            {
                        int nl=1,nw=0;           
                        char ch;
                        Scanner scr=new Scanner(System.in);
                        System.out.print("\nEnter File name: ");
                        String str=scr.nextLine();
                        calc(str);
                        
                       

            }
}