package com.learningwordsapp.model;

public class Word {
    private int id;
    private String translation;
    private String example;
    private String word;
    private String transcription;

    public Word(){
    }

    public Word(String translation,
                String word){
        this();
        this.translation = translation;
        this.word = word;

    }

    public Word(String translation,
                String transcription,
                String word){
        this(translation, word);
        this.transcription = transcription;
    }

    public Word(String translation,
                String example,
                String word,
                String transcription){
        this(translation, transcription, word);
        this.example = example;
    }

    public int getId() {
        return id;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
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
