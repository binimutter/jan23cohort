#pragma warning disable CS8618
// We can disable our warnings safely because we know the framework will assign non-null values 
// when it constructs this class for us.

using System.ComponentModel.DataAnnotations;
namespace ProductsCategories.Models;

public class Product
{
    [Key]
    public int ProductId { get; set; }

    [Required]
    [MinLength(2, ErrorMessage = "must be at least 2 characters.")]
    public string Name { get; set; }

    [Required]
    [MinLength(10, ErrorMessage = "must be at least 10 characters.")]
    public string Description { get; set; }

    [Required]
    public double Price { get; set; }
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public int CategoryId { get; set; }
    public Category? Category { get; set; }

    public List<Association> Categories { get; set; } = new List<Association>();
}