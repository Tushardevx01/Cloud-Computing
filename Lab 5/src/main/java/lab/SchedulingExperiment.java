package lab;

import org.cloudbus.cloudsim.allocationpolicies.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.brokers.DatacenterBroker;
import org.cloudbus.cloudsim.brokers.DatacenterBrokerSimple;
import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.cloudlets.CloudletSimple;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.datacenters.Datacenter;
import org.cloudbus.cloudsim.datacenters.DatacenterSimple;
import org.cloudbus.cloudsim.hosts.Host;
import org.cloudbus.cloudsim.hosts.HostSimple;
import org.cloudbus.cloudsim.resources.Pe;
import org.cloudbus.cloudsim.resources.PeSimple;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletScheduler;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.schedulers.vm.VmScheduler;
import org.cloudbus.cloudsim.schedulers.vm.VmSchedulerSpaceShared;
import org.cloudbus.cloudsim.schedulers.vm.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModelFull;
import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudsimplus.builders.tables.CloudletsTableBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Lab 5: Cloud Resource Scheduling Simulation using CloudSim Plus.
 * Demonstrates combinations of VM and Cloudlet scheduling policies:
 * - Scenario A: VmSchedulerSpaceShared + CloudletSchedulerSpaceShared
 * - Scenario B: VmSchedulerSpaceShared + CloudletSchedulerTimeShared
 * - Scenario C: VmSchedulerTimeShared + CloudletSchedulerSpaceShared
 * - Scenario D: VmSchedulerTimeShared + CloudletSchedulerTimeShared
 */
public class SchedulingExperiment {

    private static final int HOST_PES = 4;
    private static final int VM_COUNT = 2;
    private static final int CLOUDLET_COUNT = 4;
    private static final long MIPS = 1000;
    private static final long CLOUDLET_LENGTH = 20000;

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("           CLOUD COMPUTING LAB 5: CLOUDSIM PLUS SCHEDULING SIMULATION           ");
        System.out.println("================================================================================\n");

        runScenario("Scenario A", "VmSchedulerSpaceShared", "CloudletSchedulerSpaceShared",
                VmSchedulerSpaceShared::new, CloudletSchedulerSpaceShared::new);

        runScenario("Scenario B", "VmSchedulerSpaceShared", "CloudletSchedulerTimeShared",
                VmSchedulerSpaceShared::new, CloudletSchedulerTimeShared::new);

        runScenario("Scenario C", "VmSchedulerTimeShared", "CloudletSchedulerSpaceShared",
                VmSchedulerTimeShared::new, CloudletSchedulerSpaceShared::new);

        runScenario("Scenario D", "VmSchedulerTimeShared", "CloudletSchedulerTimeShared",
                VmSchedulerTimeShared::new, CloudletSchedulerTimeShared::new);
    }

    private static void runScenario(String name, String vmSchedName, String cloudletSchedName,
                                    Supplier<VmScheduler> vmSchedulerSupplier,
                                    Supplier<CloudletScheduler> cloudletSchedulerSupplier) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" RUNNING " + name + ": VM Scheduler = " + vmSchedName + " | Cloudlet Scheduler = " + cloudletSchedName);
        System.out.println("--------------------------------------------------------------------------------");

        CloudSim simulation = new CloudSim();

        // 1. Create Datacenter with configured VM Scheduler
        Datacenter datacenter = createDatacenter(simulation, vmSchedulerSupplier);

        // 2. Create Broker
        DatacenterBroker broker = new DatacenterBrokerSimple(simulation);

        // 3. Create VMs with fresh CloudletScheduler instances
        List<Vm> vms = createVms(cloudletSchedulerSupplier);

        // 4. Create Cloudlets
        List<Cloudlet> cloudlets = createCloudlets();

        // 5. Submit to Broker
        broker.submitVmList(vms);
        broker.submitCloudletList(cloudlets);

        // 6. Start simulation
        simulation.start();

        // 7. Output Results
        List<Cloudlet> finishedCloudlets = broker.getCloudletFinishedList();
        new CloudletsTableBuilder(finishedCloudlets).build();
        System.out.println();
    }

    private static Datacenter createDatacenter(CloudSim simulation, Supplier<VmScheduler> vmSchedulerSupplier) {
        List<Pe> peList = new ArrayList<>();
        for (int i = 0; i < HOST_PES; i++) {
            peList.add(new PeSimple(MIPS));
        }

        long ram = 8192; // 8 GB
        long bw = 100000; // 100 Gbps
        long storage = 1000000; // 1 TB

        Host host = new HostSimple(ram, bw, storage, peList);
        host.setVmScheduler(vmSchedulerSupplier.get());

        List<Host> hostList = new ArrayList<>();
        hostList.add(host);

        return new DatacenterSimple(simulation, hostList, new VmAllocationPolicySimple());
    }

    private static List<Vm> createVms(Supplier<CloudletScheduler> cloudletSchedulerSupplier) {
        List<Vm> vmList = new ArrayList<>();
        for (int i = 0; i < VM_COUNT; i++) {
            // Allocate a dedicated scheduler instance for each VM
            Vm vm = new VmSimple(MIPS, 2);
            vm.setRam(2048).setBw(10000).setSize(10000);
            vm.setCloudletScheduler(cloudletSchedulerSupplier.get());
            vmList.add(vm);
        }
        return vmList;
    }

    private static List<Cloudlet> createCloudlets() {
        List<Cloudlet> cloudletList = new ArrayList<>();
        for (int i = 0; i < CLOUDLET_COUNT; i++) {
            Cloudlet cloudlet = new CloudletSimple(CLOUDLET_LENGTH, 1, new UtilizationModelFull());
            cloudletList.add(cloudlet);
        }
        return cloudletList;
    }
}
