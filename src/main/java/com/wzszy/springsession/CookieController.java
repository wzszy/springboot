package com.wzszy.springsession;

import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {
	
	@Autowired
	private RedisTemplate<String , String > redisTemplate;

    @RequestMapping("cookie")
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
        System.out.println("------------------------");
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }
        
        System.out.println("------------------------");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "index";
    }
    
    @RequestMapping("redis")
    public String getRedis() {
        System.out.println("=================");
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
    	Set<Object> keys = redisTemplate.boundHashOps("spring:session:sessions:8911e065-45d4-4559-a8d4-f90c89becb74")
    	.keys();
    	List<Object> values = redisTemplate.boundHashOps("spring:session:sessions:8911e065-45d4-4559-a8d4-f90c89becb74")
    			.values();
    	System.out.println(keys);
    	System.out.println(values);
    	return "ok";
    }
    
    
}