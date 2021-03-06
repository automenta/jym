package org.deeplearning4j.gym.test;

import org.deeplearning4j.gym.Gym;
import org.junit.Test;

public class GymMain {

    @Test
    public void testClient() {


        String url = "http://localhost:5000";
        String env =
                "CartPole-v0";
                //"Pong-v0";
                //"SpaceInvaders-v0";
                //"LunarLanderContinuous-v2";
                //"Copy-v0";

        boolean render = true;

        Gym gym = Gym.connect(url, env, render);
        try {
            System.out.println("Environments: " + gym.environments());
            //client.monitorStart(testDir, true, false);

            int episodeCount = 4;
            int maxSteps = 200;
            int reward = 0;
            for (int e = 0; e < episodeCount; e++) {
                reward += gym.episode(maxSteps, (i) -> gym.actions.random());
            }

            //client.monitorClose();
            //client.upload(testDir, "YOUR_OPENAI_GYM_API_KEY");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            gym.close();
        }

        //client.serverShutdown();

    }

}
