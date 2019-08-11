package com.github.arkronzxc.Converters;

import java.io.IOException;

public class JpgConverter implements ConverterInt {

    private static final String EXTENSION = "jpg";

    // чтобы был один экземпляр
    private static JpgConverter jpgConverter = null;

    // чтобы никто не смог вызвать из другой части программы new JpgConverter
    private JpgConverter() {

    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    @Override
    public boolean checkFormat(String path) {
        if (path.substring(path.length() - 3).equals(EXTENSION)) {
            checkPath(path);
            return true;
        }
        throw new IllegalArgumentException("Incorrect extension");
    }


    // возвращ экземпляр jpgConverter'а. Если никто не инициализ,
    // то вернет новый экземляр, а если иниц, то возвращ этот
    // от ConverterInt чтобы был независим от реализации
    public static ConverterInt newInstanse() {
        if (jpgConverter == null) {
            jpgConverter = new JpgConverter();
        }
        return jpgConverter;
    }
    //дефолт методы уже есть, просто они скрыты.
}
