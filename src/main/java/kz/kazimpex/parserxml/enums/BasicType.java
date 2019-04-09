package kz.kazimpex.parserxml.enums;

public enum BasicType {
    Structure("structure"), Timestamp("timestamp"), String("string"), Number("integer"), Int("enumeration");

    private String type;

    BasicType(String type) {
        this.type = type;
    }
}
