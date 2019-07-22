package com.lti.app;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("/api")

public class MyApplication extends PackagesResourceConfig {
	public MyApplication() {
        super("com.lti.services");
    }
}
