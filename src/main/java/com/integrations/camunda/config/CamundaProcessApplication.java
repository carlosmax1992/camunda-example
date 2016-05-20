package com.integrations.camunda.config;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("camunda-example")
public class CamundaProcessApplication extends ServletProcessApplication {

}
