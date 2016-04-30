------

Build Info


https://codeship.com/projects/149327/status?branch=master
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
