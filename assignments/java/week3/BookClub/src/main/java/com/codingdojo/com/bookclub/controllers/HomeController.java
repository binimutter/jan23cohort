package com.codingdojo.com.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.com.bookclub.models.Book;
import com.codingdojo.com.bookclub.models.LoginUser;
import com.codingdojo.com.bookclub.models.User;
import com.codingdojo.com.bookclub.services.BookServ;
import com.codingdojo.com.bookclub.services.UserServ;

@Controller
public class HomeController {

	@Autowired
	private UserServ userServ;
	
	@Autowired
	private BookServ bookServ;
	
	// ==========================
    //      MAIN FUNCTIONS
    // ==========================
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/logReg")
	public String logReg(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/dashboard";
		} else {
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());

		return "logReg.jsp";
		}
	}
		
    // ==========================
    //      LOGREG FUNCTIONS
    // ==========================
	
   // Create User Process
   @PostMapping("/register")
   public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
   	userServ.register(newUser, result);
       if(result.hasErrors()) {
           model.addAttribute("newLogin", new LoginUser());
           return "logReg.jsp";
       }
       session.setAttribute("user_id", newUser.getId());
       return "redirect:/dashboard";
   }
   
   // Login User Process
   @PostMapping("/login")
   public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
       User user = userServ.login(newLogin, result);
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "logReg.jsp";
       }
       session.setAttribute("user_id", user.getId());
       return "redirect:/dashboard";
   }
   
   // Logout User
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
    // ==========================
    //      BOOK FUNCTIONS
    // ==========================
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, @ModelAttribute("book") Book book, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/logReg";
		} else {
		model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
		model.addAttribute("allBooks", bookServ.getAll());
		return "dashboard.jsp";
		}
	}
	
	@GetMapping("/addBook")
	public String addBook(HttpSession session, @ModelAttribute("saveBookForm") Book book, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/logReg";
		} else {
		return "addBook.jsp";
		}
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@Valid @ModelAttribute("saveBookForm") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		} else {
			bookServ.saveOne(book);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("book/{id}/view")
	public String viewBook(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("book") Book book, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/logReg";
		} else {
		model.addAttribute("theBook", bookServ.getOne(id));
		return "viewBook.jsp";
		}
	}
	
	@GetMapping("book/{id}/edit")
	public String editBook(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("editBookForm") Book book, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/logReg";
		} else {
		model.addAttribute("theBook", bookServ.getOne(id));
		return "editBook.jsp";
		}
	}
	@PutMapping("book/{id}/update")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("editBookForm") Book editBook, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("theBook", bookServ.getOne(id));
			return "editBook.jsp";
		} else {
			bookServ.updateOne(editBook);
			return "redirect:/book/{id}/view";
		}
	}
	
	@GetMapping("book/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.deleteOne(id);
		return "redirect:/dashboard";
	}
}
