#pragma warning disable CS8618
// We can disable our warnings safely because we know the framework will assign non-null values 
// when it constructs this class for us.

using System.ComponentModel.DataAnnotations;
namespace BeltReview.Models;

public class Vacation
{
    [Key]
    public int VacationId { get; set; }

    [Required]
    [MinLength(2, ErrorMessage = "must be at least 2 characters.")]
    public string Destination { get; set; }

    [Required]
    [MinLength(10, ErrorMessage = "must be at least 10 characters.")]
    public string Description { get; set; }

    public bool Summer { get; set; } = false;
    public bool Spring { get; set; } = false;
    public bool Winter { get; set; } = false;
    public bool Fall { get; set; } = false;

    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public int UserId { get; set; }
    public User? Creator { get; set; }

    public List<UserVacationSignup> Vacationers { get; set; } = new List<UserVacationSignup>();
}