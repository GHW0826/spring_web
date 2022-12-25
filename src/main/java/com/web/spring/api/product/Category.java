package com.web.spring.api.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum Category {
    ROOT("Category", null),
        SHIRT("SHIRT", ROOT),
        PANTS("PANTS", ROOT),
        SHOES("SHOES", ROOT);

    private final String title;
    private final Category parent;
    private final List<Category> child;
    Category(String title, Category parent) {
        this.title = title;
        this.parent = parent;
        this.child = new ArrayList<>();
        if (Objects.nonNull(parent) == true)
            parent.child.add(this);
    }
}
