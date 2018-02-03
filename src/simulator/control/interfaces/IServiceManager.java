package simulator.control.interfaces;
import simulator.model.Service;

public interface IServiceManager {
	void registerProfile(Service profile);
	void deleteProfile(int index);
	void modifyProfile(int index, Service profile);
	Service retrieveProfile(int index);
}