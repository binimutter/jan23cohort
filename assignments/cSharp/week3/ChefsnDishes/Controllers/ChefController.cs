using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ChefsnDishes.Models;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;

namespace ChefsnDishes.Controllers;

public class ChefController : Controller 
{

    private MyContext db;  // or use _context instead of db (Make sure this matches on all controller files)
    
    public ChefController(MyContext context)
    {
        db = context; // if you use _context above use it here too (Make sure this matches on all controller files)
    }
    
    // Recommend routeName and FunctionName be the same
    
    [HttpGet("/chef/dashboard")]
    public IActionResult Dashboard() {
        List<Chef> allChefs = db.Chefs
            .Include(d => d.AllDishes)
            .ToList();
        return View("Dashboard", allChefs);
    }
    [HttpGet("/chef/addChef")]
    public IActionResult AddChef() {
        return View("AddChef");
    }
    [HttpPost("/chef/createChef")]
    public IActionResult CreateChef(Chef c) {
        if (ModelState.IsValid) {
            db.Chefs.Add(c);
            db.SaveChanges();
            return Redirect("Dashboard");
        }
        return View("AddChef");
    }
    
}