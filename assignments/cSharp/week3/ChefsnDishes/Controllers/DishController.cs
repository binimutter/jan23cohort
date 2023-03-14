using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ChefsnDishes.Models;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;

namespace ChefsnDishes.Controllers;

public class DishController : Controller 
{

    private MyContext db;  // or use _context instead of db (Make sure this matches on all controller files)
    
    public DishController(MyContext context)
    {
        db = context; // if you use _context above use it here too (Make sure this matches on all controller files)
    }
    
    // Recommend routeName and FunctionName be the same
    
    [HttpGet("/dish/dashboard")]
    public IActionResult Dashboard() {
        List<Dish> allDishes = db.Dishes
            .Include(c => c.ChefName)
            .ToList();
            return View("Dashboard", allDishes);
    }
    [HttpGet("/dish/addDish")]
    public IActionResult AddDish() {
        ViewBag.Chefs = db.Chefs.ToList();
        // Console.WriteLine(new string('=', 10));
        return View("AddDish");
    }
    [HttpPost("/dish/createDish")]
    public IActionResult CreateDish(Dish d) {
        if (ModelState.IsValid) {
            db.Dishes.Add(d);
            db.SaveChanges();
            return Redirect("Dashboard");
        }
        return View("AddDish");
    }
    
}