package net.steiner.efac.item.custom;

public enum GeumbEnum {
    CLUMBY(0, 9),
    ALBY(10, 19),
    CITRY(20, 29),
    RUBIED(30, 39);

    private final int minToUse;
    private final int maxToUse;

    GeumbEnum(int minToUse, int maxToUse) {
        this.minToUse = minToUse;
        this.maxToUse = maxToUse;
    }

    public int getMinToUse() { return this.minToUse; }
    public int getMaxToUse() { return this.maxToUse; }
}
