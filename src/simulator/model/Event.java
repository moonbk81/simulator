package simulator.model;

public class Event extends Profile {
    private int eventId;
    private boolean eventCondition; // it will be decided by source value
    public Event() {
    }

    public Event(int eventId, boolean eventCondition) {
        this.eventId = eventId;
        this.eventCondition = eventCondition;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public boolean isEventCondition() {
        return eventCondition;
    }

    public void setEventCondition(boolean eventCondition) {
        this.eventCondition = eventCondition;
    }
}