using Microsoft.AspNetCore.Mvc;
using DojoSurveyValidation.Models;

namespace DojoSurveyValidation.Controllers;
public class SurveyController : Controller
{
    
    [HttpGet("")]
    public IActionResult Index()
    {
        return View();
    }

    [HttpPost("survey")]
    public IActionResult Submission(Survey entry)
    {
        if (ModelState.IsValid)
        {    
            return View("Result", entry);
        }
        else
        {    
            return View("Index");
        }
    }
}