package dev.jake.westward.models.quests;

public enum Status {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    FAILED("Failed");

    private final String statusText;

    Status(String statusText) {
        this.statusText = statusText;
    }

    @Override
    public String toString() {
        return statusText;
    }

    public static Status fromString(String statusText) {
        for (Status status : Status.values()) {
            if (status.statusText.equalsIgnoreCase(statusText)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown quest status: " + statusText);
    }
}
