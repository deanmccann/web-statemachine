package com.webco.engine;

/**
 * Created by dean on 20/02/16.
 */
public enum States {

    READY, //Ready to process a request
    RECIEVE, //Recieve External Notifiction of artifact production
    AVAILABLE, //Verified Artifact exists. Available for deployment if event occurs.
    UNAVAILABLE, //Artifact was not found in specified location
    RUNNING, //Deployed and running in target environment
    ERROR

}
