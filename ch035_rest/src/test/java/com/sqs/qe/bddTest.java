package com.sqs.qe;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        , glue = "com.sqs.qe.stepdefs"
)

public class bddTest {
}
