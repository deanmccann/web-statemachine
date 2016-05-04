
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

----------


```flow
st=>start: Start
e=>end
op=>operation: My Operation
cond=>condition: Yes or No?

st->op->cond
cond(yes)->e
cond(no)->op
```
> Written with [StackEdit](https://stackedit.io/).
