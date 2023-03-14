using Microsoft.AspNetCore.Mvc;
namespace TimeDisplay.Controllers;
public class HomeController : Controller
{
    [HttpGet]
    [Route("")]
    public ViewResult Index()
    {
        return View();
    }
}