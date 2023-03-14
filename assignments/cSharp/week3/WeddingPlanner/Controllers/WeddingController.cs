using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using WeddingPlanner.Models;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;

namespace WeddingPlanner.Controllers;

public class WeddingController : Controller
{
    private MyContext db;         
    public WeddingController(MyContext context)    
    {        
        db = context;    
    }

    [LoginCheck]
    [HttpGet("/weddings")]
    public IActionResult All()
    {
        List<Wedding> weddings = db.Weddings.Include(w => w.Creator).Include(w => w.Guests).ToList();
        return View("All", weddings);
    }

    [LoginCheck]
    [HttpGet("/weddings/new")]
    public IActionResult New()
    {
        return View("New");
    }

    [LoginCheck]
    [HttpPost("/weddings/create")]
    public IActionResult Create(Wedding newWedding)
    {
        if (!ModelState.IsValid)
        {
            return View("New");
        }

        newWedding.UserId = (int)HttpContext.Session.GetInt32("UUID");

        db.Weddings.Add(newWedding);

        db.SaveChanges();

        return RedirectToAction("All");
    }

    [LoginCheck]
    [HttpGet("/weddings/{id}")]
    public IActionResult ViewOne(int id)
    {
        Wedding? wedding = db.Weddings.Include(w => w.Creator).Include(w => w.Guests).ThenInclude(guest => guest.User).FirstOrDefault(w => w.WeddingId == id);
        if (wedding == null) {
            return RedirectToAction("All");
        }

        return View("ViewOne", wedding);
    }

    [LoginCheck]
    [HttpGet("/weddings/{id}/edit")]
    public IActionResult Edit (int id) {
        Wedding? wedding = db.Weddings.FirstOrDefault(w => w.WeddingId == id);
        if (wedding == null) {
            return RedirectToAction("All");
        }

        return View("Edit", wedding);
    }

    [LoginCheck]
    [HttpPost("/weddings/{id}/update")]
    public IActionResult UpdateWedding(int id, Wedding editedWedding)
    {
        if (!ModelState.IsValid)
        {
            return Edit(id);
        }

        Wedding? dbWedding = db.Weddings.FirstOrDefault(w => w.WeddingId == id);
        if (dbWedding == null) {
            return RedirectToAction("All");
        }

        dbWedding.WedderOne = editedWedding.WedderOne;
        dbWedding.WedderTwo = editedWedding.WedderTwo;
        dbWedding.Date = editedWedding.Date;
        dbWedding.Address = editedWedding.Address;
        dbWedding.UpdatedAt = DateTime.Now;

        db.Weddings.Update(dbWedding);
        db.SaveChanges();

        return RedirectToAction("ViewOne", new { id = id });
    }

    [LoginCheck]
    [HttpPost("/wedding/{id}/delete")]
    public IActionResult DeleteWedding(int id)
    {
        Wedding? wedding = db.Weddings.FirstOrDefault(w => w.WeddingId == id);
        if(wedding != null) {
            db.Weddings.Remove(wedding);
            db.SaveChanges();
        }

        return RedirectToAction("All");
    }

    [LoginCheck]
    [HttpPost("/weddings/{id}/rsvp")]
    public IActionResult RSVP(int id)
    {
        UserWeddingSignup? existingSignup = db.UserWeddingSignups.FirstOrDefault(uws => uws.UserId == HttpContext.Session.GetInt32("UUID") && uws.WeddingId == id);
        
        if (existingSignup == null) {
            UserWeddingSignup newSignup = new UserWeddingSignup()
            {
                UserId = (int)HttpContext.Session.GetInt32("UUID"),
                WeddingId = id
            };
            db.UserWeddingSignups.Add(newSignup);
        }
        else
        {
            db.UserWeddingSignups.Remove(existingSignup);
        }
        db.SaveChanges();
        return RedirectToAction("All");
    }
}

public class LoginCheckAttribute : ActionFilterAttribute
{
    public override void OnActionExecuting(ActionExecutingContext context)
    {
        // Find the session, but remember it may be null so we need int?
        int? userId = context.HttpContext.Session.GetInt32("UUID");
        // Check to see if we got back null
        if(userId == null)
        {
            // Redirect to the Index page if there was nothing in session
            // "Home" here is referring to "HomeController", you can use any controller that is appropriate here
            context.Result = new RedirectToActionResult("Index", "Home", null);
        }
    }
}