package util;

import java.io.*;

public class AppendFile {
	
	public void append(String filename,String text){
		
		try{
			File myFile=new File(filename);
			
			if(!myFile.exists()){
				
				FileWriter fileWriter1=new FileWriter(myFile);
				BufferedWriter writer1=new BufferedWriter(fileWriter1);
				writer1.write(text);
				writer1.close();
				return;
				
			}
			File myFile1=new File(filename+1);
			
			
			FileReader fileReader=new FileReader(myFile);
			FileWriter fileWriter1=new FileWriter(myFile1);
			
			BufferedReader reader=new BufferedReader(fileReader);
			BufferedWriter writer1=new BufferedWriter(fileWriter1);
			
			
			String line=null;
			int i=0;
			while((line=reader.readLine())!=null){
				//System.out.println(line);
				if(i!=0){
				
					writer1.write("\n"+line);
					i++;
				}
				else{
					writer1.write(line);
					i++;
				}
			}
			writer1.write("\n"+text);
			reader.close();
			writer1.close();
			
			myFile.delete();
			myFile1.renameTo(myFile);
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

