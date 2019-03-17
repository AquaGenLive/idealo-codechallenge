package de.idealo.robotcontrol;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RobotMovementsController.class)
class RobotMovementsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void robotMovements() throws Exception {
        String postBodyPayload = "{\n" +
                "\"currentPositionOfRobot\": {\n" +
                "\"x\": 0,\n" +
                "\"y\": 0\n" +
                "},\n" +
                "\"currentHeadingOfRobot\": \"EAST\",\n" +
                "\"controls\": [\n" +
                "{\n" +
                "\"id\": 1,\n" +
                "\"control\": \"POSITION 1 3 EAST\"\n" +
                "}, {\n" +
                "\"id\": 2,\n" +
                "\"control\": \"FORWARD 3\"\n" +
                "}, {\n" +
                "\"id\": 3,\n" +
                "\"control\": \"WAIT\"\n" +
                "}, {\n" +
                "\"id\": 4,\n" +
                "\"control\": \"TURNAROUND\"\n" +
                "}, {\n" +
                "\"id\": 5,\n" +
                "\"control\": \"FORWARD 1\"\n" +
                "}, {\n" +
                "\"id\": 6,\n" +
                "\"control\": \"RIGHT\"\n" +
                "}, {\n" +
                "\"id\": 7,\n" +
                "\"control\": \"FORWARD 2\"\n" +
                "}\n" +
                "]\n" +
                "}";

        String expectedResponseBody = "{\"position\":{\"x\":3,\"y\":1},\"heading\":\"NORTH\"}";

        mvc.perform(MockMvcRequestBuilders.post("/robot-movements")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postBodyPayload))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseBody));
    }

    @Test
    void errorInRobotMovements() throws Exception {
        String postBodyPayload = "{\n" +
                "\"currentPositionOfRobot\": {\n" +
                "\"x\": 0,\n" +
                "\"y\": 0\n" +
                "},\n" +
                "\"currentHeadingOfRobot\": \"EAST\",\n" +
                "\"controls\": [\n" +
                "{\n" +
                "\"id\": 1,\n" +
                "\"control\": \"TURNAROUND\"\n" +
                "}, {\n" +
                "\"id\": 2,\n" +
                "\"control\": \"FORWARD 1\"\n" +
                "}\n" +
                "]\n" +
                "}";

        mvc.perform(MockMvcRequestBuilders.post("/robot-movements")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postBodyPayload))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Robot tried to move outside of the grid."));
    }
}