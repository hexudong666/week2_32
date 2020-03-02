package com.hexudong.Demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hexudong.entity.User;
import com.hexudong.utils.entity.StringUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:redis.xml")
public class Demo {

	//注入
	@Autowired
	RedisTemplate redistemplate;
	
	
	@Test
	public void JDKDemo() {
		ArrayList<User> list = new ArrayList<>();
		for (int i = 0; i < 50000; i++) {
		//新定义一个对象
		User user = new User();
		//随机生成名字
		String name = StringUtil.randomChineseName();
//		System.out.println(name);
		//赋值
		user.setName(name+i);
		//给性别赋值
			if (i/2==0) {
				user.setSex("男");
			}else {
				user.setSex("女");
			}
		//给手机号赋值
		String phone = StringUtil.getRandomCharAndNumber(11);
		user.setBirthday("13"+phone);
		
		//给邮箱赋值
		String email = StringUtil.getRandomChar(15);
		user.setEmail(email+"@qq.com  | @163.com | @sian.com | @gmail.com | @sohu.com | @hotmail.com | @foxmail.com");
		
		//给年龄赋值
		user.setBirthday("1950-08-29");
	
		list.add(user);
		
		}
		long start = System.currentTimeMillis();
		redistemplate.opsForList().leftPush("users", list);
		long end = System.currentTimeMillis();
		System.out.println("jdk存储方式");
		System.out.println("耗时"+(end-start)+"毫秒");
		
	}
	
	@Test
	public void JSONDemo() {
		ArrayList<User> list = new ArrayList<>();
		for (int i = 0; i < 50000; i++) {
		//新定义一个对象
		User user = new User();
		//随机生成名字
		String name = StringUtil.randomChineseName();
//		System.out.println(name);
		//赋值
		user.setName(name+i);
		//给性别赋值
			if (i/2==0) {
				user.setSex("男");
			}else {
				user.setSex("女");
			}
		//给手机号赋值
		String phone = StringUtil.getRandomCharAndNumber(11);
		user.setBirthday("13"+phone);
		
		//给邮箱赋值
		String email = StringUtil.getRandomChar(15);
		user.setEmail(email+"@qq.com  | @163.com | @sian.com | @gmail.com | @sohu.com | @hotmail.com | @foxmail.com");
		
		//给年龄赋值
		user.setBirthday("1950-08-29");
	
		list.add(user);
		
		}
		long start = System.currentTimeMillis();
		redistemplate.opsForList().leftPush("users", list);
		long end = System.currentTimeMillis();
		System.out.println("JSON存储方式");
		System.out.println("耗时"+(end-start)+"毫秒");
	}
	
	@Test
	public void HashDemo() {
		HashMap<String, User> map = new HashMap<>();
		User user = new User();
		for (int i = 0; i < 50000; i++) {
		//新定义一个对象
		//随机生成名字
		String name = StringUtil.randomChineseName();
//		System.out.println(name);
		//赋值
		user.setName(name+i);
		//给性别赋值
			if (i/2==0) {
				user.setSex("男");
			}else {
				user.setSex("女");
			}
		//给手机号赋值
		String phone = StringUtil.getRandomCharAndNumber(11);
		user.setBirthday("13"+phone);
		
		//给邮箱赋值
		String email = StringUtil.getRandomChar(15);
		user.setEmail(email+"@qq.com  | @163.com | @sian.com | @gmail.com | @sohu.com | @hotmail.com | @foxmail.com");
		
		//给年龄赋值
		user.setBirthday("1950-08-29");
	
		
		
		}
		long start = System.currentTimeMillis();
		redistemplate.opsForHash().putAll("user", map);
		long end = System.currentTimeMillis();
		System.out.println("HASH存储方式");
		System.out.println("耗时"+(end-start)+"毫秒");
	}
	
}
