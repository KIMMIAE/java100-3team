package java100.app.web.util;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailMaker {
    
    public static String thumbnailMaker(
            int width, int height, String uploadDir, String filename, String suffix) {

        File image = new File(uploadDir + "//" + filename);
        File thumbnail = new File(uploadDir + "//" + filename +"_"+ suffix);
        if (image.exists()) { 
            thumbnail.getParentFile().mkdirs(); 
            try {
                Thumbnails.of(image).size(width, height).outputFormat("png").toFile(thumbnail);
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

        return filename + "_" + suffix;
    }
}
