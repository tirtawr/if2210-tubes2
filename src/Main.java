//package main;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {
	  public static void main(String[] args) {
		try {
			
			List<String> ListUrl = new ArrayList<String>();
			ListUrl.add("http://rss.cnn.com/rss/edition_world.rss");
			ListUrl.add("http://rss.cnn.com/rss/edition_technology.rss");
			ListUrl.add("http://rss.cnn.com/rss/edition_sport.rss");
			ListUrl.add("http://rss.cnn.com/rss/edition_business.rss");
			ListUrl.add("http://rss.cnn.com/rss/edition_entertainment.rss");
		    RSSFeedParser parser = new RSSFeedParser(ListUrl);
		    
		    Feed feed = parser.readFeed();
		    
		    List<String> ListWorld = new ArrayList<String>();
		    List<String> ListTech = new ArrayList<String>();
		    List<String> ListSport = new ArrayList<String>();
		    List<String> ListBusiness = new ArrayList<String>();
		    List<String> ListEnt = new ArrayList<String>();
		    List<String> ListOther = new ArrayList<String>();
		    
		    for (FeedMessage message : feed.getMessages()) {
			      if(message.getTitle().toLowerCase().contains("world") && 
			    		  !message.getDescription().contains("<") &&
			    		  !message.getDescription().contains(">")){
			    	  ListWorld.add(message.getDescription());
			      }else if(message.getTitle().toLowerCase().contains("tech") && 
			    		  !message.getDescription().contains("<") &&
			    		  !message.getDescription().contains(">")){
			    	  ListTech.add(message.getDescription());
			      }else if(message.getTitle().toLowerCase().contains("sport") && 
			    		  !message.getDescription().contains("<") &&
			    		  !message.getDescription().contains(">")){
			    	  ListSport.add(message.getDescription());
			      }else if(message.getTitle().toLowerCase().contains("business") && 
			    		  !message.getDescription().contains("<") &&
			    		  !message.getDescription().contains(">")){
			    	  ListBusiness.add(message.getDescription());
			      }else if(message.getTitle().toLowerCase().contains("ent") && 
			    		  !message.getDescription().contains("<") &&
			    		  !message.getDescription().contains(">")){
			    	  ListEnt.add(message.getDescription());
			      }else{
			    	  ListOther.add(message.getDescription());
			      }		    
		    
	    
	    
		    }
		    
	    	PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			//writer.println(feed);
	    	writer.println("\n\nWorld\n\n");
	    	for(String s : ListWorld){
	    		writer.println(s);
	    	}
	    	writer.println("\n\nTechnology\n\n");
			for(String s : ListTech){
				writer.println(s);    		
			}
			writer.println("\n\nSport\n\n");
			for(String s : ListSport){
				writer.println(s);
			}
			writer.println("\n\nBusiness\n\n");
			for(String s : ListBusiness){
				writer.println(s);
			}
			writer.println("\n\nEntertainment\n\n");
			for(String s : ListEnt){
				writer.println(s);
	    	}
			writer.println("\n\nOther\n\n");
		    for(String s : ListOther){		    	
		    	writer.println(s);
		    }
		    
		    writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    

	  }
	} 