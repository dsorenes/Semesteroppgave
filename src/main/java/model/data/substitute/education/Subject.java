package model.data.substitute.education;

public enum Subject {
    LIBRARY("Archive, library and information subjects"),
    THEATER("Drama and theater"),
    HEALTH("Health and social studies"),
    TECHNOLOGY("Engineer, technology and data"),
    INTERNATIONAL("International and intercultural studies"),
    JOURNALISM("Journalism, Communication and Media Studies"),
    ART("Art and design"),
    TEACHER("Teacher education, educational subjects and PPU"),
    NUTRITION("Food and nutrition"),
    LANGUAGE("Interpreting education and language courses"),
    VOCATIONAL("Occupational education and vocational teacher education"),
    ECONOMICS("Economics, management and social studies");
    private String description;

    Subject(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

    public static Subject fromString (String description) {
        for (Subject i : Subject.values()) {
            if (i.description.equalsIgnoreCase(description)) return i;
        }
        return null;
    }
}
