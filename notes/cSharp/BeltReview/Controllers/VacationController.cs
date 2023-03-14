using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using BeltReview.Models;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;

namespace BeltReview.Controllers;

public class VacationController : Controller
{
    private MyContext db;         
    public VacationController(MyContext context)    
    {        
        db = context;    
    }

    [LoginCheck]
    [HttpGet("/vacations")]
    public IActionResult All()
    {
        List<Vacation> vacations = db.Vacations.Include(v => v.Creator).Include(v => v.Vacationers).ToList();
        return View("All", vacations);
    }

    [LoginCheck]
    [HttpGet("/vacations/new")]
    public IActionResult New()
    {
        return View("New");
    }

    [LoginCheck]
    [HttpPost("/vacations/create")]
    public IActionResult Create(Vacation newVacation)
    {
        if (!ModelState.IsValid)
        {
            return View("New");
        }

        newVacation.UserId = (int)HttpContext.Session.GetInt32("UUID");

        db.Vacations.Add(newVacation);

        db.SaveChanges();

        return RedirectToAction("All");
        // same as redirect above:
        // return Redirect("/posts");
    }

    [LoginCheck]
    [HttpGet("/vacations/{id}")]
    public IActionResult ViewOne(int id)
    {
        Vacation? vacation = db.Vacations.Include(v => v.Creator).Include(v => v.Vacationers).ThenInclude(vacationer => vacationer.User).FirstOrDefault(v => v.VacationId == id);
        if (vacation == null) {
            return RedirectToAction("All");
        }

        return View("ViewOne", vacation);
    }

    [LoginCheck]
    [HttpGet("/vacations/{id}/edit")]
    public IActionResult Edit (int id) {
        Vacation? vacation = db.Vacations.FirstOrDefault(v => v.VacationId == id);
        if (vacation == null) {
            return RedirectToAction("All");
        }

        return View("Edit", vacation);
    }

    [LoginCheck]
    [HttpPost("/vacations/{id}/update")]
    public IActionResult UpdateVacation(int id, Vacation editedVacation)
    {
        if (!ModelState.IsValid)
        {
            return Edit(id);
        }

        Vacation? dbVacation = db.Vacations.FirstOrDefault(v => v.VacationId == id);
        if(dbVacation == null) {
            return RedirectToAction("All");
        }

        dbVacation.Destination = editedVacation.Destination;
        dbVacation.Description = editedVacation.Description;
        dbVacation.Summer = editedVacation.Summer;
        dbVacation.Spring = editedVacation.Spring;
        dbVacation.Winter = editedVacation.Winter;
        dbVacation.Fall = editedVacation.Fall;
        dbVacation.UpdatedAt = DateTime.Now;

        db.Vacations.Update(dbVacation);
        db.SaveChanges();

        return RedirectToAction("ViewOne", new { id = id });
    }

    [LoginCheck]
    [HttpPost("/vacations/{id}/delete")]
    public IActionResult DeleteVacation(int id)
    {
        Vacation? vacation = db.Vacations.FirstOrDefault(v => v.VacationId == id);
        if(vacation != null) {
            db.Vacations.Remove(vacation);
            db.SaveChanges();
        }

        return RedirectToAction("All");
    }

    [LoginCheck]
    [HttpPost("/vacations/{id}/signup")]
    public IActionResult Signup(int id)
    {
        UserVacationSignup? existingSignup = db.UserVacationSignups.FirstOrDefault(uvs => uvs.UserId == HttpContext.Session.GetInt32("UUID") && uvs.VacationId == id);
        
        if (existingSignup == null) {
            UserVacationSignup newSignup = new UserVacationSignup()
            {
                UserId = (int)HttpContext.Session.GetInt32("UUID"),
                VacationId = id
            };
            db.UserVacationSignups.Add(newSignup);
        }
        else
        {
            db.UserVacationSignups.Remove(existingSignup);
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