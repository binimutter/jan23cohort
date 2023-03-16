using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using SweetTea.Models;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;

namespace SweetTea.Controllers;

public class TeaController : Controller
{
    private MyContext db;         
    public TeaController(MyContext context)    
    {        
        db = context;    
    }

    [LoginCheck]
    [HttpGet("/teas")]
    public IActionResult All()
    {
        List<Tea> teas = db.Teas.Include(t => t.Creator).Include(t => t.Likes).OrderByDescending(t => t.UpdatedAt).ToList();
        return View("All", teas);
    }

    [LoginCheck]
    [HttpGet("/teas/new")]
    public IActionResult New()
    {
        return View("New");
    }

    [LoginCheck]
    [HttpPost("/teas/create")]
    public IActionResult Create(Tea newTea)
    {
        if (!ModelState.IsValid)
        {
            return View("New");
        }

        newTea.UserId = (int)HttpContext.Session.GetInt32("UUID");

        db.Teas.Add(newTea);

        db.SaveChanges();

        return RedirectToAction("All");
    }

    [LoginCheck]
    [HttpGet("/teas/{id}")]
    public IActionResult ViewOne(int id)
    {
        Tea? tea = db.Teas.Include(t => t.Creator).Include(t => t.Likes).ThenInclude(rating => rating.User).FirstOrDefault(t => t.TeaId == id);
        if (tea == null) {
            return RedirectToAction("All");
        }

        return View("ViewOne", tea);
    }

    [LoginCheck]
    [HttpGet("/teas/{id}/edit")]
    public IActionResult Edit (int id) {
        Tea? tea = db.Teas.FirstOrDefault(t => t.TeaId == id);
        if (tea == null) {
            return RedirectToAction("All");
        }

        return View("Edit", tea);
    }

    [LoginCheck]
    [HttpPost("/teas/{id}/update")]
    public IActionResult UpdateTea(int id, Tea editedTea)
    {
        if (!ModelState.IsValid)
        {
            return Edit(id);
        }

        Tea? dbTea = db.Teas.FirstOrDefault(t => t.TeaId == id);
        if (dbTea == null) {
            return RedirectToAction("All");
        }

        dbTea.Name = editedTea.Name;
        dbTea.Company = editedTea.Company;
        dbTea.Image = editedTea.Image;
        dbTea.Type = editedTea.Type;
        dbTea.Flavor = editedTea.Flavor;
        dbTea.CaffeineLevel = editedTea.CaffeineLevel;
        dbTea.Price = editedTea.Price;
        dbTea.Ingredients = editedTea.Ingredients;
        dbTea.Instructions = editedTea.Instructions;
        dbTea.UpdatedAt = DateTime.Now;

        db.Teas.Update(dbTea);
        db.SaveChanges();

        return RedirectToAction("ViewOne", new { id = id });
    }

    [LoginCheck]
    [HttpPost("/teas/{id}/delete")]
    public IActionResult DeleteTea(int id)
    {
        Tea? tea = db.Teas.FirstOrDefault(t => t.TeaId == id);
        if(tea != null) {
            db.Teas.Remove(tea);
            db.SaveChanges();
        }

        return RedirectToAction("All");
    }

    [LoginCheck]
    [HttpPost("/teas/{id}/like")]
    public IActionResult Like(int id)
    {
        UserTeaLike? existingLike = db.UserTeaLikes.FirstOrDefault(utl => utl.UserId == HttpContext.Session.GetInt32("UUID") && utl.TeaId == id);
        
        if (existingLike == null) {
            UserTeaLike newLike = new UserTeaLike()
            {
                UserId = (int)HttpContext.Session.GetInt32("UUID"),
                TeaId = id
            };
            db.UserTeaLikes.Add(newLike);
        }
        else
        {
            db.UserTeaLikes.Remove(existingLike);
        }
        db.SaveChanges();
        return RedirectToAction("All");
    }

    [LoginCheck]
    [HttpPost("/teas/{id}/cart/add")]
    public IActionResult AddToCart(int id, Tea addedTea)
    {

        Tea? dbTea = db.Teas.FirstOrDefault(t => t.TeaId == id);
        if (dbTea == null) {
            return RedirectToAction("All");
            Console.BackgroundColor = ConsoleColor.Black;
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("FAIL.");
        }

        dbTea.AddToCart = true;

        db.Teas.Update(dbTea);
        db.SaveChanges();

        return RedirectToAction("All");
    }

    [LoginCheck]
    [HttpPost("/teas/{id}/cart/delete")]
    public IActionResult RemoveFromCart(int id, Tea removedTea)
    {

        Tea? dbTea = db.Teas.FirstOrDefault(t => t.TeaId == id);
        if (dbTea == null) {
            return RedirectToAction("All");
            Console.BackgroundColor = ConsoleColor.Black;
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("FAIL.");
        }

        dbTea.AddToCart = false;

        db.Teas.Update(dbTea);
        db.SaveChanges();

        return RedirectToAction("ViewCart");
    }

    [LoginCheck]
    [HttpGet("/teas/cart")]
    public IActionResult ViewCart()
    {
        List<Tea> TeasInCart = db.Teas.Where(t => t.AddToCart == true).ToList();
        return View("Cart", TeasInCart);
    }

    [LoginCheck]
    [HttpPost("/teas/{id}/like/viewOne")]
    public IActionResult LikeOnOne(int id)
    {
        UserTeaLike? existingLike = db.UserTeaLikes.FirstOrDefault(utl => utl.UserId == HttpContext.Session.GetInt32("UUID") && utl.TeaId == id);
        
        if (existingLike == null) {
            UserTeaLike newLike = new UserTeaLike()
            {
                UserId = (int)HttpContext.Session.GetInt32("UUID"),
                TeaId = id
            };
            db.UserTeaLikes.Add(newLike);
        }
        else
        {
            db.UserTeaLikes.Remove(existingLike);
        }
        db.SaveChanges();
        return RedirectToAction("ViewOne", new { id = id });
    }

    [LoginCheck]
    [HttpGet("/teas/checkout")]
    public IActionResult Checkout()
    {
        return View("Checkout");
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