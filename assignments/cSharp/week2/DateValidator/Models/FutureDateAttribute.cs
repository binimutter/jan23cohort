#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace DateValidator.Models;

public class FutureDateAttribute : ValidationAttribute
{
    protected override ValidationResult IsValid(object value, ValidationContext validationContext)
    {
        // You first may want to unbox "value" here and cast to to a DateTime variable!
        double diff = (DateTime.Now - (DateTime)value).TotalDays;
        if (diff < 0)
        {
            return new ValidationResult("No future dates allowed!");
        }
        else
        {
            return ValidationResult.Success;
        }
    }
}