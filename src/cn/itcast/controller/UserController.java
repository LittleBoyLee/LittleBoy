package cn.itcast.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.itcast.domain.User;
import cn.itcast.domain.UserCustom;

@Controller//<bean class="UserController"/>
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping(value="/hello.do",method={RequestMethod.GET,RequestMethod.POST})
	public String hello(){
		
		return "index";
	}
	
	//��ת��addҳ��
	@RequestMapping("toAdd")
	public String toAdd(){
		
		return "add";
	}
	
	//����int���Ͳ���
	@RequestMapping("recieveInt")
	public String recieveInt(Integer id){
		
		System.out.println(id);
		
		return "success";
		
	}
	
	//�����ַ����Ͳ���
	@RequestMapping("recieveStr")
	public String recieveStr(String username)
	{
		
		System.out.println(username);
		return "success";
	}
	
	//�����������Ͳ���
	@RequestMapping("recieveArray")
	public String recieveArray(Integer[] ids){
		
		System.out.println(ids);
		
		return "success";
	}
	
	//���ܲ�����װUser����
	@RequestMapping("recieveUser")
	public String recieveUser(User user){
		
		System.out.println(user);
		
		return "success";
	}
	
	//���ܰ�װ���Ͳ���
	@RequestMapping("recieveUserCustom")
	public String recieveUserCustom(UserCustom userCustom){
		
		System.out.println(userCustom);
		
		return "success";
	}
	
		//���ܼ������Ͳ���
	@RequestMapping("recieveList")
	public String recieveList(UserCustom userCustom){
		
		System.out.println(userCustom);
		
		return "success";
	}
		
		//���ܼ������Ͳ���
	@RequestMapping("recieveMap")
	public String recieveMap(UserCustom userCustom){
		
		System.out.println(userCustom);
		
		return "success";
				}
	
	@RequestMapping("list")
	public String list(Model model){
		//model	�൱��application�����
		
		List<User> userList = new ArrayList<User>();
		
		User user1 = new User();
		user1.setId(1);
		user1.setSex("��");
		user1.setUsername("��ɽ��");
		user1.setAddress("�䵱ɽ");
		user1.setBirthday(new Date());
		
		User user2 = new User();
		user2.setId(2);
		user2.setSex("��2");
		user2.setUsername("��ɽ��222");
		user2.setAddress("�䵱ɽ222");
		user2.setBirthday(new Date());
		
		User user3 = new User();
		user3.setId(3);
		user3.setSex("��3");
		user3.setUsername("��ɽ��333");
		user3.setAddress("�䵱ɽ333");
		user3.setBirthday(new Date());
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		model.addAttribute("userList", userList);
		
		return "list";
		
	}
	
	//�޸�
	@RequestMapping("updateByID/{id}")
	public String updateByID(@PathVariable Integer id,Model model){
		User user1 = new User();
		user1.setId(id);
		user1.setSex("��");
		user1.setUsername("��ɽ��");
		user1.setAddress("�䵱ɽ");
		user1.setBirthday(new Date());
		
		model.addAttribute("user", user1);
		
		return "edit";
	}
	
	//����ת��
	@RequestMapping("forward")
	public String forward(){
		
		return "forward:/items/list.do";
	}
	
	//�����ض���
	@RequestMapping("redirect")
	public String redirect(){
		
		return "redirect:/items/list.do";
	}
}