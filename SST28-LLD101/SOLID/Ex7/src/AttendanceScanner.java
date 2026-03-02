public class AttendanceScanner implements AttendanceCapable, PowerSwitchable {

    @Override public void powerOn() { }

    @Override public void powerOff() { }

    @Override public int scanAttendance() {
        return 3;
    }
}
