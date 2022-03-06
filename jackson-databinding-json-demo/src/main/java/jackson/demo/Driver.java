package jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try {
            //Create object Mapper
           ObjectMapper mapper = new ObjectMapper();

            //Read JSON file and map/convert to json POJO

//            Student tmp = mapper.readValue(
//                    new File("./data/sample-lite.json"), Student.class);
            Student tmp = mapper.readValue(
                    new File("./data/sample-full.json"), Student.class);
            //Print name
            System.out.println(tmp);
            Address tmpAddress= tmp.getAddress();
            System.out.println(tmpAddress);
            for (String s: tmp.getLanguages()) {
                System.out.println(s);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
