package dev.jake.westward.models.adventurer;


public enum AdventurerClass {
    WARRIOR("Warrior"),
    MAGE("Mage"),
    PRIEST("Priest"),
    ROGUE("Rogue");

    private final String className;

    AdventurerClass(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return className;
    }

    public static AdventurerClass fromString(String className) {
        for (AdventurerClass adventurerClass : AdventurerClass.values()) {
            if (adventurerClass.className.equalsIgnoreCase(className)) {
                return adventurerClass;
            }
        }
        throw new IllegalArgumentException("Unknown class name: " + className);
    }
}
