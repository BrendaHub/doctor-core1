package com.doctor330.cloud.util.json;

public class ExceptionErrorListener extends BufferErrorListener {
    
    public void error(String type, int col) {
        super.error(type, col);
        throw new IllegalArgumentException(buffer.toString());
    }
}
