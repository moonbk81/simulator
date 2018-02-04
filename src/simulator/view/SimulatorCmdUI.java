package simulator.view;

import simulator.control.SimulatorProxy;

import java.util.Scanner;

public class SimulatorCmdUI {
    private static Scanner scanner = new Scanner(System.in);
    private SimulatorProxy proxy;

    public SimulatorCmdUI(SimulatorProxy proxy) {
        super();
        this.proxy = proxy;
        proxy.generateSampleData();
    }

    public void start() {
        boolean quit = false;

        while (!quit) {
            int command = getMainMenuCommand();
            switch (command) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    register("user");
                    break;
                case 2:
                    register("system");
                    break;
                case 3:
                    register("source");
                    break;
                case 4:
                    register("adapter");
                    break;
                case 5:
                    register("event");
                    break;
                case 6:
                    register("component");
                    break;
                case 7:
                    register("service");
                    break;
                case 8:
                    retrieve("user");
                    break;
                case 9:
                    retrieve("system");
                    break;
                case 10:
                    retrieve("source");
                    break;
                case 11:
                    retrieve("adapter");
                    break;
                case 12:
                    retrieve("event");
                    break;
                case 13:
                    retrieve("service");
                    break;
                case 14:
                    retrieve("component");
                    break;
                default:
                    break;
            }
        }
        System.out.println("Bye");
    }

    public void retrieve(String object) {
        System.out.println("Retrieve " + object + " profile");
        if (object.equals("user")) {
            System.out.print(proxy.retrieveUserProfiles());
        } else if (object.equals("system")) {
            System.out.print(proxy.retrieveSystemProfiles());
        } else if (object.equals("source")) {
            System.out.println(proxy.retrieveSourceProfiles());
        } else if (object.equals("adapter")) {
            System.out.println(proxy.retrieveAdapterProfiles());
        } else if (object.equals("event")) {
            System.out.println(proxy.retrieveEventProfiles());
        } else if (object.equals("service")) {
            System.out.println(proxy.retrieveServiceProfiles());
        } else if (object.equals("component")) {
            System.out.println(proxy.retrieveComponentProfiles());
        }
        System.out.println("End of list");
    }

    public void register(String type) {
        if (type == null) {
            type = "";
        }
        if (type.equals("user")) {
            System.out.println("Please sign on");
            System.out.println("Enter user id: ");
            String userId = scanner.next();

            System.out.println("Enter user name: ");
            String userName = scanner.next();

            System.out.println("Enter email: ");
            String email = scanner.next();

            System.out.println("Enter contact number: ");
            String contactNumber = scanner.next();

            System.out.println("Enter password: ");
            String password = scanner.next();

            proxy.signOn(userId, userName, email, contactNumber, password);
        } else if (type.equals("system")) {
            System.out.println("Please input system profile");
            System.out.println("Enter system name");
            String name = scanner.next();

            System.out.println("Enter system id");
            int id = scanner.nextInt();

            System.out.println("Enter core number of system");
            int core = scanner.nextInt();

            System.out.println("Enter max memory capability");
            int maxCapa = scanner.nextInt();

            System.out.println("Don't input processor, it is set as 1 by default");

            proxy.registerSystemProfile(name, id, core, maxCapa);
        } else if (type.equals("source")) {
            System.out.println("Enter event source range frequency");
            int rangeFreq = scanner.nextInt();

            System.out.println("Enter event source regularity");
            int regularity = scanner.nextInt();

            System.out.println("Enter event source priority");
            int priority = scanner.nextInt();

            System.out.println("Enter event source value range");
            int valueRange = scanner.nextInt();

            System.out.println("Enter event source value average frequency");
            int valueAvgFreq = scanner.nextInt();

            System.out.println("Enter event source value type");
            int valueType = scanner.nextInt();

            proxy.registerSourceProfile(rangeFreq, regularity, priority, valueRange, valueAvgFreq, valueType);
        } else if (type.equals("adapter")) {

        } else if (type.equals("event")) {

        } else if (type.equals("service")) {

        } else if (type.equals("component")) {

        }
    }

    public int getMainMenuCommand() {
        System.out.println("\r\nSelect a command !");
        System.out.println("\t 0. Quit");
        System.out.println("\t 1. Sign On");
        System.out.println("\t 2. Register System Profile");
        System.out.println("\t 3. Register Source Profile");
        System.out.println("\t 4. Register Adapter profile");
        System.out.println("\t 5. Register Event profile");
        System.out.println("\t 6. Register Component profile");
        System.out.println("\t 7. Register Service Profile");
        System.out.println("\t 8. Retrieve User Profile");
        System.out.println("\t 9. Retrieve System Profiles");
        System.out.println("\t 10. Retrieve Source Profiles");
        System.out.println("\t 11. Retrieve Adapter Profiles");
        System.out.println("\t 12. Retrieve Event Profiles");
        System.out.println("\t 13. Retrieve Service Profiles");
        System.out.println("\t 14. Retrieve Component Profiles");

        int command = scanner.nextInt();

        return command;
    }
}
