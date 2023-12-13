package com.project.food.models;

public class ServingSize {
    String uri;
    String label;
    float quantity;

    public ServingSize() { }

    public ServingSize(String uri, String label, float quantity) {
        this.uri = uri;
        this.label = label;
        this.quantity = quantity;
    }
    public ServingSize(ServingSize servingSize) {
        this.uri = servingSize.uri;
        this.label = servingSize.label;
        this.quantity = servingSize.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof ServingSize)) {
            return false;
        } else {
            ServingSize that = (ServingSize) o;
            return quantity == that.quantity && uri.equals(that.uri) && label.equals(that.label);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"uri\":\"" + uri + "\"," +
                "\"label\":\"" + label + "\"," +
                "\"quantity\":" + quantity +
                "}";
    }

    public String getUri() { return uri; }
    public String getLabel() { return label; }
    public float getQuantity() { return quantity; }

    public void setUri(String uri) { this.uri = uri; }
    public void setLabel(String label) { this.label = label; }
    public void setQuantity(float quantity) { this.quantity = quantity; }
}
