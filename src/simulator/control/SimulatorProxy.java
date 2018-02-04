package simulator.control;
import simulator.control.interfaces.*;
import simulator.model.Adapter;
import simulator.model.Component;
import simulator.model.Event;
import simulator.model.Service;
import simulator.model.Source;
import simulator.model.SystemProfile;
import simulator.model.UserProfile;

import java.util.List;


public class SimulatorProxy {
	IAdministrationManager adminManager = null;
	ISystemManager systemManager = null;
	IUserManager userManager = null;
	ISourceManager sourceManager = null;
	IAdapterManager adapterManager = null;
	IEventManager eventManager = null;
	IServiceManager serviceManager = null;
	IComponentManager componentManager = null;
	ISimulationManager simulationManager = null;
	IExecutionManager executionManager = null;
	IQualityManager qualityManager = null;

	public SimulatorProxy() {
		initSimulator(this);
	}

	private void initSimulator(SimulatorProxy si) {
		adminManager = new AdministrationManager(si);
		systemManager = new SystemManager(si);
		userManager = new UserManager(si);
		sourceManager = new SourceManager(si);
		adapterManager = new AdapterManager(si);
		eventManager = new EventManager(si);
		serviceManager = new ServiceManager(si);
		componentManager = new ComponentManager(si);
		simulationManager = new SimulationManager(si);
		executionManager = new ExecutionManager(si);
		qualityManager = new QualityManager(si);
		System.out.println("initSimulator");
	}
	
	public ISimulationManager getSimulationManager() {
		return simulationManager;
	}

	public IExecutionManager getExecutionManager() {
		return executionManager;
	}

	public IQualityManager getQualityManager() {
		return qualityManager;
	}

	public IAdministrationManager getAdminManager() {
		return adminManager;
	}


	public ISystemManager getSystemManager() {
		return systemManager;
	}


	public IUserManager getUserManager() {
		return userManager;
	}


	public ISourceManager getSourceManager() {
		return sourceManager;
	}


	public IAdapterManager getAdapterManager() {
		return adapterManager;
	}


	public IEventManager getEventManager() {
		return eventManager;
	}


	public IServiceManager getServiceManager() {
		return serviceManager;
	}


	public IComponentManager getComponentManager() {
		return componentManager;
	}

	public void signOn(String id, String name, String email, String number, String pwd) {
		adminManager.signOn(id, name, email, number, pwd);
	}

	public boolean logIn(String id, String pwd) {
		return adminManager.logIn(id, pwd);
	}

	public void logOut() {
		adminManager.logOut();
	}

	public void chooseAd() {
		// TODO Auto-generated method stub
		
	}

	public void chooseSystemProfile() {
		// TODO Auto-generated method stub
		
	}

	public void startSimulation() {
		// TODO Auto-generated method stub
		
	}

	public void registerSystemProfile(String name, int id, int core, int maxCapa) {
		systemManager.registerProfile(name, id, core, maxCapa);
	}

	public void registerSourceProfile(int rangeFreq, int regularity, int priority, int valueRange, int valueAvgFreq, int valueType) {
		sourceManager.registerProfile(rangeFreq, regularity, priority, valueRange, valueAvgFreq, valueType);
	}

	public String retrieveUserProfiles() {
		StringBuilder sb = new StringBuilder();
		List<UserProfile> users = userManager.getUserProfiles();

		for (UserProfile user : users) {
			sb.append(
					"User name: " + user.getUserName() +
							"\tUser ID: " + user.getUserId() +
							"\tEmail: " + user.getUserEmail() +
							"\tContact: " + user.getContactNumber() +
							"\r\n"
			);
		}

		return sb.toString();
	}

	public String retrieveSystemProfiles() {
		StringBuilder sb = new StringBuilder();
		List<SystemProfile> systems = systemManager.getSystemProfiles();

		for (SystemProfile system : systems) {
			sb.append(
					"System name: " + system.getName() +
							"\tSystem ID: " + system.getId() +
							"\tCore num: " + system.getCoreNums() +
							"\tMax Capa: " + system.getMaxMemoryCapa() +
							"\r\n"
			);
		}

		return sb.toString();
	}

    public String retrieveSourceProfiles() {
		StringBuilder sb = new StringBuilder();
		List<Source> sources = sourceManager.getSourceProfiles();

		for (Source source : sources) {
			sb.append(
					"Source value type: " + source.getValueType() +
							"\tvalue range: " + source.getValueRange() +
							"\tvalue average frequency: " + source.getValueAvgFreq() +
							"\tpriority: " + source.getPriority() +
							"\tregularity of frequency: " + source.getRegularityOfFrequency() +
							"\trange frequency: " + source.getRangeFrequency() +
							"\r\n"
			);
		}

		return sb.toString();
	}

	public String retrieveAdapterProfiles() {
		StringBuilder sb = new StringBuilder();
		List<Adapter> adapters = adapterManager.getAdapterProfiles();

		for (Adapter adapter : adapters) {
			sb.append(
					"Adapter complexity: " + adapter.getComplexity() +
							"\tmemory consumption: " + adapter.getMemoryConsumption() +
							"\tadapter source type: " + adapter.getSourceType() +
							"\r\n"
			);
		}
		return sb.toString();
	}

	public String retrieveEventProfiles() {
		StringBuilder sb = new StringBuilder();
		List<Event> events = eventManager.getEventProfiles();

		for (Event event : events) {
			sb.append(
					"Event id: " + event.getEventId() +
							"\tEvent condition: " + event.isEventCondition() +
							"\r\n"
			);
		}
		return sb.toString();
	}

	public String retrieveServiceProfiles() {
		StringBuilder sb = new StringBuilder();
		List<Service> services = serviceManager.getServiceProfiles();

		for (Service service : services) {
			sb.append(
					"Service event id: " + service.getEventId() +
                            "\tservice components: ");
			for (Component component : service.getComponents()) {
                sb.append(component.getComponent() + ", ");
            }
			sb.append("\r\n");
		}
		return sb.toString();
	}

	public String retrieveComponentProfiles() {
	    StringBuilder sb = new StringBuilder();
	    List<Component> components = componentManager.getComponentProfiles();

	    for (Component component : components) {
            sb.append(
                    "Component complexity: " + component.getComplexity() +
                            "\tcomplexity range: " + component.getComplexityRange() +
                            "\tmemory consumption: " + component.getMemoryResource() +
                            "\tmemory consumption range: " + component.getMemoryRange() +
                            "\r\n"
            );
        }
		return sb.toString();
	}
}
