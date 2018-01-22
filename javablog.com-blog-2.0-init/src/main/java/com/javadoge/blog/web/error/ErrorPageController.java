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

package com.javadoge.blog.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @title: error page controller
 * @description: TODO
 * @author: libinghui  
 * @date: Jan 19, 2018 
 * @version: V2.0
 */
@Controller
@RequestMapping("error")
public class ErrorPageController {
	
	private static final String ERROR = "/error/";
	
	/**
	 * NOT_FOUND PAGE
	 * @return
	 */
	@GetMapping("404")
	public String error404Page () {
		return ERROR+"404";
	}
	/**
	 * UNAUTHORIZED PAGE
	 * @return
	 */
	@GetMapping("401")
	public String error401Page () {
		return ERROR+"401";
	}
	/**
	 * INTERNAL_SERVER_ERROR PAGE
	 * @return
	 */
	@GetMapping("500")
	public String error500Page () {
		return ERROR+"500";
	}
	
}
