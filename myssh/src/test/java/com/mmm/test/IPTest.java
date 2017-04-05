package com.mmm.test;

import org.apache.log4j.Logger;

import com.mmm.commons.CommonUtils;

public class IPTest implements Runnable{
	private static Logger logger = Logger.getLogger(IPTest.class);
	public static String IP= "";
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			IP = "101.254.183.4"+i;
			new Thread(new IPTest()).start();
		}
	}

	@Override
	public void run() {
		try {
			logger.info(Thread.currentThread().getName()+"-----------------------------------");
			logger.info(Thread.currentThread().getState()+"-----------------------------------");
//			synchronized (IP) {
//			}
			CommonUtils.getAddressByIP(IP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
