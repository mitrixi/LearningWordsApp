package com.learningwordsapp.model;

public class Word {
    private int id;
    private String word;
    private String translation;
    private String example;
    private String transcription;

    public Word(int id) {

    }

    public Word(String word, String transcription, String translation) {
        this.word = word;
        this.transcription = transcription;
        this.translation = translation;
    }

    public Word(int id, String word, String translation, String example, String transcription) {
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.example = example;
        this.transcription = transcription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (id != word1.id) return false;
        if (!word.equals(word1.word)) return false;
        if (!translation.equals(word1.translation)) return false;
        if (!example.equals(word1.example)) return false;
        return transcription.equals(word1.transcription);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + word.hashCode();
        result = 31 * result + translation.hashCode();
        result = 31 * result + example.hashCode();
        result = 31 * result + transcription.hashCode();
        return result;
    }

    public String toJson(){
        return String.format(
                "{\"word\" : { \"translation\" : \"%s\", " +
                        "\"example\" : \"%s\"," +
                        "\"word\" : \"%s\"," +
                        "\"transcription\" : \"%s\"} }",
                this.translation,
                this.example,
                this.word,
                this.transcription);
    }
}
