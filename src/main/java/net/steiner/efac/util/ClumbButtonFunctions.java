package net.steiner.efac.util;

public enum ClumbButtonFunctions {
    FAIL(0),
    DASH(1),
    LIGHTNING(2);

    private final int function;

    ClumbButtonFunctions(int function) {
        this.function = function;
    }

    public int getFunction() { return this.function; }
}
