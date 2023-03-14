#pragma warning disable CS8618

using System.ComponentModel.DataAnnotations;
namespace SweetTea.Models;

public class Tea
{
    [Key]
    public int TeaId { get; set; }

    [Required]
    [MinLength(2, ErrorMessage = "must be at least 2 characters.")]
    public string Name { get; set; }

    [Required]
    public string Company { get; set; }

    [Required]
    public string Type { get; set; }

    [Required]
    public string Flavor { get; set; }

    [Required]
    [Display(Name = "Caffeine Level")]
    [Range(1, 5)]
    public int? CaffeineLevel { get; set; }

    [Required]
    [MinLength(10, ErrorMessage = "must be at least 10 characters.")]
    [Display(Name = "Image (URL_format please)")]
    public string Image { get; set; }

    [Required]
    public double? Price { get; set; }

    [Display(Name = "Main Ingredients")]
    public string Ingredients {get; set;}
    [Display(Name = "Brewing Instructions")]
    public string Instructions {get; set;}

    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public int UserId { get; set; }
    public User? Creator { get; set; }
    public List<UserTeaLike> Likes { get; set; } = new List<UserTeaLike>();

}