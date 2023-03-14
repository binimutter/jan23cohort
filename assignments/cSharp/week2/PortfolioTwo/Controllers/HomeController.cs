using Microsoft.AspNetCore.Mvc;
namespace PortfolioTwo.Controllers;
public class HomeController : Controller
{
    [HttpGet]
    [Route("")]
    public ViewResult Index()
    {
        return View();
    }
}