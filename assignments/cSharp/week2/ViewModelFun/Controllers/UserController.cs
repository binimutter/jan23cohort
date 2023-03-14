using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ViewModelFun.Models;

namespace ViewModelFun.Controllers;

public class UserController : Controller
{

    [HttpGet("user")]
    public IActionResult User()
    {
        User a = new User("Ubin Jung");
        return View(a);
    }

}
