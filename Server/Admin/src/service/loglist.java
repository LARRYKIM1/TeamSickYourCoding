package service;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Logger;

public class loglist {
    public List<String> list(){
        String logPath = "/usr/local/tomcat9/logs/";

        List<String> fileList = new ArrayList<String>();
        String line = null;
        BufferedReader br = null;
        Process ps = null;
        try {
            Runtime rt = Runtime.getRuntime();
            ps = rt.exec(new String[]{"/bin/sh", "-c", "find "+ logPath + " -maxdepth 1 -type f -exec basename {} \\; | sort"});
            br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            while( (line = br.readLine()) != null ) {
                fileList.add(line);
            }
        } catch (IOException e) {
            Logger.getLogger("오류 발생");
        } finally {
            try {
                if(!(br==null)) br.close();
            } catch(NullPointerException e) {
                Logger.getLogger("오류 발생");
            } catch (IOException ex){
                Logger.getLogger("오류 발생");
            }
        }
        return fileList;
    }
}
