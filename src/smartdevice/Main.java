import java.util.Arrays;
public class Main {
    public static void main(String[] args) { task1(); }
    public static void task1() {
        try {
            SmartLight light = new SmartLight("Lamp", 2, "Android");
            SmartThermostat thermostat = new SmartThermostat("Heating", 2, "Linux");
            SmartAssistant assistant = new SmartAssistant("Assistant", 3, "Windows");
            light.enableFunction("Brightness");
            light.enableFunction("Color");
            light.enableFunction("Timer");
            light.disableFunctions("Color");
            System.out.println(Arrays.toString(light.getEnabledFunctions()));
            System.out.println(light.deviceName + " active=" + light.isActive);
            thermostat.enableFunction("Temperature");
            System.out.println(Arrays.toString(thermostat.getEnabledFunctions()));
            assistant.enableFunction("Voice");
            System.out.println(Arrays.toString(assistant.getEnabledFunctions()));
            light.disableAllFunctions();
        } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
    }
}
