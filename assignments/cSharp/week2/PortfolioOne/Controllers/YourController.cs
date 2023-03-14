using Microsoft.AspNetCore.Mvc;
namespace ProjectName.Controllers;
public class MyController : Controller
{
    // Route declaration Option A
    // This will go to "localhost:5XXX"
    [HttpGet]
    [Route("")]
    public string Index()
    {
        return "This is my Index!";
    }
    // Route declaration Option B
    // This will go to "localhost:5XXX/projects"
    [HttpGet("projects")]
    public string Projects()
    {
        return "These are my projects";
    }

    [HttpGet("contact")]
    public string Contact()
    {
        return "This is my Contact!";
    }

    // Post request example
    // This will go to "localhost:5XXX/submission"
    // [HttpPost]
    // [Route("submission")]
    // Don't worry about what the form is doing for now. We'll get to those soon!
    // public string FormSubmission(string formInput)
    // {
    //     // Logic for post request here
    // }
    // [HttpGet("greet/{name}")]
    // public string Greet(string name)
    // {
    //     return $"Hello {name}!";
    // }

    // [HttpGet("greet/{name}/{time}")]
    // public string GreetTime(string name, string time)
    // {
    //     return $"Good {time}, {name}!";
    // }
}