package mass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mass.service.PublicDataServiceImpl;

@RestController
public class PublicDataController {
	@Autowired
	private PublicDataServiceImpl publicDataServiceImpl;
	
	// 데이터 조회
	@GetMapping("/data")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/system/home");
		try {
			publicDataServiceImpl.dataInquiry(0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
}