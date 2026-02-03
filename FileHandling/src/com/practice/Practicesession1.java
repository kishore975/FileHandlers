package com.practice.AaaaaInterviewPractice.FileHandling;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;

public class Practicesession1 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
		
		//Create the Directory
		File dir= new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1");
		boolean isDirCreate= dir.mkdir();
		System.out.println(isDirCreate);
		
		//Create the File1
		File file1= new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\File1");
		boolean isFile1Created=file1.createNewFile();
		System.out.println(isFile1Created);
		
		//Create the File2
		//File file2= new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\File2");
		//boolean isFile2Created=file2.createNewFile();
		//System.out.println(isFile2Created);
		
		//Delete the File2
		//boolean isFile2Deleted= file2.delete();
		//System.out.println(isFile2Deleted);
		
		//Write the File- Char By Char
		FileWriter fw= new FileWriter("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\File1");
		fw.write("Hey, Hi."+"\n"+"I'm File1."+"\n"+"\t"+ "I Teach Java.");
		fw.flush();
		fw.close();
		
		//Write the File- Line By Line
		PrintWriter pw= new PrintWriter("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\File1");
		pw.write("Hey, Hi."+"\n"+"I'm File1."+"\n"+"\t"+ "I Teach JavaFullStack.");
		pw.flush();
		pw.close();
		
		//Read the File- Char By Char
		FileReader fr= new FileReader("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\File1");
		int x=fr.read();
		while(x!=-1) {
			System.out.print((char)x);
			x=fr.read();
		}
		
		//Read the File-Line By Line
		System.out.println();
		FileReader fr1= new FileReader("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\File1");
		BufferedReader br= new BufferedReader(fr1);
		String line=br.readLine();
		while(line!=null) {
			System.out.println(line);
			line=br.readLine();
		}
		
		//Serilaization- The process of converting the Java Object to Binary Data.
		Stude stud= new Stude(1011,"kishore",21000);
		FileOutputStream fop= new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\S.ser");
		ObjectOutputStream oop= new ObjectOutputStream(fop);
		oop.writeObject(stud);
		
		//Deserialization- Th process of converting the Binary Data to Java Object
		FileInputStream fip= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\S.ser");
		ObjectInputStream oip= new ObjectInputStream(fip);
		Object obj=oip.readObject();
		Stude s=(Stude) obj;
		System.out.println(s);
		
		
		//Converting Java Object to Json
		ObjectMapper om = new ObjectMapper();
		om.writeValue(new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\Stud.json"), stud);
		
		XmlMapper xmapper = new XmlMapper();
		xmapper.writeValue(new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\Studdd.xml"), stud);

		
		//Converting Json to Java Object
		ObjectMapper or = new ObjectMapper();
		Object obje=or.readValue(new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\Stud.json"), Stude.class);
		Stude st= (Stude) obje;
		System.out.println(st);
		
		XmlMapper  xmmapper= new XmlMapper();
		Object objec=xmmapper.readValue(new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\Studdd.xml"), Stude.class);
		Stude std= (Stude) objec;
		System.out.println("------------>"+std);
		
		//Converting Java Object to XML
		Empl emp= new Empl(1111, "arjun", 310000.0);
		JAXBContext jAXBContext= JAXBContext.newInstance(Empl.class);
		Marshaller marshaller= jAXBContext.createMarshaller();
		marshaller.marshal(emp, new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\Empl.xml"));
		
		//Converting XML to Java Object
		JAXBContext jAXBContext1= JAXBContext.newInstance(Empl.class);
		Unmarshaller unMarshaller= jAXBContext1.createUnmarshaller();
		Object objc=unMarshaller.unmarshal(new File("C:\\Users\\Admin\\eclipse-workspace\\AaaaaInterviewPractice\\Dir1\\Empl.xml"));
		Empl empl= (Empl) objc;
		System.out.println(empl);
		
		
	}

}

@XmlRootElement
class Stude implements Serializable{
	private int sId;
	private String sName;
	private double sFee;

	public Stude() {
		super();
	}

	public Stude(int sId, String sName, double sFee) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sFee = sFee;
	}
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public double getsFee() {
		return sFee;
	}
	public void setsFee(double sFee) {
		this.sFee = sFee;
	}
	@Override
	public String toString() {
		return "Stude [sId=" + sId + ", sName=" + sName + ", sFee=" + sFee + "]";
	}
}

@XmlRootElement
class Empl{
	private int eId;
	private String eName;
	private double eSal;
	
	public Empl() {
		super();
	}
	public  Empl(int eId, String eName, double eSal) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSal = eSal;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public double geteSal() {
		return eSal;
	}
	public void seteSal(double eSal) {
		this.eSal = eSal;
	}
	@Override
	public String toString() {
		return "Empl [eId=" + eId + ", eName=" + eName + ", eSal=" + eSal + "]";
	}	
	
}
	
	
