package javabasic.oop;

public class ImonitorMain {

	public static void main(String[] args) {
		
		IMonitor imonitor = new IMonitorImpl();
		imonitor.powerOn();
		imonitor.brightUp();
		imonitor.brightDown();
		imonitor.powerOff();

	}

}
