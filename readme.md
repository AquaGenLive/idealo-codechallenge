# Robot Control

## Start application
Run the command:
```
./mvnw spring-boot:run
```
Or start the app via IDE with Run-Configuration for Spring-Boot.

## Usage
Open the URL: http://localhost:8080

## General information
The application consists of a jQuery based frontend and a Spring-Boot backend.
The backend is stateless as the frontend manages the state (position and heading of the robot).


## Potential things to improve
- The frontend is in jQuery due to a lack of time. I would try to build the frontend in a more sophisticated frontend framework like vue.js.
- Frontend tests should be added in a real-life project.
- The frontend allows to dynamically add control inputs, but it doesn't allow to remove them. This could be a nice UX improvement.
- The grid has a few glitches, especially on mobile screen sizes. This could be improved.
- The app is only working with enabled JS. Especially with jQuery it could be modified to work without JS as well.
- The app could understand a few more commands like: LEFT, BACKWARD FORWARD n steps instead of only 1, 2, or 3.
- The control input fields could be changed to dropdowns with additional input fields for necessary parameters. Would lead to improved UX.


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
