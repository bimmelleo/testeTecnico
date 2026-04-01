package org.example;

public class bombaComb {
    private String name;
    private String combAbast;

    public bombaComb (String name, String combAbast) {
        this.name = name;
        this.combAbast = combAbast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCombAbast() {
        return combAbast;
    }

    public void setCombAbast(String combAbast) {
        this.combAbast = combAbast;
    }

    @Override
    public String toString() {
        return "Bomba: " + name + " | Abastece: " + combAbast;
    }
}
