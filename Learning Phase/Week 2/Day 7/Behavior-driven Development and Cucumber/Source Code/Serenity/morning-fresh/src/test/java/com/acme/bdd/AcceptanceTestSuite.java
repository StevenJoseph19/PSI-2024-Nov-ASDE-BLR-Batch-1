package com.acme.bdd;

//import cucumber.api.CucumberOptions;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
//import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
//import org.junit.runner.RunWith;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

//@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features = "src/test/resources/features")
@Suite
//@IncludeEngines("cucumber")
//@ExtendWith(SerenityJUnit5Extension.class)
@SelectClasspathResource("com/acme/bdd")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.acme.bdd")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,value = "io.cucumber.core.plugin.SerenityReporterParallel," +
        "pretty,timeline:target/test-results/timeline")
public class AcceptanceTestSuite {}
