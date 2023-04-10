package com.example.blackbeltmock.controlers;

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

import com.example.blackbeltmock.models.Category;
import com.example.blackbeltmock.models.LoginUser;
import com.example.blackbeltmock.models.Sticker;
import com.example.blackbeltmock.models.User;
import com.example.blackbeltmock.services.CategoryServ;
import com.example.blackbeltmock.services.StickerServ;
import com.example.blackbeltmock.services.UserServ;

@Controller
public class HomeController {

	@Autowired
	private UserServ userServ;
	
	@Autowired
	private StickerServ stickServ;
	
	@Autowired
	private CategoryServ catServ;
	
	
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
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, @ModelAttribute("stick") Sticker stick, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
			model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
			model.addAttribute("allSticks",stickServ.getAll());
			model.addAttribute("allCats", catServ.getAll());
	        return "dashboard.jsp";
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
       return "redirect:/dashboard";
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
       return "redirect:/dashboard";
   }
   
   // Logout User
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}



    // ==========================
    //      STICKER FUNCTIONS
    // ==========================

	// ADD
	@GetMapping("/addSticker")
	public String addSticker(HttpSession session, @ModelAttribute("stickForm") Sticker stick, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
			model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
			return "addSticker.jsp";
		}
	}

	// CREATE
	@PostMapping("/createSticker")
	public String createSticker(@Valid @ModelAttribute("stickForm") Sticker stick, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
			return "addSticker.jsp";
		} else {
			stickServ.create(stick);
			return "redirect:/dashboard";
		}
	}

	// VIEW ONE - INCLUDES ALL CATEGORIES + FORM TO LIKE AND LINK NEW CATEGORY
	@GetMapping("/sticker/{id}/view")
	public String viewSticker(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("stick") Sticker stick, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
			model.addAttribute("oneStick", stickServ.getOne(id));
			model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
			model.addAttribute("stickCats", stick.getCategorys());
			model.addAttribute("allCats", catServ.getAll());
			return "viewSticker.jsp";
		}

	}

	// EDIT
//	@GetMapping("/sticker/{id}/edit")
//	public String editSticker() {
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/";
//		} else {
//			return "editSticker.jsp";
//		}
//	}

	// UPDATE

	// DELETE


	// ==========================
    //      CATEGORY FUNCTIONS
    // ==========================

	// ADD
	@GetMapping("/addCategory")
	public String addCategory(HttpSession session, @ModelAttribute("catForm") Category cat, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
			model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
			return "addCategory.jsp";
		}
	}

	// CREATE
	@PostMapping("/createCategory")
	public String createCategory(@Valid @ModelAttribute("catForm") Category cat, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
			return "addCategory.jsp";
		} else {
			catServ.create(cat);
			return "redirect:/dashboard";
		}
	}

	// VIEW ONE - INCLUDES ALL STICKERS IN CAT
//	@GetMapping("/category/{id}/view")
//	public String viewCategory() {
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/";
//		} else {
//			return "viewCategory.jsp";
//		}
//	}

	// EDIT
//	@GetMapping("/category/{id}/edit")
//	public String editCategory() {
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/";
//		} else {
//			return "editCategory.jsp";
//		}
//	}

	// UPDATE

	// DELETE

	// ===================================
    //      RELATIONSHIP FUNCTIONS
    // ===================================

	// CREATE CATSTICK RELATIONSIP

	// CREATE USERLIKE RELATIONSHIP

	// UNLIKE

}
