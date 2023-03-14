using System.ComponentModel.DataAnnotations;
namespace ChefsnDishes.Models;

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
            
        if(dt >= DateTime.Now)
            return new ValidationResult("Date must be in the past");

        return ValidationResult.Success;
    }
}