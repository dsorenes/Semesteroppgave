package substitute.register.education;

public enum EducationLevel {
   SECONDARYSCHOOL("Secondary school"),
   HIGHSCHOOL("High school"),
   FOLKHIGHSCHOOL( "Folk high school"),
   VOCATIONALSCHOOL("Vocational School"),
   UNIVERSITY("University"),
   COLLEGE("College");
   private String description;

   EducationLevel (String description) {
      this.description = description;
   }

   @Override
   public String toString() {
      return this.description;
   }
}
