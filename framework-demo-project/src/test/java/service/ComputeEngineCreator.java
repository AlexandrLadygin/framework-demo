package service;

import model.ComputeEngine;

public class ComputeEngineCreator {

    public static final String NUMBER_OF_INSTANCE = "4";
    public static final String WHAT_ARE_THESE_INSTANCES_FOR = "";
    public static final String OPERATING_SYSTEM_SOFTWARE = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    public static final String MACHINE_CLASS = "Regular";
    public static final String MACHINE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    public static final String NUMBER_OF_GPUS = "1";
    public static final String GPU_TYPE = "NVIDIA Tesla V100";
    public static final String LOCAL_SSD = "2x375 GB";
    public static final String DATA_CENTER_LOCATION = "Frankfurt (europe-west3)";
    public static final String COMMITTED_USAGE = "1 Year";

    public static ComputeEngine withCredentialsProperties (){
        return new ComputeEngine(NUMBER_OF_INSTANCE, WHAT_ARE_THESE_INSTANCES_FOR, OPERATING_SYSTEM_SOFTWARE, MACHINE_CLASS,
                MACHINE_TYPE, NUMBER_OF_GPUS, GPU_TYPE, LOCAL_SSD, DATA_CENTER_LOCATION, COMMITTED_USAGE);
    }



}
