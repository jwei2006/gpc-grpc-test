package com.jw.test.grpc.netty;

public class AppContext implements ApplicationContextAware {

	public static final String TCP_SERVER = "tcpServer";

	// The spring application context.
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		AppContext.applicationContext = applicationContext;
	}

	// 根据beanName获取bean
	public static Object getBean(String beanName) {
		if (null == beanName) {
			return null;
		}
		return applicationContext.getBean(beanName);
	}

}
