/**
 * Copyright (c) 2015-2020, www.javadoge.com (linus@live.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.javadoge.blog.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
@ConditionalOnClass(com.alibaba.druid.pool.DruidDataSource.class)
public class DruidConfig {

	@Bean(initMethod = "init", destroyMethod = "close")
	@ConfigurationProperties("spring.datasource.druid")
	@ConditionalOnMissingBean
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
	
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
		reg.addInitParameter("allow", "127.0.0.1"); //白名单
//		reg.addInitParameter("deny",""); //黑名单
		reg.addInitParameter("loginUsername", "lbh");
		reg.addInitParameter("loginPassword", "lbh");
		reg.addInitParameter("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
		return reg;
	}


}
