package ru.job4j.thread;

import java.util.HashMap;
import java.util.Map;

public final class MutableClass {
    private String field;
    private Map<String, String> fieldMap;
    public MutableClass(String field, Map<String, String> fieldMap) {
        this.field = field;
        this.fieldMap = fieldMap;
    }
    public String getField() {
        return field;
    }
    public Map<String, String> getFieldMap() {
        return fieldMap;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        MutableClass mutable = new MutableClass("this is not immutable", map);
        mutable.getFieldMap().put("unwanted key", "another value");
        mutable.getFieldMap().keySet().forEach(System.out::println);
    }
}
