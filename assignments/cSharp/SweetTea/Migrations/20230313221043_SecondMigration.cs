using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace SweetTea.Migrations
{
    public partial class SecondMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<float>(
                name: "Price",
                table: "Teas",
                type: "float",
                nullable: false,
                oldClrType: typeof(decimal),
                oldType: "decimal(65,30)");

            migrationBuilder.AddColumn<string>(
                name: "Ingredients",
                table: "Teas",
                type: "longtext",
                nullable: false)
                .Annotation("MySql:CharSet", "utf8mb4");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Ingredients",
                table: "Teas");

            migrationBuilder.AlterColumn<decimal>(
                name: "Price",
                table: "Teas",
                type: "decimal(65,30)",
                nullable: false,
                oldClrType: typeof(float),
                oldType: "float");
        }
    }
}
