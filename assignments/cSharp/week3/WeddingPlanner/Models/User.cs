#pragma warning disable CS8618 

using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace WeddingPlanner.Models;

public class User
{
    [Key] // denotes PK, not needed if named ModelNameId
    public int UserId { get; set; }

    [Required(ErrorMessage = "is required.")]
    [Display(Name = "First Name")]
    public string FirstName { get; set; }

    [Required(ErrorMessage = "is required.")]
    [Display(Name = "Last Name")]
    public string LastName { get; set; }

    [Required(ErrorMessage = "is required.")]
    [EmailAddress]
    [UniqueEmail]
    public string Email { get; set; }

    [Required(ErrorMessage = "is required.")]
    [MinLength(8, ErrorMessage = "must be at least 8 characters.")]
    [DataType(DataType.Password)] // auto fills input type attr
    public string Password { get; set; }

    [NotMapped] // don't add column to database
    [Display(Name = "PW Confirm")]
    [DataType(DataType.Password)]
    [Compare("Password", ErrorMessage = "doesn't match password.")]
    public string PasswordConfirm { get; set; }

    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public string FullName() {
        return FirstName + " " + LastName;
    }

    public List<Wedding> PlannedWeddings { get; set; } = new List<Wedding>();

    public List<UserWeddingSignup> Weddings { get; set; } = new List<UserWeddingSignup>();
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
        MyContext db = (MyContext)validationContext.GetService(typeof(MyContext));
        // Check to see if there are any records of this email in our database
        if (db.Users.Any(e => e.Email == value.ToString()))
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