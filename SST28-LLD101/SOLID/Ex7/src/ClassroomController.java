public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {

        PowerSwitchable pjPower = reg.getFirstOfType(Projector.class);
        pjPower.powerOn();

        InputConnectable input = reg.getFirstOfType(Projector.class);
        input.connectInput("HDMI-1");

        BrightnessControl lights = reg.getFirstOfType(LightsPanel.class);
        lights.setBrightness(60);

        TemperatureControl ac = reg.getFirstOfType(AirConditioner.class);
        ac.setTemperatureC(24);

        AttendanceCapable scan = reg.getFirstOfType(AttendanceScanner.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");

        reg.getFirstOfType(Projector.class).powerOff();
        reg.getFirstOfType(LightsPanel.class).powerOff();
        reg.getFirstOfType(AirConditioner.class).powerOff();
    }
}
