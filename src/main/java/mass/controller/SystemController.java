package mass.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SystemController {
	// 메인화면
	@GetMapping("/mass")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/system/home");
		
		return mv;
	}
	
	// 서브화면
	@GetMapping("/mass/sub")
	public ModelAndView sub() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/system/sub");
		
		return mv;
	}
	
	// 서브화면2
	@GetMapping("/mass/sub2")
	public ModelAndView sub2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/system/sub2");
			
		return mv;
	}
}