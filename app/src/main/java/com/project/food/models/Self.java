package com.project.food.models;

import java.util.Objects;

public class Self {
    private String title;
    private String href;

    public Self() { }
    public Self(String title, String href) {
        this.title = title;
        this.href = href;
    }
    public Self(Self next) {
        this.title = next.title;
        this.href = next.href;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Self)) {
            return false;
        } else {
            Self next = (Self) o;
            return (Objects.equals(this.title, next.title) && Objects.equals(this.href, next.href));
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"title\":\"" + title + "\"," +
                "\"href\":\"" + href + "\"" +
                "}";
    }

    public String getTitle() { return this.title; }

    public String getHref() { return this.href; }

    public void setTitle(String title) { this.title = title; }

    public void setHref(String href) { this.href = href; }
}
