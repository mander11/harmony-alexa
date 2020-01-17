package com.harmony;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorldStreamHandler extends SkillStreamHandler {

    static final Logger logger = LogManager.getLogger(HelloWorldStreamHandler.class);

    private static Skill getSkill() {
        logger.info("hey!");
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelloWorldIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler())
//                .withSkillId("something")
                .build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }

}
