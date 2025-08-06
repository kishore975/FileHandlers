package com.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

public class Practicesession1 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		/*Created the folder
		File file1= new File("C:\\Documents", "MyDocs");
		boolean file1Status=file1.mkdir();
		System.out.println(file1Status);
		*/
		
		/*Deleted the folder
		boolean dltStatus =file1.delete();
		System.out.println(dltStatus);
		*/
		
		/*Created the file
		File file2= new File("C:\\Documents\\MyDocs", "First.txt");
		boolean file2Status=file2.createNewFile();
		System.out.println(file2Status);
		*/
		
		/*Written the file - Char By Char
		FileWriter writing= new FileWriter("C:\\Documents\\MyDocs\\First.txt");
		writing.write("Hey, How are You?"+"\n"+"\f");
		writing.write("This is the first file.");
		writing.flush();
		writing.close();
		*/
		
		/*Written the file - Line BY Line
		PrintWriter pw= new PrintWriter("C:\\Documents\\MyDocs\\First.txt");
		pw.write("Good At Java");
		pw.flush();
		pw.close();
		*/
		
		/*Read the file - Char By Char
		FileReader reading= new FileReader("C:\\Documents\\MyDocs\\First.txt");
		int i=reading.read();
		while(i!=-1) {
		System.out.print((char)i);
		i=reading.read();
		}
		*/
		
		/*Read the file - Line By Line
		FileReader reading= new FileReader("C:\\Documents\\MyDocs\\First.txt");
		BufferedReader br= new BufferedReader(reading);
		String line=br.readLine();
		while(line !=null) {
		System.out.println(line);
		 line=br.readLine();
		}
		*/
		
		/*Print on console with Sysout
		PrintWriter pw= new PrintWriter(System.out);
		pw.write("Iam printing on Console");
		pw.flush();
		pw.close();
		*/
		
		/*Written Java Object to Binary data
		Student student=new Student();
		student.stdId=1;
		student.stdName="Arjun";
		System.out.println(student);
		FileOutputStream fops= new FileOutputStream("StudentFile.ser");
		ObjectOutputStream ops= new ObjectOutputStream(fops);
		ops.writeObject(student);	
		*/
		
		/*Read binary data to Object
		Student student= new Student();
		FileInputStream fips= new FileInputStream("StudentFile.ser");
		ObjectInputStream ips= new ObjectInputStream(fips);
		Object obj=ips.readObject();
		Student s=(Student) obj;
		System.out.println(s.stdId+" : "+s.stdName);
		*/
	}

}

class Student implements Serializable{
	int stdId;
	String stdName;
	
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + "]";
	}
	
}
