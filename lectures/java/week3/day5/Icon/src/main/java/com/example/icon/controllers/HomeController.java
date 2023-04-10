package com.example.icon.controllers;

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

import com.example.icon.model.Category;
import com.example.icon.model.Icon;
import com.example.icon.model.LoginUser;
import com.example.icon.model.User;
import com.example.icon.services.CatServ;
import com.example.icon.services.IconServ;
import com.example.icon.services.UserServ;

@Controller
public class HomeController {

	@Autowired
	private UserServ userServ;
	
	@Autowired
	private IconServ iconServ;
	
	@Autowired
	private CatServ catServ;
	
    // ==========================
    //      MAIN FUNCTIONS
    // ==========================
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        	return "index.jsp";
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
           return "index.jsp";
       }
       session.setAttribute("user_id", newUser.getId());
       return "redirect:/dash";
   }
   
   // Login User Process
   @PostMapping("/login")
   public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
       User user = userServ.login(newLogin, result);
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "index.jsp";
       }
       session.setAttribute("user_id", user.getId());
       return "redirect:/dash";
   }
   
   // Logout User
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
    // ==========================
    //      ICON FUNCTIONS
    // ==========================
	@GetMapping("/dash")
	public String dashboard(HttpSession session, @ModelAttribute("icon") Icon icon, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
		model.addAttribute("allIcons", iconServ.getAll());
		model.addAttribute("allCats", catServ.getAll());
		return "dashboard.jsp";
		}
	}
	
	@GetMapping("/addIcon")
	public String addIcon(HttpSession session, @ModelAttribute("iconForm") Icon icon, Model model) {		
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		return "addIcon.jsp";
		}
	}
	@PostMapping("/createIcon")
	public String createIcon(@Valid @ModelAttribute("iconForm") Icon icon, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addIcon.jsp";
		} else {
			iconServ.create(icon);
			return "redirect:/dash";
		}
	}
	
	@GetMapping("icon/{id}/view")
	public String viewIcon(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("icon") Icon icon, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		model.addAttribute("theIcon", iconServ.getOne(id));
		return "viewIcon.jsp";
		}
	}
	
	@GetMapping("icon/{id}/edit")
	public String editIcon(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("editIconForm") Icon icon, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		model.addAttribute("icon", iconServ.getOne(id));
		return "editIcon.jsp";
		}
	}
	@PutMapping("icon/{id}/update")
	public String updateIcon(@PathVariable("id") Long id, @Valid @ModelAttribute("editIconForm") Icon editIcon, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("theIcon",iconServ.getOne(id));
			return "editIcon.jsp";
		} else {
			iconServ.updateOne(editIcon);
			return "redirect:/icon/{id}/view";
		}
	}
	
	@GetMapping("icon/{id}/delete")
	public String deleteIcon(@PathVariable("id") Long id) {
		iconServ.deleteOne(id);
		return "redirect:/dash";
	}
	
	// ==========================
    //      Category FUNCTIONS
    // ==========================
	@GetMapping("/addCat")
	public String addCat(HttpSession session, @ModelAttribute("catForm") Category cat, Model model) {		
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		return "addCat.jsp";
		}
	}
	@PostMapping("/createCat")
	public String createCat(@Valid @ModelAttribute("catForm") Category cat, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addCat.jsp";
		} else {
			catServ.create(cat);
			return "redirect:/dash";
		}
	}
	
	@GetMapping("cat/{id}/view")
	public String viewCat(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("cat") Category cat, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		model.addAttribute("theCat", catServ.getOne(id));
		return "viewCat.jsp";
		}
	}
	
	@GetMapping("cat/{id}/edit")
	public String editCat(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("editCatForm") Category cat, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		model.addAttribute("cat", catServ.getOne(id));
		return "editCat.jsp";
		}
	}
	@PutMapping("cat/{id}/update")
	public String updateCat(@PathVariable("id") Long id, @Valid @ModelAttribute("editCatForm") Category editCat, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("theCat",catServ.getOne(id));
			return "editcat.jsp";
		} else {
			catServ.updateOne(editCat);
			return "redirect:/cat/{id}/view";
		}
	}
	
	@GetMapping("cat/{id}/delete")
	public String deleteCat(@PathVariable("id") Long id) {
		catServ.deleteOne(id);
		return "redirect:/dash";
	}
	
	// ==========================
    //      Category FUNCTIONS
    // ==========================
	
	
	
	
	
	
	
	
	
}
