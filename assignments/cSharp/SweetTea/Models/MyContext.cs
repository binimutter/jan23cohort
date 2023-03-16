#pragma warning disable CS8618

using Microsoft.EntityFrameworkCore;
namespace SweetTea.Models;

public class MyContext : DbContext 
{    
    public MyContext(DbContextOptions options) : base(options) { }    

    public DbSet<User> Users { get; set; }
    public DbSet<Tea> Teas { get; set; }
    public DbSet<UserTeaLike> UserTeaLikes { get; set; }

}