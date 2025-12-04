package com.Scene.TwoD.Object;

import java.util.List;

public class Stage {
    private String theme;
    private String question;
    private List<String> listAnswer;
    private int correctAnswer;

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setListAnswer(List<String> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public String getTheme() {
        return theme;
    }

    public String getQuestion() {
        return question;
    }
    public List<String> getListAnswer() {
        return listAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getListAnswerById(int id) {
        return listAnswer.get(id);
    }

}
