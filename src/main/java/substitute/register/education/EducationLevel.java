package substitute.register.education;

public enum EducationLevel {
   HIGHSCHOOL("High school"),
   FOLKHIGHSCHOOL( "Folk high school"),
   PRISONSCHOOL("Prison school"),
   VOCATIONALSCHOOL("Vocational School"),
   HIGHEREDUCATION("1-2 years high. edu"),
   BACHELOR("Bachelor"),
   FOURYEAR("4 year college / university"),
   MASTER("Master"),
   PHD("Phd"),
   OTHER("Other");
   private String description;

   EducationLevel (String description) {
      this.description = description;
   }

   public String getDescription() {
      return this.description;
   }

}
