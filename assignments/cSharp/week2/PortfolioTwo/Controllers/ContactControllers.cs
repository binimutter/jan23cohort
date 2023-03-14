using Microsoft.AspNetCore.Mvc;
namespace PortfolioTwo.Controllers;
public class ContactController : Controller
{
    [HttpGet("contact")]
    public ViewResult Contact()
    {
        return View();
    }
}