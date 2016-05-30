/**
 * @Project: communityFocus
 * @FilePath: com.newenv.communityFocus.configuration.ConfigConfiguration.java
 * @author: mingjie.lu
 * @date: 2016年5月9日 下午6:20:24
 */
package com.newenv.communityFocus.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: com.newenv.communityFocus.configuration.ConfigConfiguration
 * @Description: 系统配置类
 * @author: mingjie.lu
 * @date: 2016年5月9日 下午6:20:24
 */
@Configuration
@ConfigurationProperties(prefix = "config")
public class ConfigConfiguration {
	
	private String bmsUrl;
	
	private String logoutUrl;
	
	private String imagePath;
	
	private String jmbjrUrl;

	/**
	 * @return the bmsUrl
	 */
	public String getBmsUrl() {
		return bmsUrl;
	}

	/**
	 * @param bmsUrl the bmsUrl to set
	 */
	public void setBmsUrl(String bmsUrl) {
		this.bmsUrl = bmsUrl;
	}

	/**
	 * @return the logoutUrl
	 */
	public String getLogoutUrl() {
		return logoutUrl;
	}

	/**
	 * @param logoutUrl the logoutUrl to set
	 */
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the jmbjrUrl
	 */
	public String getJmbjrUrl() {
		return jmbjrUrl;
	}

	/**
	 * @param jmbjrUrl the jmbjrUrl to set
	 */
	public void setJmbjrUrl(String jmbjrUrl) {
		this.jmbjrUrl = jmbjrUrl;
	}
	
}
