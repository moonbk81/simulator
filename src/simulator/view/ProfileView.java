package simulator.view;

import simulator.control.SimulatorProxy;

public abstract class ProfileView {
    protected SimulatorProxy proxy;
    public ProfileView() {
    }
    public abstract void registerCommand();
    public abstract void retrieveCommand();
}
