package utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }
    //1. method: This metod will convert Json data to Java Object (de-Serialization)
    public static  <T> T convertJsonToJavaObject(String json,Class<T>cls){ //Generic methods
        //make static to access by using class name - no memory for object
        //Class<T>cls - dynamic: any data type can be.. If write directly object, then its type is constant as object (not dynamic)
        //<T> T : convert data what is the type of T

        T javaResult = null;
        try {
            javaResult= mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaResult;
    }



    //2. method: This method will convert Java Object to Json data (Serialization)
    public static String convertJavaObjectToJson(Object obj){
        String jsonResult = null;
        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResult;

    }


}
