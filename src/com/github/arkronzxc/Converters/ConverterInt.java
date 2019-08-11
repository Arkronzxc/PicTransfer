package com.github.arkronzxc.Converters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public interface ConverterInt {

    String getExtension();

    default boolean checkPath(String path) {
        File inputFile = new File(path);
        if (inputFile.exists()) {
            return true;
        }
        throw new IllegalArgumentException("File doesn't exist");
    }

    boolean checkFormat(String path);

    default byte[] toByteArray(String path) throws IOException {
        File fnew = new File(path);
        BufferedImage originalImage = ImageIO.read(fnew);
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        //мы из буферизов изображ orig img, узнаем расширение с помощью getExt, и записываем в массив байтов
        ImageIO.write(originalImage, getExtension(), data);
        byte[] imageInByte = data.toByteArray();

        return (data.toByteArray());
    }

    default void fromByteArray(byte[] data) throws IOException {
        // получаем директорию с джарником
        // output - название файла
        String currentDirectory = "C:\\666";
        String defaultFileName = currentDirectory + "/output." + getExtension();
        fromByteArray(defaultFileName, data);
    }

    default void fromByteArray(String newOutputFileName, byte[] data) throws IOException {
        File outputFile = new File(newOutputFileName);
        outputFile.createNewFile();
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, getExtension(), outputFile);
    }
}
