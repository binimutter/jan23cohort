using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using RandomPasscode.Models;

namespace RandomPasscode.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }

    public IActionResult Index()
    {
        HttpContext.Session.SetInt32("pwCounter",1);
        int count = Convert.ToInt32(HttpContext.Session.GetInt32("pwCounter"));
        return View(count);
    }

    [HttpGet("generate")]
    public IActionResult Generate(){
        int count = Convert.ToInt32(HttpContext.Session.GetInt32("pwCounter"));
        count++;
        HttpContext.Session.SetInt32("pwCounter",count);
        return View("Index",count);
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
