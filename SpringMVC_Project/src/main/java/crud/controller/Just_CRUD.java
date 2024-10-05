package crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Repository.BookRepo;
import Repository.StudentRepo;
import crud.model.BookBean;
import crud.model.StudentBean;

@Controller
@RequestMapping(value="/user",method=RequestMethod.GET)
public class Just_CRUD {
	
	@Autowired
	private StudentRepo studentrepo;
	
	@RequestMapping("/register")
	public ModelAndView test() {
		StudentBean bean=new StudentBean();
		ModelAndView mv=new ModelAndView("create","userInfo",bean);
		
		return mv;
	}
	@RequestMapping(value="/create",method= {RequestMethod.POST})
	public String create(@ModelAttribute("userInfo")StudentBean bean,HttpServletRequest request,Model m) {
		if(bean.getName()!=null||bean.getEmail()!=null||bean.getPassword()!=null||bean.getRole()!=null) {
			
			int i=studentrepo.createStudent(bean);
			if(i>0) {
				m.addAttribute("beanForLogin", new StudentBean());
				return "login";
			}else {
	        	request.setAttribute("error", "Creating your account failed");
				return "create";
			}
		}else {
			request.setAttribute("error", "Fill all your info!");
			return "create";
		}
	}
	@RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute("beanForLogin")StudentBean bean,HttpServletRequest request) {
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
	@RequestMapping(value="/showBook",method=RequestMethod.GET)
	public String showBooks(Model m) {
		BookRepo repo=new BookRepo();
		List<BookBean> booklist=repo.showBooks();
		m.addAttribute("bookList",booklist);
//		
//		m.addAttribute("bookToEdit",beantoEdit);
		return "booklist";
	}
	@RequestMapping(value="/showbooById",method=RequestMethod.GET)
	public String showbookById(HttpServletRequest request,Model model) {
		int id=Integer.parseInt(request.getParameter("id"));
		BookRepo repo=new BookRepo();
		BookBean bean=repo.showBookById(id);
		model.addAttribute("book", bean);
		BookBean beanToEdit=new BookBean();
		model.addAttribute("beanToEdit", beanToEdit);
		return "edit";
	}
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateBook(@ModelAttribute("beanToEdit") BookBean bean,HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		BookRepo repo=new BookRepo();
		int i=repo.updateBook(bean, id);
		if(i>0) {
			return "redirect:showBook";
		}else {
			return "edit";
		}
		
	}
	
	
}
