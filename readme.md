# Robot Control

## Challenge
Develop a simple environment for a robot where you could control it using this predefined script:

- POSITION 1 3 EAST //sets the initial position for the robot
- FORWARD 3 //lets the robot do 3 steps forward
- WAIT //lets the robot do nothing
- TURNAROUND //lets the robot turn around
- FORWARD 1 //lets the robot do 1 step forward
- RIGHT //lets the robot turn right
- FORWARD 2 //lets the robot do 2 steps forward

This script should be sent from frontend to backend as a single chunk using POST Method. After script execution UI should render a new robot position on the grid and direction it looks to.

Please implement a movement/business logic using Java+Spring in backend. Frontend should be only responsible for submitting the script and rendering robot on the grid.

For aesthetic reasons you should limit the grid in the Frontend for the robot to 5 x 5 steps. The initial grid position is 0,0 and is in the top left corner.
It is optional, if the backend will be also aware of the grid limits.

Frontend should be styled. You could do it yourself or use some framework. 

Please create a unit-test for only one(!) component, a full test-coverage is not necessary.

### Backlog
- [x] Setup Spring Boot app
- [ ] Create Control and RestController to:
    - [x] Create robot resource
    - [ ] Set init position
    - [ ] Move robot forward 1, 2 or 3 steps
    - [ ] Let robot wait
    - [ ] Turnaround
    - [ ] Turn the robot right
- [ ] Setup frontend
- [ ] Create grid
- [ ] Create controls
- [ ] Interact with REST API