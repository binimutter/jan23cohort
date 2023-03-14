// Disabled because we know the framework will assign non-null values when it
// constructs this class for us.
#pragma warning disable CS8618 // Non-nullable field must contain a non-null value when exiting constructor. Consider declaring as nullable.

using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace BeltReview.Models;

public class User
{
    [Key] // denotes PK, not needed if named ModelNameId
    public int UserId { get; set; }

    [Required(ErrorMessage = "is required.")]
    [Display(Name = "Name")]
    public string Name { get; set; }

    [Required(ErrorMessage = "is required.")]
    [EmailAddress]
    [UniqueEmail]
    public string Email { get; set; }

    [Required(ErrorMessage = "is required.")]
    [MinLength(8, ErrorMessage = "must be at least 8 characters.")]
    [DataType(DataType.Password)] // auto fills input type attr
    public string Password { get; set; }

    [NotMapped] // don't add column to database
    [DataType(DataType.Password)]
    [Compare("Password", ErrorMessage = "doesn't match password.")]
    public string PasswordConfirm { get; set; }

    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public List<Vacation> CreatedVacations { get; set; } = new List<Vacation>();

    public List<UserVacationSignup> Vacations { get; set; } = new List<UserVacationSignup>();


}

public class UniqueEmailAttribute : ValidationAttribute
{
    protected override ValidationResult? IsValid(object? value, ValidationContext validationContext)
    {
        // Though we have Required as a validation, sometimes we make it here anyways
        // In which case we must first verify the value is not null before we proceed
        if (value == null)
        {
            // If it was, return the required error
            return new ValidationResult("Email is required!");
        }

        // This will connect us to our database since we are not in our Controller
        MyContext _context = (MyContext)validationContext.GetService(typeof(MyContext));
        // Check to see if there are any records of this email in our database
        if (_context.Users.Any(e => e.Email == value.ToString()))
        {
            // If yes, throw an error
            return new ValidationResult("Email must be unique!");
        }
        else
        {
            // If no, proceed
            return ValidationResult.Success;
        }
    }
}