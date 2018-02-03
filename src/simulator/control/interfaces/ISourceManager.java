package simulator.control.interfaces;
import simulator.model.Source;

public interface ISourceManager {
	void deleteProfile(int index);
	void modifyProfile(int index, Source profile);
	Source retrieveProfile(int index);

    void registerProfile(int rangeFreq, int regularity, int priority, int valueRange, int valueAvgFreq, int valueType);
}