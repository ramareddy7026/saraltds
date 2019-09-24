package TestNG1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	  public static  String  getdata(String p,String s,int r,int c) throws EncryptedDocumentException, FileNotFoundException, IOException
	  {
		
		 String v="";
			Workbook  wb= WorkbookFactory.create(new FileInputStream(p));		   
			  v=wb.getSheet(s).getRow(r).getCell(c).toString();		   
		 return v;	  
	  }
}
