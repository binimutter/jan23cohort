#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace CRUD.Models;

public class Tune {
    [Key]
    public int TuneId {get; set;}
    [Required]
    public string TuneName {get; set;}
    [Required]
    public string TuneImg {get; set;}
    [Required]
    public string Owner {get; set;} = "Ubin";
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;
}