package util;

import java.io.*;
import java.util.*;

public class ResponseHandler{

    private String[] command=new String[30];
    int cnt=0;
    private String attackName;
    
        
    public String getCommand(int i) {
        
        return command[i];
    }
    
    public String getattackName() {
        
        return attackName;
    }
    



	public boolean isFound(String newValue) {
      
    	try {
            
    		   		
    		File file2=new File("/home/pramod/Desktop/settings.txt");
    		
    		if(!file2.exists()){
    			
    			return false;
    			//System.out.println(newValue);
    			
    		}
    		else{
    			
	    		
	    		
	    		FileReader fw= new FileReader(file2);
	    		
	    		BufferedReader reader=new BufferedReader(fw);
	    		
	    		
	    		String line=null;
	    		
	    	
	    		String token1;
	    		String token2;
	    		
	    		
	    		StringTokenizer parser;
	    		StringTokenizer parser1;
	    		
	    		while((line=reader.readLine())!=null){
	    			
	    			
	    			parser=new StringTokenizer(line,"->");
	    			
	    			token1=parser.nextToken();
	    			
	    			token2=parser.nextToken();
	    			
	    			
	    			
	    			if(token1.trim().equalsIgnoreCase(newValue)){
		    				
	    				System.out.println(token1+token2);
	    				StringTokenizer parser2;
	    				parser2=new StringTokenizer(token2,"##");
	    				while(parser2.hasMoreTokens()){
	    					command[cnt]=parser2.nextToken();
	    					System.out.println(command[cnt]);
	    					cnt++;
	    				}
	    				
	    				attackName=token1;
	    				return true;
		    				
		    		}
	    			else{
	    				return false;
	    				
	    			}
					
					
	    		}
	    				
	    		reader.close();
	    		
	    		
    		}
	    		
	    		
	        }catch (IOException e){
	            System.out.println("Null exception");
	        }
        
        
	        return false;
    	}
	
    }


