package br.com.onze09.converterImagensWebP.resource;

import br.com.onze09.converterImagensWebP.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
public class ImageResourceImp implements ImageResource{

    @Autowired
    private ImageService imageService;

    @Override
    public ResponseEntity<Void> convertImage(MultipartFile file,
                                             String outputName,
                                             Integer widht,
                                             Integer height,
                                             Double resize) throws IOException {

        imageService.convertImage(file, outputName, widht, height, resize);

        return null;
    }

    @Override
    public ResponseEntity<Void> rotateAndConvertImage(MultipartFile file,
                                                      String outputName,
                                                      Integer widht,
                                                      Integer height,
                                                      Double resize) throws IOException {
        imageService.rotateAndConvertImage(file, outputName, widht, height, resize);
        return null;
    }



    @Override
    public ResponseEntity<Void> convertListImage(List<MultipartFile> listFile,
                                                 Integer widht,
                                                 Integer height,
                                                 Double resize) throws IOException {

        for(MultipartFile file : listFile) {
            String name = file.getOriginalFilename();
            name = name.substring(0, (name.length() - 4));
            imageService.convertImage(file, name, widht, height, resize);
        }
        return null;
    }

    @Override
    public ResponseEntity<Void> rotateAndConvertListImage(List<MultipartFile> listFile,
                                                          Integer widht,
                                                          Integer height,
                                                          Double resize) throws IOException {
        for(MultipartFile file : listFile) {
            imageService.rotateAndConvertImage(file, file.getOriginalFilename(), widht, height, resize);
        }
        return null;
    }


}
