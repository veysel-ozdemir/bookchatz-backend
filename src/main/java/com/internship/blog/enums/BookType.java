package com.internship.blog.enums;

public enum BookType {
    HISTORY,
    ADVENTURE,
    PERSONAL,
    SCIENCE,
    THRILLER,
    HORROR,
    CLASSIC,
    HUMOR,
    ROMANCE,
    RELIGION;

    public static BookType fromString(String value) {
        return BookType.valueOf(value.toUpperCase());
    }
}
