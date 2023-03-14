using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ViewModelFun.Models;

namespace ViewModelFun.Controllers;

public class NumbersController : Controller
{

    [HttpGet("numbers")]
    public IActionResult Numbers()
    {
        int[] numbers = new int[] {
            1,
            2,
            3,
            10,
            43,
            5
        };
        return View(numbers);
    }

}
