package com.freelance.model;

public enum SkillName {
    FRONTEND("Frontend Developer"),
    BACKEND("Backend Developer"),
    FULLSTACK("Fullstack Developer"),
    UI_UX("UI&UX Developer"),
    SWRITING("SEO WRITING"),
    ILLUSRATION("Adobe Illustrator"),
    DIGITAL_ART("Digital Art"),
    PHOTO_MANIPULATION("Photo manipulation"),
    VIDEO_EDITING("Video editing"),
    ROBOTICS("Robotics"),
    ML("Machine Learning"),
    AI("Artificial Learning"),
    SQL("SQL Database"),
    MYSQL("MySQL Database"),
    PYTHON("Python"),
    JAVA("Java"),
    SPRING("Spring boot framework"),
    ANGULAR("Angular framework"),
    JS("Java Script"),
    REACTJS("React Js"),
    LOGO("Logo desgining"),
    VOICE_OVER("Voice over"),
    PODCAST_EDITING("Podcast editing"),
    BEAT_MAKING("Beat making"),
    GAME_ART("Game Digital Art"),
    PATTERN_DESIGN("Pattern Design"),
    TATTOO("Tattoo Design"),
    WORDPRESS("Wordpress"),
    ONLINE_TUTORING("Online tutor"),
    DANCE("Dance tutor"),
    ART("Art tutor"),
    FITNESS("Fitness trainer"),
    COOKING("Cooking ");

    public final String type;

    SkillName(String type) {
        this.type = type;
    }
}
