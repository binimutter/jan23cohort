using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using CRUD.Models;

namespace CRUD.Controllers;

public class SquishyController : Controller
{
    private MyContext db;

    public SquishyController(MyContext context)
    {
        db = context;
    }
    [HttpGet("/squishy/allsquishys")]
    public IActionResult AllSquishys() {
        List<Squishy> allSquishys = db.Squishys.ToList();
        return View("AllSquishys", allSquishys);
    }
    [HttpGet("/squishy/addSquishy")]
    public IActionResult AddSquishy() {
        return View();
    }
    [HttpPost("/squishy/createSquishy")]
    public IActionResult CreateSquishy(Squishy s) {
        if (ModelState.IsValid) {
            db.Squishys.Add(s);
            db.SaveChanges();
            Console.WriteLine(s.SquishyId);
            return Redirect("/squishy/allSquishys");
            // we would want to use ViewBag if we were to say "You have successfully added a new squishy after submit"
        } else {
            return View("AddSquishy");
        }
    }
}
