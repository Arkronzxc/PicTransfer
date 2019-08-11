package com.github.arkronzxc.Converters;

public class PngConverter implements ConverterInt {

    private static final String EXTENSION = "png";

    private PngConverter() {

    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    private static PngConverter pngConverter = null;

    @Override
    public boolean checkFormat(String path) {
        if (path.substring(path.length() - 3).equals(EXTENSION)) {
            checkPath(path);
            return true;
        }
        throw new IllegalArgumentException("Incorrect extension");
    }

    public static ConverterInt newInstance() {
        if (pngConverter == null) {
            pngConverter = new PngConverter();
        }
        return pngConverter;
    }
}
