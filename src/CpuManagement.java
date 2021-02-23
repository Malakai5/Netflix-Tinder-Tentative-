
import com.sun.management.OperatingSystemMXBean;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.lang.management.ManagementFactory;


public class CpuManagement {
    MBeanServerConnection myConnection = ManagementFactory.getPlatformMBeanServer();
    public OperatingSystemMXBean mxBean = ManagementFactory.newPlatformMXBeanProxy(
            myConnection, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);

    public long nanoTimeBefore;
    public long nanoTimeAfter;
    public long cpuAfter;
    public long cpuBefore;
    public long cpuPercent;

    public void setSystemBefore(){
        this.nanoTimeBefore = System.nanoTime();
        this.cpuBefore = mxBean.getProcessCpuTime();
    }

    public void setSystemAfter(){
        this.nanoTimeAfter = System.nanoTime();
        this.cpuAfter = mxBean.getProcessCpuTime();
    }

    public String getCpuUsage(){
        if (nanoTimeAfter > nanoTimeBefore){
            this.cpuPercent = (cpuAfter - cpuBefore)*100L/
                    (nanoTimeAfter - nanoTimeBefore);
        }
        else { this.cpuPercent = 0; }
        return ("Cpu Usage is " + cpuPercent + "%");
    }


    public CpuManagement() throws IOException {
    }
}