package Util;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

//Scanner input=IOFileManager.IO(deskt);
//public static final String desktop="C:\\Users\\Trorik\\Desktop\\";
public class IOFileManager {
	
	public static Scanner IO(String input, String output){
		try{
			System.setOut(new PrintStream(new File(output)));
			return new Scanner(new File(input));
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
	public static Scanner IO(String input){
		try{
			System.setOut(new PrintStream(new File(input.split(".in")[0]+".out")));
			return new Scanner(new File(input+".in"));
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
}
