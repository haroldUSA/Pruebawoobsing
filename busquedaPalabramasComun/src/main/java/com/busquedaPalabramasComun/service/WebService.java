package com.busquedaPalabramasComun.service;
import com.busquedaPalabramasComun.model.Web;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import org.springframework.stereotype.Service; 

//@Service
public class WebService {

    public WebService() {
    }
    

    public String getWeb2(String url){
        String s = null;

        try {
            
        // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("python c:\\Users\\harld\\Downloads\\searchWord.py "+url);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
        return s;
    }
    public String getWeb(Web url){ 
        String s = null;
        String[] parts=null;
        try {
            
        // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("python c:\\Users\\harld\\Downloads\\searchWord.py "+url.getUrl());
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                return s;
            }
            
            // read any errors from the attempted command
           /* System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }*/
            
            // parts = s.split(",");
            
            //System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
        return s;
    }
}
