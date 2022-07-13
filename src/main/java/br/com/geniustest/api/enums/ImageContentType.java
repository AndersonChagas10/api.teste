package br.com.geniustest.api.enums;

public enum ImageContentType {
    JPEG("image/jpeg");

    public final String contentType;

    ImageContentType(String contentType) {
        this.contentType = contentType;
    }
}
