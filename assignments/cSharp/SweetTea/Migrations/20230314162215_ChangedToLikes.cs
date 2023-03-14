using System;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace SweetTea.Migrations
{
    public partial class ChangedToLikes : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "UserTeaRatings");

            migrationBuilder.CreateTable(
                name: "UserTeaLikes",
                columns: table => new
                {
                    UserTeaLikeId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    UserId = table.Column<int>(type: "int", nullable: false),
                    TeaId = table.Column<int>(type: "int", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "datetime(6)", nullable: false),
                    UpdatedAt = table.Column<DateTime>(type: "datetime(6)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_UserTeaLikes", x => x.UserTeaLikeId);
                    table.ForeignKey(
                        name: "FK_UserTeaLikes_Teas_TeaId",
                        column: x => x.TeaId,
                        principalTable: "Teas",
                        principalColumn: "TeaId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_UserTeaLikes_Users_UserId",
                        column: x => x.UserId,
                        principalTable: "Users",
                        principalColumn: "UserId",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateIndex(
                name: "IX_UserTeaLikes_TeaId",
                table: "UserTeaLikes",
                column: "TeaId");

            migrationBuilder.CreateIndex(
                name: "IX_UserTeaLikes_UserId",
                table: "UserTeaLikes",
                column: "UserId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "UserTeaLikes");

            migrationBuilder.CreateTable(
                name: "UserTeaRatings",
                columns: table => new
                {
                    UserTeaRatingId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    TeaId = table.Column<int>(type: "int", nullable: false),
                    UserId = table.Column<int>(type: "int", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "datetime(6)", nullable: false),
                    UpdatedAt = table.Column<DateTime>(type: "datetime(6)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_UserTeaRatings", x => x.UserTeaRatingId);
                    table.ForeignKey(
                        name: "FK_UserTeaRatings_Teas_TeaId",
                        column: x => x.TeaId,
                        principalTable: "Teas",
                        principalColumn: "TeaId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_UserTeaRatings_Users_UserId",
                        column: x => x.UserId,
                        principalTable: "Users",
                        principalColumn: "UserId",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateIndex(
                name: "IX_UserTeaRatings_TeaId",
                table: "UserTeaRatings",
                column: "TeaId");

            migrationBuilder.CreateIndex(
                name: "IX_UserTeaRatings_UserId",
                table: "UserTeaRatings",
                column: "UserId");
        }
    }
}
