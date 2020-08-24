package service;

import model.ComputeEngine;

public class ComputeEngineCreator {

    public static final String NUMBER_OF_INSTANCE = "testdata.computeengine.numberofinstance";
    public static final String WHAT_ARE_THESE_INSTANCES_FOR = "testdata.computeengine.whataretheseinstancesfor";
    public static final String OPERATING_SYSTEM_SOFTWARE = "testdata.computeengine.operatingsystemsoftware";
    public static final String MACHINE_CLASS = "testdata.computeengine.machineclass";
    public static final String MACHINE_TYPE = "testdata.computeengine.machinetype";
    public static final String NUMBER_OF_GPUS = "testdata.computeengine.numberofgpus";
    public static final String GPU_TYPE = "testdata.computeengine.gputype";
    public static final String LOCAL_SSD = "testdata.computeengine.localssd";
    public static final String DATA_CENTER_LOCATION = "testdata.computeengine.datacenterlocation";
    public static final String COMMITTED_USAGE = "testdata.computeengine.committedusage";
    public static final String EXPECTED_ESTIMATE = "testdata.computeengine.expectedestimate";

    public static ComputeEngine withCredentialsProperties (){
        return new ComputeEngine(TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(WHAT_ARE_THESE_INSTANCES_FOR),
                TestDataReader.getTestData(OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE),
                TestDataReader.getTestData(EXPECTED_ESTIMATE));
    }



}
