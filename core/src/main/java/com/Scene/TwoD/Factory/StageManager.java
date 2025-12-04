package com.Scene.TwoD.Factory;

import com.Scene.TwoD.Object.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.*;

public class StageManager {

    private JsonReader json;
    private JsonValue jsonStage, jsonAnswer;
    private List<String> listAnswers;
    private List<Stage> listStages;
    private String question;
    private int correctAnswer;
    private String theme;
    private boolean isEmptyStage = false;
    public StageManager(){ //
        json = new JsonReader();
       JsonValue jsonValue = json.parse(Gdx.files.internal("question/question_EN.json"));
        listAnswers = new ArrayList<>();
        listStages = new ArrayList<>();

        for (int i = 0; !isEmptyStage; i++) {
            Stage stage = new Stage();
            if(jsonValue.get("stage_".concat(String.valueOf(i))) != null) {
                jsonStage = jsonValue.get("stage_".concat(String.valueOf(i)));
                theme = jsonStage.getString("theme");
                question = jsonStage.getString("question");
                correctAnswer = jsonStage.getInt("correct_answer");

                jsonAnswer = jsonStage.get("answer");
                    for(JsonValue valuer : jsonAnswer) {
                        listAnswers.add(valuer.asString());


                }

                    stage.setTheme(theme);
                    stage.setQuestion(question);
                    stage.setListAnswer(listAnswers);
                    stage.setCorrectAnswer(correctAnswer);
                    listStages.add(stage);
                    listAnswers = new ArrayList<>();
            }
            else {
                isEmptyStage = true;
                return;
            }
        }
    }


    public Stage getStageById(int id) {
        return listStages.get(id);
    }
    public List<Stage> getStage() {
        return listStages;
    }
}
//jsonStage = jsonValue.get("stage_1");
// jsons = jsonStage.getString("question");
