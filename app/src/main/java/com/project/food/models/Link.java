package com.project.food.models;

import java.util.Objects;

public class Link {
    private Next next;
    private Self self;

    public Link() { }
    public Link(Next next) {
        this.next = next;
    }
    public Link(Next next, Self self) {
        this.next = next;
        this.self = self;
    }
    public Link(Link link) {
        this.next = link.next;
        this.self = link.self;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Link)) {
            return false;
        } else {
            Link link = (Link) o;
            return Objects.equals(this.next, link.next);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"next\":" + next +
                "}";
    }

    public Next getNext() { return this.next; }
    public Self getSelf() { return this.self; }
    public void setNext(Next next) { this.next = next; }
    public void setSelf(Self self) { this.self = self; }
}
