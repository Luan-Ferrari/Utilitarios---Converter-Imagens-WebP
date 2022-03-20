package br.com.onze09.converterImagensWebP.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageResource {

    // atençao, converter imagens para Inkscape, usar a seguinte proporção para calcular regra de três:
    // conversorWebp = 100 então no Inkscape a imagem terá 26,458 mm

    //redimensiona (widht e height) e corta (resize) uma única imagem
    @PostMapping
    ResponseEntity<Void> convertImage(@RequestParam(name = "file") MultipartFile file,
                                      @RequestParam(value = "name", defaultValue = "default") String outputName,
                                      @RequestParam(value = "widht", defaultValue = "100") Integer widht,
                                      @RequestParam(value = "height", defaultValue = "100") Integer height,
                                      @RequestParam(value = "resize", defaultValue = "0") Double resize
                                      ) throws IOException;

    //redimensiona (widht e height), corta (resize), e gira para a esquerda uma única imagem
    @PostMapping("/rotate")
    ResponseEntity<Void> rotateAndConvertImage(@RequestParam(name = "file") MultipartFile file,
                                               @RequestParam(value = "name", defaultValue = "default") String outputName,
                                               @RequestParam(value = "widht", defaultValue = "100") Integer widht,
                                               @RequestParam(value = "height", defaultValue = "100") Integer height,
                                               @RequestParam(value = "resize", defaultValue = "0") Double resize
    ) throws IOException;

    //redimensiona (widht e height) e corta (resize) uma lista de imagem, tamanho máximo 500 MB
    @PostMapping("/lista")
    ResponseEntity<Void> convertListImage(@RequestParam(name = "listFile") List<MultipartFile> listFile,
                                          @RequestParam(value = "widht", defaultValue = "100") Integer widht,
                                          @RequestParam(value = "height", defaultValue = "100") Integer height,
                                          @RequestParam(value = "resize", defaultValue = "0") Double resize
    ) throws IOException;

    //redimensiona (widht e height), corta (resize), e gira para a esquerda uma lista de imagem, tamanho máximo 500 MB
    @PostMapping("/lista/rotate")
    ResponseEntity<Void> rotateAndConvertListImage(@RequestParam(name = "listFile") List<MultipartFile> listFile,
                                                   @RequestParam(value = "widht", defaultValue = "100") Integer widht,
                                                   @RequestParam(value = "height", defaultValue = "100") Integer height,
                                                   @RequestParam(value = "resize", defaultValue = "0") Double resize
    ) throws IOException;
}
