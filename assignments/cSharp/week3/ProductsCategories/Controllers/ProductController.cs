using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using ProductsCategories.Models;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;

namespace ProductsCategories.Controllers;

public class ProductController : Controller
{
    private MyContext db;         
    public UserController(MyContext context)    
    {        
        db = context;    
    }

    [HttpGet("")]
    public IActionResult Index()
    {
        return View("All");
    }
}