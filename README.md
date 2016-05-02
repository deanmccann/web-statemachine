------

What is this?

My experiments with Spring State Machine


------

Build Info

CodeShip [ ![Codeship Status for deanmccann/web-statemachine](https://codeship.com/projects/379d8ea0-f102-0133-aac5-3e251e5cf642/status?branch=master)](https://codeship.com/projects/149327) 

Heroku
https://morning-eyrie-85371.herokuapp.com/

Deployed to AWS 


------

http://bramp.github.io/js-sequence-diagrams/

```sequence
Title: Platform (A) Flow
Intial->Sandbox: Deploy
Sandbox->Published: Deploy
Note right of Published: Published started?\nnot sure
Published->Started: 
Published->Stopped: 
Published->Archived: 
```

-----



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
