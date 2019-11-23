package com.github.arkronzxc;

import com.github.arkronzxc.Converters.BmpConverter;
import com.github.arkronzxc.Converters.ConverterInt;
import com.github.arkronzxc.Converters.JpgConverter;
import com.github.arkronzxc.Converters.PngConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите абсолютный путь к файлу");
        String path = bf.readLine();

        System.out.println("Введите папку в которую хотите сохранить файл");
        String outputDir = bf.readLine();

        System.out.println("Название создаваемого файла");
        String outputFileName = bf.readLine();

        System.out.println("Исходное расширение");
        String fromFormat = bf.readLine();

        System.out.println("Нужное расширение");
        String toFormat = bf.readLine();

        if (fromFormat.equals(toFormat)) {
            throw new IllegalArgumentException("Форматы совпадают");
        }

        ConverterInt converterFrom = fabrikConverter(fromFormat);
        ConverterInt converterTo = fabrikConverter(toFormat);

        outputFileName = outputFileName + "." + converterTo.getExtension();
        outputDir = outputDir + "\\";

        if (converterFrom.checkPath(path) && converterFrom.checkFormat(path) && converterFrom.checkPath(outputDir)) {
            byte[] data = converterFrom.toByteArray(path);
            converterTo.fromByteArray(outputDir + outputFileName, data);
        }

    }

    private static ConverterInt fabrikConverter(String extension){
        ConverterInt resultConverter;
        switch (extension){
            case "jpg":
                resultConverter = JpgConverter.newInstance();
                break;
            case "bmp":
                resultConverter = BmpConverter.newInstance();
                break;
            case "png":
                resultConverter = PngConverter.newInstance();
                break;
            default:
                throw new IllegalArgumentException("Метод не реализован / расширение недоступно");
        }
        return resultConverter;
    }
}

