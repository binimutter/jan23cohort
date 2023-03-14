using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using CRUDelicious.Models;

namespace CRUDelicious.Controllers;

public class DishController : Controller
{
    private MyContext db;

    public DishController(MyContext context)
    {
        db = context;
    }
    [HttpGet("")] 
    public IActionResult Dashboard() {
        List<Dish> allDishes = db.Dishes.ToList();
        return View("Dashboard", allDishes);
    }

    [HttpGet("dish/{dishId}/view")]
    public IActionResult ViewProject(int dishId) {
        Dish? dish = db.Dishes.FirstOrDefault(dish => dish.DishId == dishId);

        if(dish == null) {
            return RedirectToAction("dashboard");
        } else {
            return View("ViewDish", dish);
        }
    }

    [HttpGet("/dish/addDish")]
    public IActionResult AddDish() {
        return View("addDish");
    }
    [HttpPost("/dish/createDish")]
    public IActionResult CreateDish(Dish d) {
        if (ModelState.IsValid) {
            db.Dishes.Add(d);
            db.SaveChanges();
            Console.WriteLine(d.DishId);
            return Redirect("/");
            // we would want to use ViewBag if we were to say "You have successfully added a new squishy after submit"
        } else {
            return View("AddDish");
        }
    }
    [HttpGet("dish/{dishId}/edit")]
    public IActionResult EditDish(int dishId) {
        Dish? item = db.Dishes.FirstOrDefault(item => item.DishId == dishId);
        if (item == null) {
            return RedirectToAction("dashboard");
        } else {
            return View("EditDish", item);
        }
    }
    [HttpPost("dish/{dishId}/update")]
    public IActionResult UpdateDish(Dish d, int dishId) {
        if(ModelState.IsValid) {
            Dish? item = db.Dishes.FirstOrDefault(item => item.DishId == dishId);
            if(item == null) {
                Console.WriteLine("Id not valid leave edit page");
                return RedirectToAction("dashboard");
            } else {
                item.Name = d.Name;
                item.Chef = d.Chef;
                item.Tastiness = d.Tastiness;
                item.Calories = d.Calories;
                item.Description = d.Description;
                item.UpdatedAt = DateTime.Now;

                db.Dishes.Update(item);
                db.SaveChanges();
                return Redirect("/");
            }
        } else {
            Console.WriteLine("validations failed get outta here");
            return View("EditDish", dishId);
        }
    }
    [HttpGet("dish/{dishId}/delete")]
    public IActionResult DeleteDish(int dishId) {
        Dish? item = db.Dishes.FirstOrDefault(item => item.DishId == dishId);
        if(item != null) {
            db.Dishes.Remove(item);
            db.SaveChanges();
            Console.WriteLine("Entry removed");
        }
        return RedirectToAction("Dashboard");
    }
}
