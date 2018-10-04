import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
import org.jsoup.nodes.Element;
import java.util.Set;

public class Solution {
    
    private static Set<String> linksSet = new HashSet<>();
    
    public static void main(String args[]){
       
        String url = "https://www.prudential.co.uk/";
        
        try{
        Document document = Jsoup.connect(url).get();
        Elements links = document.select("a[href]");
        System.out.println(links.size());
        
            
        Elements imgs = document.select("img[src]");
        System.out.println(imgs.size());
            
        for(Element link : links){
             System.out.println(link.text() + " :: " + link.absUrl("href"));
             linksSet.add(link.absUrl("href"));
                
        }
        System.out.println(linksSet.size());
            
        System.out.println("---------------------------------------------------------------------------------------------");
        for(Element img : imgs){
            System.out.println(img.attr("alt") + " :: " + img.attr("abs:src"));
        }
        }catch(IOException exp){
            System.out.println("Exception Occured: " +exp);
        }
    }    
}