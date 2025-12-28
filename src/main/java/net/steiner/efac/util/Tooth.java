package net.steiner.efac.util;

import net.minecraft.item.Item;

public class Tooth {
    private static final int[] WISDOM = {0, 15, 16, 31};
    private static final int[] MOLAR = {1, 2, 13, 14, 17, 18, 29, 30};
    private static final int[] PREMOLAR = {3, 4, 11, 12, 19, 20, 27, 28};
    private static final int[] CANINE = {5, 10, 21, 26};
    private static final int[] INCISOR = {6, 7, 8, 9, 22, 23, 24, 25};
    private final Item tooth;
    private final int location;
    private Type type;

    public enum Type {
        WISDOM(),
        MOLAR(),
        PREMOLAR(),
        CANINE(),
        INCISOR()
    }

    public Tooth(Item tooth, int location) {
        this.tooth = tooth;
        this.location = location;
        for (int i : WISDOM) {
            if (location == i) {
                this.type = Type.WISDOM;
                break;
            }
        }
        for (int i : CANINE) {
            if (location == i) {
                this.type = Type.CANINE;
                break;
            }
        }
        for (int i : MOLAR) {
            if (location == i) {
                this.type = Type.MOLAR;
                break;
            }
        }
        for (int i : PREMOLAR) {
            if (location == i) {
                this.type = Type.PREMOLAR;
                break;
            }
        }
        for (int i : INCISOR) {
            if (location == i) {
                this.type = Type.INCISOR;
                break;
            }
        }
    }

    public Item getTooth() {
        return tooth;
    }

    public int getLocation() {
        return location;
    }

    public Type getType() {
        return type;
    }
}
