package com.gjun.service;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//�t�m�A�ȤJ�f��m
@ApplicationPath("v1")
public class MyApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return super.getClasses();
	}

}
