using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace SweetTea.Migrations
{
    public partial class ThirdMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<double>(
                name: "Price",
                table: "Teas",
                type: "double",
                nullable: false,
                oldClrType: typeof(float),
                oldType: "float");

            migrationBuilder.AddColumn<string>(
                name: "Instructions",
                table: "Teas",
                type: "longtext",
                nullable: false)
                .Annotation("MySql:CharSet", "utf8mb4");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Instructions",
                table: "Teas");

            migrationBuilder.AlterColumn<float>(
                name: "Price",
                table: "Teas",
                type: "float",
                nullable: false,
                oldClrType: typeof(double),
                oldType: "double");
        }
    }
}
