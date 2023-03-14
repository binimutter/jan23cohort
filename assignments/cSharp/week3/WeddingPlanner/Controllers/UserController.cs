using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using WeddingPlanner.Models;
using Microsoft.AspNetCore.Identity;

namespace WeddingPlanner.Controllers;

public class UserController : Controller
{
    private MyContext db;         
    public UserController(MyContext context)    
    {        
        db = context;    
    }

    [HttpGet("")]
    public IActionResult Index()
    {
        // check if logged in & send user to dashboard
        if (HttpContext.Session.GetInt32("UUID") != null)
        {
            return RedirectToAction("All", "Wedding");
        }
        return View("Index");
    }

    [HttpPost("/register")]
    public IActionResult Register(User newUser)
    {
        if (!ModelState.IsValid)
        {
            return View("Index");
        }

        PasswordHasher<User> hashbrowns = new PasswordHasher<User>();
        newUser.Password = hashbrowns.HashPassword(newUser, newUser.Password);

        db.Users.Add(newUser);
        db.SaveChanges();

        HttpContext.Session.SetInt32("UUID", newUser.UserId);
        HttpContext.Session.SetString("name", newUser.FirstName);

        return RedirectToAction("All", "Wedding");
    }

    public IActionResult Login(LoginUser userSubmission)
    {
        if(!ModelState.IsValid)
        {
            return View("Index");
        }
        // If initial ModelState is valid, query for a user with the provided email        
        User? userInDb = db.Users.FirstOrDefault(u => u.Email == userSubmission.LoginEmail);        
        // If no user exists with the provided email        
        if(userInDb == null)        
        {            
            // Add an error to ModelState and return to View!            
            ModelState.AddModelError("LoginEmail", "Invalid Email/Password");            
            return View("Index");        
        }   
        // Otherwise, we have a user, now we need to check their password                 
        // Initialize hasher object        
        PasswordHasher<LoginUser> hashbrowns = new PasswordHasher<LoginUser>();                    
        // Verify provided password against hash stored in db        
        var result = hashbrowns.VerifyHashedPassword(userSubmission, userInDb.Password, userSubmission.LoginPassword);                                    // Result can be compared to 0 for failure        
        if(result == 0)        
        {            
            ModelState.AddModelError("LoginEmail", "Invalid Email/Password");            
            return View("Index");         
        } 
        
        // Handle success (this should route to an internal page)  
        HttpContext.Session.SetInt32("UUID", userInDb.UserId);
        HttpContext.Session.SetString("name", userInDb.FirstName);

        return RedirectToAction("All", "Wedding");
    }

    [HttpPost("/logout")]
    public IActionResult Logout()
    {
        HttpContext.Session.Clear();
        return RedirectToAction("Index");
    }
}