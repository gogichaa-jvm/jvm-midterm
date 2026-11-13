import java.util.Arrays;

public abstract class SmartDevice {
    String deviceName;
    int maxFunctions;
    boolean isActive;
    String[] enabledFunctions;

    public SmartDevice(String deviceName, int maxFunctions) {
        if (maxFunctions <= 0) throw new IllegalArgumentException("maxFunctions must be positive");
        this.deviceName = deviceName;
        this.maxFunctions = maxFunctions;
        this.enabledFunctions = new String[maxFunctions];
        this.isActive = true;
        System.out.println(deviceName + " turned on");
    }

    public void enableFunction(String functionName) {
        try {
            if (functionName == null || functionName.trim().isEmpty())
                throw new IllegalArgumentException("Empty function name");
            for (int i = 0; i < enabledFunctions.length; i++) {
                if (enabledFunctions[i] == null) {
                    enabledFunctions[i] = functionName;
                    System.out.println(functionName + " enabled");
                    return;
                }
            }
            throw new IllegalStateException("Function limit reached");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public String[] getEnabledFunctions() { return enabledFunctions; }
    public abstract void disableFunctions(String... names);

    protected void removeFunctions(String... names) {
        for (String name : names) {
            for (int i = 0; i < enabledFunctions.length; i++) {
                if (name != null && name.equals(enabledFunctions[i])) enabledFunctions[i] = null;
            }
        }
    }

    public void disableAllFunctions() {
        Arrays.fill(enabledFunctions, null);
        System.out.println("All functions disabled");
    }

    protected static String checkOs(String os) {
        if (!"Android".equalsIgnoreCase(os) && !"iOS".equalsIgnoreCase(os)
                && !"Windows".equalsIgnoreCase(os) && !"Linux".equalsIgnoreCase(os))
            throw new IllegalArgumentException("Unknown OS: " + os);
        return os;
    }
}
