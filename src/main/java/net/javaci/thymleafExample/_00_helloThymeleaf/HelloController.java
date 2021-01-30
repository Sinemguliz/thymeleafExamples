package net.javaci.thymleafExample._00_helloThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	@GetMapping("/merhaba") //urldeki isimle eslesmesi lazim
	public String renderHello(Model model) {
		model.addAttribute("welcome_message", "Merhaba Arkadaslar");
		return "hello"; //dosyanin ismiyle eslesmesi lazim template/hello.html dosyam var
	}
	@GetMapping("/merhaba2") //urldeki isimle eslesmesi lazim
	public String renderHello2(Model model, @RequestParam(name = "name", required = false, defaultValue = "World")String name) {
		model.addAttribute("name", name);
		return "hello2";
	}
	
	

	

}
