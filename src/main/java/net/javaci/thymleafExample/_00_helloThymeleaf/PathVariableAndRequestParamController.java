package net.javaci.thymleafExample._00_helloThymeleaf;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PathVariableAndRequestParamController {
	
	// http://localhost:8080/pathVariable/3 
	@GetMapping("/pathVariable/{id}")
	public String renderPathVariable(Model model, @PathVariable String id) {
	    return rendermessagePage(model, "/pathVariable/{id}", "id: " + id);
	}
	
	// http://localhost:8080/requestParam?id=3
	@GetMapping("/requestParam")
	public String renderRequestParam(Model model, @RequestParam String id) {
		return rendermessagePage(model, "/requestParam", "id: " + id);
	}
	
	// defaultValue
	// name
	// required
	// value
	
	// http://localhost:8080/pathVariable/optinal
	// http://localhost:8080/pathVariable/optinal/3
	@GetMapping({"/pathVariable/optinal", "/pathVariable/optinal/{id}"}) //birden fazla path verilebilir;burada aslinda array olusturmus olduk value yerine name kullanilabilir
	public String renderPathVariableOptinal(Model model, @PathVariable(required = false) String id){	
		return rendermessagePage(model, "/pathVariable/optinal", "id: " + id);
	}
	
	// http://localhost:8080/requestParam/optinal
	// http://localhost:8080/requestParam/optinal?id=3
	@GetMapping({"/requestParam/optinal", "/requestParam/optinal",})
	public String renderRequestParamOptinal(Model model, @RequestParam(required = false) String id){ //default value belirli olmadigi icin bir deger verilmezse error400 hatasi alinir.
		//yani deger null oldugu icin
		return rendermessagePage(model, "/requestParam/optinal", "id: " + id);
	}
	
	// http://localhost:8080/requestMapping/3
	@RequestMapping(path = "requestMapping/{id}", method = RequestMethod.GET)
	public String renderRequestMapping(Model model, @PathVariable(required = false) String id){
		return rendermessagePage(model, "/RequestMapping/{id}", "id: " + id);
	}
	
	private String rendermessagePage(Model model, String from, String message) {
		model.addAttribute("from", from);
		model.addAttribute("message", message);
		return "message";
	}

}