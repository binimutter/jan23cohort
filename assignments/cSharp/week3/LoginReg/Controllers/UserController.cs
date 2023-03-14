using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using LoginReg.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc.Filters;

namespace LoginReg.Controllers;

public class UserController : Controller 
{

    private MyContext db;  // or use _context instead of db (Make sure this matches on all controller files)
    
    public UserController(MyContext context)
    {
        db = context; // if you use _context above use it here too (Make sure this matches on all controller files)
    }
    
    // Recommend routeName and FunctionName be the same
    
    [HttpGet("")]
    public IActionResult Index()
    {
        return View("Index");
    }
    [SessionCheck]
    [HttpGet("success")]
    public IActionResult Success()
    {
        return View("Success");
    }
    [HttpPost("/register")]
    public IActionResult Register(User newUser) {
        if(!ModelState.IsValid) {
            return View("Index");
        } else {
            PasswordHasher<User> hash = new PasswordHasher<User>(); // This creates a new instance of the password hasher so that we can use it on the next line
            newUser.Password = hash.HashPassword(newUser, newUser.Password);
            // let newUser.Password equal a hashed version of the password
            db.Users.Add(newUser);
            db.SaveChanges();
            HttpContext.Session.SetInt32("UserId", newUser.UserId);
            HttpContext.Session.SetString("FirstName", newUser.FirstName);
            return RedirectToAction("Success");
        }
    }
    [HttpPost("/login")]
    public IActionResult Login(LoginUser getUser) {
        if(!ModelState.IsValid) {
            return View("Index");
        } else {
            User? userInDb = db.Users.FirstOrDefault(u => u.Email == getUser.LoginEmail);
            // Please go to db and see if there is an email that matched the email coming from the form
            if(userInDb == null) {
                // If email is not in database go back to Index with new error for loginemail
                ModelState.AddModelError("LoginEmail", "Invalid Email");
                return View("Index");
            } else {
                PasswordHasher<LoginUser> hash = new PasswordHasher<LoginUser>();
                var result = hash.VerifyHashedPassword(getUser, userInDb.Password, getUser.LoginPassword);
                // has the getUser password and see if they match will give bool type response
                if(result == 0)  { // meaning not a match
                    ModelState.AddModelError("LoginPassword", "Invalid Password");
                    return View("Index");
                } else {
                    HttpContext.Session.SetInt32("UserId", userInDb.UserId);
                    HttpContext.Session.SetString("FirstName", userInDb.FirstName);
                    return RedirectToAction("Success");
                }
            }   
        }
    }


    [HttpPost("/logout")]
    public IActionResult Logout()
    {
        HttpContext.Session.Clear();
        return RedirectToAction("Index");
    }

     // Name this anything you want with the word "Attribute" at the end
    public class SessionCheckAttribute : ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            // Find the session, but remember it may be null so we need int?
            int? userId = context.HttpContext.Session.GetInt32("UserId");
            // Check to see if we got back null
            if (userId == null)
            {
                // Redirect to the Index page if there was nothing in session
                // "Home" here is referring to "HomeController", you can use any controller that is appropriate here
                context.Result = new RedirectToActionResult("Index", "User", null);
            }
        }
    }
}