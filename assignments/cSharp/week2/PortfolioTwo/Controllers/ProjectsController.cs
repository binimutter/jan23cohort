using Microsoft.AspNetCore.Mvc;
namespace PortfolioTwo.Controllers;
public class ProjectsController : Controller
{
    [HttpGet("projects")]
    public ViewResult Projects()
    {
        return View();
    }

}