#pragma warning disable CS8618

using System.ComponentModel.DataAnnotations;
namespace WeddingPlanner.Models;

public class Wedding
{
    [Key]
    public int WeddingId { get; set; }

    [Required]
    [MinLength(2, ErrorMessage = "must be at least 2 characters.")]
    [Display(Name = "Wedder One")]
    public string WedderOne { get; set; }

    [Required]
    [MinLength(2, ErrorMessage = "must be at least 2 characters.")]
    [Display(Name = "Wedder Two")]
    public string WedderTwo { get; set; }

    [FutureDate]
    [Required]
    [DataType(DataType.Date)]
    public DateTime Date { get; set; }

    [Required]
    [MinLength(10, ErrorMessage = "must be at least 10 characters.")]
    public string Address { get; set; }

    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public int UserId { get; set; }
    public User? Creator { get; set; }

    public List<UserWeddingSignup> Guests { get; set; } = new List<UserWeddingSignup>();

}

public class FutureDateAttribute : ValidationAttribute
{
    protected override ValidationResult IsValid(object value, ValidationContext validationContext)
    {
        DateTime dt;
        // safely unbox value to DateTime
        if(value is DateTime)
            dt = (DateTime)value;
        else
            return new ValidationResult("Invalid datetime");
            
        if(dt <= DateTime.Now)
            return new ValidationResult("Date must be in the future");

        return ValidationResult.Success;
    }
}