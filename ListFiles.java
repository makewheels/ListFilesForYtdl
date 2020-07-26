import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFiles {
    public static void main(String[] args) {
        String baseurl = "https://file.qbserver.cn/";
        String folderPath = args[0];
        if(folderPath.contains("/oss")){
                baseurl=baseurl+"oss/";
        }
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        List<String> filenameList = new ArrayList<>();
        if (files != null) {
                for (File file : files) {
                if (file.isFile()) {
                    filenameList.add(file.getName());
                }
            }
        Collections.sort(filenameList);
        for (File file : files) {
                try {
                    System.out.println(baseurl
                            + URLEncoder.encode(folder.getName(), "utf-8")
                            .replace("+", "%20")
                            + "/"
                            + URLEncoder.encode(file.getName(), "utf-8")
                            .replace("+", "%20")
);      
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }   
            }   
        }   
        }
}       
