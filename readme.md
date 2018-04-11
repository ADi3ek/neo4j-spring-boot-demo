**This is a simple Spring Boot project to showcase the problem described on StackOverflow here:**

**https://stackoverflow.com/questions/49783019/unable-to-change-or-delete-relationship-between-nodes-with-neo4j-ogm-using-sprin**

The demo uses Spring Boot framework with Spring Data Neo4j module. There are two nodes and one relationship between them defined:

* `Task` node, which can have one `Status` (`HAS_STATUS` outgoing relationship)
* `Status` node, which can have `HAS_STATUS` incoming relationships from different `Task` nodes

One can manipulate the nodes using Spring shell commands:

* `create-statuses` - creates all three demo `Status` nodes at once: _todo_, _in_progress_, _done_<br><br>
* `create-task` - creates task node with provided task _key_ and status _key_, usage example:<br><br>
    `create-task TASK1 todo`<br><br>
* `update-task-status` - updates the task with a new `Status`, usage example:<br><br>
    `update-task-status TASK1 in_progress`
    
Apparently, updating the `Status` of a `Task` doesn't currently work as expected, that is, the old relationship will remain instead of being removed. 
Also, removing a `Status` also does not work. **If you have any idea what I might be doing wrong here, please let me know!**  




