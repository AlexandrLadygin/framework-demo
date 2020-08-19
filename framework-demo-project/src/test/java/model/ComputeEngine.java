package model;

import java.util.Objects;

public class ComputeEngine {

    private String numberOfInstance;
    private String whatAreTheseInstancesFor;
    private String operatingSystemSoftware;
    private String machineClass;
    private String machineType;
    private String numberOfGPUs;
    private String GPUType;
    private String localSSD;
    private String dataCenterLocation;
    private String committedUsage;

    public ComputeEngine(String numberOfInstance, String whatAreTheseInstancesFor, String operatingSystemSoftware,
                         String machineClass, String machineType, String numberOfGPUs, String GPUType, String localSSD,
                         String dataCenterLocation, String committedUsage) {
        this.numberOfInstance = numberOfInstance;
        this.whatAreTheseInstancesFor = whatAreTheseInstancesFor;
        this.operatingSystemSoftware = operatingSystemSoftware;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;
    }


    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    public String getWhatAreTheseInstancesFor() {
        return whatAreTheseInstancesFor;
    }

    public void setWhatAreTheseInstancesFor(String whatAreTheseInstancesFor) {
        this.whatAreTheseInstancesFor = whatAreTheseInstancesFor;
    }

    public String getOperatingSystemSoftware() {
        return operatingSystemSoftware;
    }

    public void setOperatingSystemSoftware(String operatingSystemSoftware) {
        this.operatingSystemSoftware = operatingSystemSoftware;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }


    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                ", whatAreTheseInstancesFor='" + whatAreTheseInstancesFor + '\'' +
                ", operatingSystemSoftware='" + operatingSystemSoftware + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(numberOfInstance, that.numberOfInstance) &&
                Objects.equals(whatAreTheseInstancesFor, that.whatAreTheseInstancesFor) &&
                Objects.equals(operatingSystemSoftware, that.operatingSystemSoftware) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(GPUType, that.GPUType) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(dataCenterLocation, that.dataCenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance, whatAreTheseInstancesFor, operatingSystemSoftware,
                machineClass, machineType, numberOfGPUs, GPUType, localSSD, dataCenterLocation, committedUsage);
    }
}
