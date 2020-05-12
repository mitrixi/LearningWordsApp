package com.learningwordsapp.model;

public class Word {
    private int id;
    private String word;
    private String translation;
    private String example;
    private String transcription;

    public Word(int id) {

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
}
