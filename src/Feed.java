import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author ASUS
 *
 */

public class Feed {

	  private static final String Null = null;
	final String title;
	  final String link;
	  final String description;
	  final String language;
	  final String copyright;
	  final String pubDate;

	  final List<FeedMessage> entries = new ArrayList<FeedMessage>();

	 // public Feed() {
			// TODO Auto-generated constructor stub
		  //title = Null;
		  //link = Null;
		  //description = Null;
		  //language = Null;
		  //copyright = Null;
		  //pubDate = Null;
		//}
	  
	  public Feed(String title, String link, String description, String language,
	      String copyright, String pubDate) {
	    this.title = title;
	    this.link = link;
	    this.description = description;
	    this.language = language;
	    this.copyright = copyright;
	    this.pubDate = pubDate;
	  }


	public List<FeedMessage> getMessages() {
	    return entries;
	  }

	  public String getTitle() {
	    return title;
	  }

	  public String getLink() {
	    return link;
	  }

	  public String getDescription() {
	    return description;
	  }

	  public String getLanguage() {
	    return language;
	  }

	  public String getCopyright() {
	    return copyright;
	  }

	  public String getPubDate() {
	    return pubDate;
	  }

	  @Override
	  public String toString() {
	    return "Feed [copyright=" + copyright + ", description=" + description
	        + ", language=" + language + ", link=" + link + ", pubDate="
	        + pubDate + ", title=" + title + "]";
	  }
}
