import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSON_database {

    public static void main(String[] args){
        System.out.println("No no no, this file library for widgets :(");
    }

    public static void wirteDataAndCreateJSON (final ArrayList<String> array){
        final ArrayList<String> list = new ArrayList<String>(2);
        list.addAll(array);
        JSONObject object = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        // Key, Value
        jsonObject.put("Name", list.get(0));
        jsonObject.put("City", list.get(1));
        jsonObject.put("Age", list.get(2));

        object.put("List", jsonObject);
        JSONArray jsonArray = new JSONArray();

        try {

            File file = new File("JSON_DataBase.json");
            if (file.createNewFile()){
                System.out.println("Created File: " + file.getName());

                jsonArray.add(object);


            }else {
                System.out.println("File already exists: " + file.getName());
                FileReader fileReader = new FileReader(file);
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(fileReader);
                jsonArray = (JSONArray) obj;
                jsonArray.add(object);
                jsonArray.forEach(emp -> orderArray((JSONObject) emp));

            }

            System.out.println("File URL: " + file.getPath());
            System.out.println("Path: " + System.getProperty("user.dir"));
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void readDataJSON (){
        try {
            File file = new File("JSON_DataBase.json");
            if (file.exists()){
                FileReader fileReader = new FileReader(file);
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(fileReader);


            }
        } catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void orderArray(JSONObject obj){
        JSONObject index = (JSONObject) obj.get("List");

        ArrayList<String> n = new ArrayList<String>();
        n.add("Hi");
        n.add("23554");

        initClass initClassn = new initClass(
                (String) index.get("Name"),(String) index.get("City"), (String) index.get("Age"), n,"name", "city", "age", "words"
        );

        Map<String, Object> b = initClassn.toArrayMap();
        System.out.println(b);

    }


}
