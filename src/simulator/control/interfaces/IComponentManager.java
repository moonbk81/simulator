package simulator.control.interfaces;
import simulator.model.Component;

public interface IComponentManager {
	void registerProfile(Component profile);
	void deleteProfile(int index);
	void modifyProfile(int index, Component profile);
	Component retrieveProfile(int index);
}