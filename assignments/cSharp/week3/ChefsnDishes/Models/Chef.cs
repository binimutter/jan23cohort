#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace ChefsnDishes.Models;

public class Chef {
    [Key]
    public int ChefId {get; set;}

    [Required]
    [Display(Name ="First Name")]
    public string FirstName {get; set;}

    [Required]
    [Display(Name ="Last Name")]
    public string LastName {get; set;}

    [FutureDate]
    [Required]
    [Display(Name ="Date of Birth")]
    [DataType(DataType.Date)]
    public DateTime DateOfBirth { get; set; } 

    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public List<Dish> AllDishes {get;set;} = new List<Dish>();
}