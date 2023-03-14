using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace ChefsnDishes.Migrations
{
    public partial class SecondMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Chef",
                table: "Dishes");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "Chef",
                table: "Dishes",
                type: "int",
                nullable: false,
                defaultValue: 0);
        }
    }
}
