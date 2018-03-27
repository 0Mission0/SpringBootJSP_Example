package idv.mission.example.SpringBootJSP_Example;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@Value("${welcome.message:If cannot read welcome message, then show this}")
	private String message;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		// Mapping to spring.mvc.view.prefix + welcome + spring.mvc.view.suffix
		// /WEB-INF/jsp/ + welcome + .jsp
		return "welcome";	
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		return "Hello";
	}
	
	@RequestMapping("/hello/{name}")
	public @ResponseBody String hello(@PathVariable String name) {
		return "Hello, " + name;
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public @ResponseBody String post(HttpServletRequest request) {
		String data = request.getParameter("data");
		return "Hello By post: " + data;
	}
}