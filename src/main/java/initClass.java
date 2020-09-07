import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class initClass {
    initClass(String name, String city, String age, ArrayList<String> words,String keyname, String keycity, String keyage, String keywords){
        this.name = name;
        this.city = city;
        this.age = age;
        this.words = words;

        this.keyname = keyname;
        this.keycity = keycity;
        this.keyage = keyage;
        this.keywords = keywords;

    }

    private String name, city, age;
    private String keyname, keycity, keyage, keywords;
    private ArrayList<String> words;

    public Map<String, Object> toArrayMap(){
        Map<String, Object> arrayList = new HashMap<String, Object>(4);
        arrayList.put("version", "Beta-1.0.0V");
        arrayList.put(keyname, name);
        arrayList.put(keycity, city);
        arrayList.put(keyage, age);
        arrayList.put(keywords, words);
        return arrayList;
    }
}
