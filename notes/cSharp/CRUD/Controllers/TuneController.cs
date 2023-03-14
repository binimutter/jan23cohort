using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using CRUD.Models;

namespace CRUD.Controllers;

public class TuneController : Controller
{
    private MyContext db;

    public TuneController(MyContext context)
    {
        db = context;
    }
    [HttpGet("/tune/allTunes")]
    public IActionResult AllTunes() {
        List<Tune> allTunes = db.Tunes.ToList();
        return View("AllTunes", allTunes);
    }
    [HttpGet("/tune/addTune")]
    public IActionResult AddTune() {
        return View();
    }
    [HttpPost("/tune/createTune")]
    public IActionResult CreateTune(Tune t) {
        if (ModelState.IsValid) {
            db.Tunes.Add(t);
            db.SaveChanges();
            Console.WriteLine(t.TuneId);
            return Redirect("/tune/allTunes");
        } else {
            return View("AddTune");
        }
    }

}
