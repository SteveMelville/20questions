package smelville;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DatabaseManager {
    DatabaseManager(){
        fileName = "questions.txt";

        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    String fileName;
    File file;

    ArrayList<TreeItem> getList(){
        ArrayList<TreeItem> list = new ArrayList<>();

        try {

            Scanner fileHandler = new Scanner(file);
            String text;
            boolean isObject;

            while(fileHandler.hasNextLine()){
                text = fileHandler.nextLine();
                isObject = Boolean.parseBoolean(fileHandler.nextLine());
                list.add(new TreeItem(text, isObject));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    void saveList(ArrayList<TreeItem>list){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < list.size(); i++) {
                out.write(list.get(i).text_);
                out.newLine();
                out.write(Boolean.toString(list.get(i).isObject_));
                out.newLine();
            }

            out.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
