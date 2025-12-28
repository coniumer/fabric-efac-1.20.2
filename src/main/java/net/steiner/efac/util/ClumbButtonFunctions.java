package net.steiner.efac.util;

public enum ClumbButtonFunctions {
    FAIL(0),
    DASH(1),
    LIGHTNING(2),
    BLINK(3),
    FIREBALL(4),
    BOMB(5),
    HEALTH(6),
    STORAGE(7);

    private final int function;

    ClumbButtonFunctions(int function) {
        this.function = function;
    }

    public int getFunction() { return this.function; }
}
