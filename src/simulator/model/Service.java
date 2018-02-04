package simulator.model;

import java.util.*;

public class Service extends Profile {
	private ArrayList<Component> components;
	private int eventId;
	
    public Service() {
    	components = new ArrayList<>();
		eventId = -1;
    }
    
	public Component getComponents(int componentId) {
		if (this.components != null && !this.components.isEmpty()) {
			return this.components.get(componentId);
		}
		return null;
	}

	public void addComponent(Component components) {
		if (this.components != null) {
			this.components.add(components);
		}
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}
}