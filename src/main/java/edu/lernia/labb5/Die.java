package edu.lernia.labb5;

public class Die {
    int value = 0;

    protected Die() {
        value = (int) Math.random();
    }

    protected int DieRoll() {
        value = (int)(Math.random()*6+1);
        return value;
    }

    protected int DieReroll() {
        return DieRoll();
    }

    protected String getString() {
        return "Dice shows " + value;
    }
}
