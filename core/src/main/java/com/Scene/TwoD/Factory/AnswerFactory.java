package com.Scene.TwoD.Factory;


import com.Scene.TwoD.Object.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;
import java.util.List;


public class AnswerFactory {
    private Skin skin;
    private TextButton button;
    private List<TextButton> listAnswer;
    private List<List<TextButton>> listStageAnswer;

    Stage stage;
    public AnswerFactory(Skin skin) {
        this.skin = skin;
        StageManager stageFactory = new StageManager();

        listAnswer = new ArrayList<>();
        listStageAnswer = new ArrayList<>();
        for(int i =0;i <stageFactory.getStage().size();i++) {
             stage = stageFactory.getStageById(i);
       for (int j = 0;j<stage.getListAnswer().size();j++) {
           if (j == stage.getCorrectAnswer()) {
               TextButton button = new TextButton(stage.getListAnswerById(j), skin, "correct");
               button.getLabel().setWrap(true);

               listAnswer.add(button);
           } else {
               TextButton button = new TextButton(stage.getListAnswerById(j), skin, "default");
               button.getLabel().setWrap(true);

               listAnswer.add(button);
           }
       }
       listStageAnswer.add(listAnswer);
       listAnswer = new ArrayList<>();

       }
    }
    public List<TextButton> getListAnswerById(int idStage) {
        List<TextButton> returnListButton = new ArrayList<>();
        List<TextButton> getButtonList = listStageAnswer.get(idStage);

            for (int i = 0; i < listStageAnswer.get(idStage).size(); i++) {
                TextButton button = new TextButton(getButtonList.get(i).getText().toString(),getButtonList.get(i).getStyle());
                button.getLabel().setWrap(true);
                returnListButton.add(button);
        }

        return returnListButton;
    }
    public List<TextButton> updateListAnswer(int idStage, List<TextButton> listButton)  {

        List<TextButton> getButtonList = listStageAnswer.get(idStage);

         for (int i = 0; i < getButtonList.size();i++) {

             listButton.get(i).getLabel().setText(new String(getButtonList.get(i).getText().toString()));
             listButton.get(i).setStyle(new TextButton.TextButtonStyle(getButtonList.get(i).getStyle()));

         }


        return listButton;
    }

}
