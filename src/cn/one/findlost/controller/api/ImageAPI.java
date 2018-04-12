package cn.one.findlost.controller.api;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/api/image/")
public class ImageAPI {

    @RequestMapping("/download/{imageName}")
    public ResponseEntity<byte[]> download(@PathVariable String imageName) throws IOException {
        String path="/usr/image/" + imageName + ".png";
        String end = ".png";
        try {
            File file=new File(path);
            if(!file.exists()){
                file = new File("/usr/image/" + imageName + ".jpg");
                end = ".jpg";
                if(!file.exists()){
                    return null;
                }
            }
            HttpHeaders headers = new HttpHeaders();

            headers.setContentDispositionFormData("attachment", imageName + end);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
