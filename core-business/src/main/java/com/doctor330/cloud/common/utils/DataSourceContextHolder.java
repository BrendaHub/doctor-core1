package com.doctor330.cloud.common.utils;

public class DataSourceContextHolder {  
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
    public static void setDbType(String dbType) {  
        contextHolder.set(dbType);  
    }  
    public static String getDbType() {  
        return contextHolder.get();
    }  
    public static void clearDbType() {  
        contextHolder.remove();  
    }  
}  