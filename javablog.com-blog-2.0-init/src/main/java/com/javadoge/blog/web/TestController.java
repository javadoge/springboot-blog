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

package com.javadoge.blog.web;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javadoge.blog.mapper.TestMapper;

/**
 * 
 * @title: redis template test
 * @description: TODO
 * @author: libinghui  
 * @date: Jan 22, 2018 
 * @version: V2.0
 */
@Controller
public class TestController {
	
	@Autowired
	private TestMapper testMapper;
	
	
	@Autowired //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集  
    private StringRedisTemplate stringRedisTemplate; 
	
	@GetMapping("test")
	@ResponseBody
	public String test () {
		List<HashMap<String, Object>> queryArticleCategory = testMapper.queryArticleCategory();
		stringRedisTemplate.opsForValue().set(UUID.randomUUID().toString(), "uuid");
		return queryArticleCategory.toString();
	}

	
}
