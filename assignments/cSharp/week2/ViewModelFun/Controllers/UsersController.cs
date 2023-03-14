using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ViewModelFun.Models;

namespace ViewModelFun.Controllers;

public class UsersController : Controller
{

    [HttpGet("users")]
    public IActionResult Users()
    {
        List<User> users = new List<User>();
        users.Add(new User("Ubin"));
        users.Add(new User("Adriana"));
        users.Add(new User("Mar'Kebta"));
        users.Add(new User("Kaitlyn"));
        users.Add(new User("Brianna"));

        return View(users);
    }

}