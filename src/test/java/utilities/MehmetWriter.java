package utilities;

import pojos.Registrant;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MehmetWriter {

    public static void savingUiRegistrant(Registrant registrant) {

        FileWriter fileWriter;

        {
            try {
                fileWriter = new FileWriter(ConfigurationReader.getProperty("mehmet_registrant"), true);
                //this is for file creation

                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.append(registrant.toString() + "\n");
                bw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void savingUiRegistrant(Registrant [] registrant) {

        FileWriter fileWriter;

        {
            try {
                fileWriter = new FileWriter(ConfigurationReader.getProperty("mehmet_GetApi"), true);
                //this is for file creation

                BufferedWriter bw = new BufferedWriter(fileWriter);
                for (int i = 0; i <registrant.length ; i++) {
                    bw.append(registrant[i].toString()+"\n");

                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void savingApiRegistrant(Registrant us01_registrantPojo) {

        FileWriter fileWriter;

        {
            try {
                fileWriter = new FileWriter(ConfigurationReader.getProperty("mehmet_registrant"), true);
                //this is for file creation

                BufferedWriter bw = new BufferedWriter(fileWriter);
                    bw.append(us01_registrantPojo.toString()+"\n");
                bw.close();
                }
             catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void savingRoomId(int roomId) {

        FileWriter fileWriter;

        {
            try {
                fileWriter = new FileWriter(ConfigurationReader.getProperty("rooms"), true);
                //this is for file creation
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.append(roomId+"\n");
                bw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
