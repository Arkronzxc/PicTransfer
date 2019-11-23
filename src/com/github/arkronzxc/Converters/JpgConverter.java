package com.github.arkronzxc.Converters;

public class JpgConverter implements ConverterInt {

    private static final String EXTENSION = "jpg";

    private static JpgConverter jpgConverter = null;

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

    public static ConverterInt newInstance() {
        if (jpgConverter == null) {
            jpgConverter = new JpgConverter();
        }
        return jpgConverter;
    }
}
