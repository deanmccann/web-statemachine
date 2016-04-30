------

What is this?

My experiments with Spring State Machine


------

Build Info

CodeShip [ ![Codeship Status for deanmccann/web-statemachine](https://codeship.com/projects/379d8ea0-f102-0133-aac5-3e251e5cf642/status?branch=master)](https://codeship.com/projects/149327) 

Deployed to AWS 


------


Simple State Machine #1 - Notify, Verify, Pause, Deploy

State
    READY - Ready to recieve instuction

External Event
    /event/newArtifact - ArtifactNotificationEvent

    Transition to RECIEVE
        Receive Guard should verify artifact coordinates.
        Guard to AVAILABLE
        Else UNAVAILABLE

Internal Timed Deploy Event
    Timed delay

    Transition to RUNNING
