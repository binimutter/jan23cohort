#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace SweetTea.Models;

public class UserTeaLike
{
    [Key]
    public int UserTeaLikeId { get; set; }
    public int UserId { get; set; }
    public User? User { get; set; }
    public int TeaId { get; set; }
    public Tea? Tea { get; set; }
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;
}