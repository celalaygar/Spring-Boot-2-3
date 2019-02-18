package com.example.demo.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class MainController {
	

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping("/index")
    public String index2() {
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegisterPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,Map<String, Object> map) {

        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "register";
        } else {
            Role role=new Role();
            role.setRole("ADMIN");
            user.setRoles(new HashSet<Role>() {{
            	add(role);
            }});
    		String pwd = user.getPassword();
    		String encryptPwd = passwordEncoder.encode(pwd);
    		user.setPassword(encryptPwd);
    		map.put("message", "Successful");
    		userRepository.save(user);

        }
        return "register";
    }

    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/secure")
    public String secure(Map<String, Object> map) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	map.put("message", "Kullanıcı Detaylı bilgileri");
    	map.put("user", auth.getName());  
        return "secure";
    }

}
