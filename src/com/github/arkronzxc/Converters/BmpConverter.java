package com.github.arkronzxc.Converters;

public class BmpConverter implements ConverterInt {

    private static final String EXTENSION = "bmp";

    private static BmpConverter bmpConverter = null;

    private BmpConverter() {

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
        if (bmpConverter == null) {
            bmpConverter = new BmpConverter();
        }
        return bmpConverter;
    }
}
