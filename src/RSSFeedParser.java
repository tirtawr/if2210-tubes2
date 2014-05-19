//package main;
/**

 * @author ASUS
 *
 */



import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;



public class RSSFeedParser {
  static final String TITLE = "title";
  static final String DESCRIPTION = "description";
  static final String CHANNEL = "channel";
  static final String LANGUAGE = "language";
  static final String COPYRIGHT = "copyright";
  static final String LINK = "link";
  static final String AUTHOR = "author";
  static final String ITEM = "item";
  static final String PUB_DATE = "pubDate";
  static final String GUID = "guid";
  
  static URL curUrl;
  
  //final URL url;
  final List<URL> url = new ArrayList<URL>();

  public RSSFeedParser(List<String> feedUrl) {
    try {
      
      for(String s : feedUrl){
    	  this.url.add(new URL(s));}
      //this.url = new URL(feedUrl);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public Feed readFeed() {
    Feed feed = null;
    try {
      boolean isFeedHeader = true;
      // Header di isi kosong dulu
      String description = "";
      String title = "";
      String link = "";
      String language = "";
      String copyright = "";
      String author = "";
      String pubdate = "";
      String guid = "";

      // Bikin XMLInputFactory baru
      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
      
      //InputStream test = new FileInputStream("SampleRSS.xml");
      
      for(URL s : url){
	      // Setup eventReader
          curUrl = s;
	      InputStream in = read();
	      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
	      
      	  // Baca XML nya
	      while (eventReader.hasNext()) {
	        XMLEvent event = eventReader.nextEvent();
	        if (event.isStartElement()) {
	          String localPart = event.asStartElement().getName()
	              .getLocalPart();
	          switch (localPart) {
	          case ITEM:
	            if (isFeedHeader) {
	              isFeedHeader = false;
	              feed = new Feed(title, link, description, language,
	                  copyright, pubdate);
	            }
	            event = eventReader.nextEvent();
	            break;
	          case TITLE:
	            title = getCharacterData(event, eventReader);
	            break;
	          case DESCRIPTION:
	            description = getCharacterData(event, eventReader);
	            break;
	          case LINK:
	            link = getCharacterData(event, eventReader);
	            break;
	          case GUID:
	            guid = getCharacterData(event, eventReader);
	            break;
	          case LANGUAGE:
	            language = getCharacterData(event, eventReader);
	            break;
	          case AUTHOR:
	            author = getCharacterData(event, eventReader);
	            break;
	          case PUB_DATE:
	            pubdate = getCharacterData(event, eventReader);
	            break;
	          case COPYRIGHT:
	            copyright = getCharacterData(event, eventReader);
	            break;
	          }
	        } else if (event.isEndElement()) {
	          if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
	            FeedMessage message = new FeedMessage();
	            message.setAuthor(author);
	            message.setDescription(description);
	            message.setGuid(guid);
	            message.setLink(link);
	            message.setTitle(title);
	            feed.getMessages().add(message);
	            event = eventReader.nextEvent();
	            continue;
	          }
	        }
	      }
      }
      
      
    } catch (XMLStreamException e) {
      throw new RuntimeException(e);
    }
    
    return feed;
  }

  private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
      throws XMLStreamException {
    String result = "";
    event = eventReader.nextEvent();
    if (event instanceof Characters) {
      result = event.asCharacters().getData();
    }
    return result;
  }

  private InputStream read() {
    try {
      return curUrl.openStream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
} 