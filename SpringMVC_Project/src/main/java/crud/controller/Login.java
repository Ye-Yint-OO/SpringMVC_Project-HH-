package crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Repository.StudentRepo;
import crud.model.LoginBean;
import crud.model.StudentBean;

@Controller
public class Login {
	@Autowired
	private StudentRepo repo;
	@GetMapping("/")
	public ModelAndView test() {
		LoginBean bean=new LoginBean();
		ModelAndView mv=new ModelAndView("login","beanForLogin",bean);
		
		return mv;
	}
	
	@RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute("beanForLogin")LoginBean bean,HttpServletRequest request) {
		if(bean.getEmail()!=null) {
			StudentRepo repo=new StudentRepo();
			boolean result=repo.checkEmail(bean.getEmail());
			if(result) {
				StudentBean bean2=repo.checkPassword(bean.getEmail(), bean.getPassword());
				if(bean2!=null) {
					if(bean2.getRole().equals("admin")) {
						return "adminview";
					}else {
						return "userview";
					}
				}else {
					request.setAttribute("error", "Wrong Password Or Fill your password");
					return "login";
				}
			}else {
				request.setAttribute("error", "Invalid Email");
				return "login";
			}
		}else {
			request.setAttribute("error", "Fill your email first");
			return "login";
		}
	}
}
