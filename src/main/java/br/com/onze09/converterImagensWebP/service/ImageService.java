package br.com.onze09.converterImagensWebP.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface ImageService {

    Boolean convertImage(MultipartFile multipartFile, String outputName, Integer width, Integer height, Double resize)
            throws IOException;

    Boolean rotateAndConvertImage(MultipartFile multipartFile, String outputName, Integer width, Integer height,
                                  Double resize)
            throws IOException;
}
