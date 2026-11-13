public class SmartAssistant extends SmartDevice {
    String os;
    public SmartAssistant(String deviceName, int maxFunctions, String os) {
        super(deviceName, maxFunctions);
        this.os = checkOs(os);
    }
    @Override public void disableFunctions(String... names) { removeFunctions(names); }
    @Override public String[] getEnabledFunctions() {
        System.out.println("OS: " + os);
        return super.getEnabledFunctions();
    }
}
