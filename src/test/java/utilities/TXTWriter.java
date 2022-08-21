package utilities;

import pojos.Registrant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TXTWriter {
    public static void saveUIRegistrantData(Registrant registrant){
        try{
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("applicant_data"),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(registrant +"\n");
            bw.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static String ReadFile(String filepath) throws Exception
    {
        BufferedReader br
                = new BufferedReader(new FileReader(filepath));
        String st;
        String returnFileContent="";
        while ((st = br.readLine()) != null){
            returnFileContent = returnFileContent +st +"\n";
//            System.out.println(st);
        }
        return returnFileContent;
    }

    public static void SavePojoToFile(String filePath, Object pojoObj){
        try{
            FileWriter fw2 = new FileWriter(filePath,false);
            BufferedWriter bw = new BufferedWriter(fw2);
            bw.append(pojoObj +"\n");
            bw.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
