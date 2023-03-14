#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace DojoSurveyValidation.Models;

public class Survey 
{
    [Required(ErrorMessage="Name is required!")]
    [MinLength(2, ErrorMessage="Name must be at least 2 characters in length.")]
    public string Name {get; set;}

    [Required(ErrorMessage = "Location is required!")]
    public string Location {get; set;}

    [Required(ErrorMessage = "Favorite Language is required!")]
    public string Language {get; set;}
    
    [MinLength(20, ErrorMessage = "Comment is not required, but if included, must be more than 20 characters in length.")]
    public string? Comment {get; set;}

}