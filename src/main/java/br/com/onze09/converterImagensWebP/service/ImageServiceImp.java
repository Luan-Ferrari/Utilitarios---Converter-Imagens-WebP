package br.com.onze09.converterImagensWebP.service;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.color.RGBColor;
import com.sksamuel.scrimage.webp.WebpWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImp implements ImageService{

    @Override
    public Boolean convertImage(MultipartFile multipartFile, String outputName, Integer width, Integer height,
                                Double resize) throws IOException {
        try {
            File file = new File(".temp/outputImage/" + outputName +".webp");
            ImmutableImage image = ImmutableImage.loader().fromStream(multipartFile.getInputStream());
            WebpWriter webpWriter = new WebpWriter(); //Serve para controlar a qualidade da imagem webp de saída
            image.fit(width, height, new RGBColor(240, 240, 240).awt()).resize(resize).
                    output(WebpWriter.DEFAULT, ".temp/outputImage/" + outputName +".webp");

            return true;

        } catch (IOException e) {
            throw new IOException("Erro ao ler, formatar ou converter para .webp " + e.getMessage());
        }
    }

    @Override
    public Boolean rotateAndConvertImage(MultipartFile multipartFile, String outputName, Integer width, Integer height,
                                         Double resize) throws IOException {
        try {
            File file = new File(".temp/outputImage/" + outputName +".webp");
            ImmutableImage image = ImmutableImage.loader().fromStream(multipartFile.getInputStream());
            WebpWriter webpWriter = new WebpWriter(); //Serve para controlar a qualidade da imagem webp de saída
            image.rotateRight().fit(width, height, new RGBColor(240, 240, 240).awt()).resize(resize).
                    output(WebpWriter.DEFAULT, ".temp/outputImage/" + outputName +".webp");

            return true;

        } catch (IOException e) {
            throw new IOException("Erro ao ler, formatar ou converter para .webp " + e.getMessage());
        }
    }
}
