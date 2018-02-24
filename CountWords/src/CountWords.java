import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by cowlog on 18-2-24.
 * Demo
 */
public class CountWords {

    public static void main(String args[]) throws Exception {
        String content = "Hello I am Chinese I come from China";
        Map map=new HashMap();
        StringTokenizer tokenizer=new StringTokenizer(content);
        while(tokenizer.hasMoreTokens())
        {
            String string=tokenizer.nextToken();
            if (map.containsKey(string)) {
                int k=(int)map.get(string);
                map.replace(string, k, ++k);
            }
            else {
                map.put(string, 1);
            }
        }
        Iterator iterator=map.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry entry=(Map.Entry)iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

}
