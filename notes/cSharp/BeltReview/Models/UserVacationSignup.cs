#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace BeltReview.Models;

public class UserVacationSignup
{
    [Key]
    public int UserVacationSignupId { get; set; }
    public int UserId { get; set; }
    public User? User { get; set; }
    public int VacationId { get; set; }
    public Vacation? Vacation { get; set; }
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;
}