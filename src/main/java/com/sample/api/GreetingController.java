package com.sample.api;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	BuildProperties buildProperties;
	
    @RequestMapping("/")
    public String greeting() {
         
    	// Artifact's name from the pom.xml file
    	String name = buildProperties.getName();
    	// Artifact version
    	String version = buildProperties.getVersion();
    	// Date and Time of the build
    	Instant time = buildProperties.getTime();
    	// Artifact ID from the pom file
    	String artifact = buildProperties.getArtifact();
    	// Group ID from the pom file
    	String group = buildProperties.getGroup();
    	    	
    	return String.format("Name: %s, Version: %s, Time: %s, Artifact: %s, Group: %s", name, version, time.toString(), artifact, group); 
    }
}