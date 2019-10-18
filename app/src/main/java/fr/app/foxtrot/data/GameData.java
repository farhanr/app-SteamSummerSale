package fr.app.foxtrot.data;

import android.content.Context;
import android.content.ContextWrapper;

import java.util.ArrayList;

import fr.app.foxtrot.R;
import fr.app.foxtrot.model.Game;

public class GameData extends ContextWrapper {
    private Context context;
    private static ArrayList<Game> listGame = new ArrayList<>();
    private static String[] gameNames;
    private static String[] gameDetails;
    private static String[] gamePhotos;
    private static String[] gameDiscount;
    private static String[] gameDescription;
    private static String[] gameRelease;

    public GameData(Context base) {
        super(base);
        gameNames = getResources().getStringArray(R.array.game_title);
        gameDetails = getResources().getStringArray(R.array.game_detail);
        gamePhotos = getResources().getStringArray(R.array.game_imagelink);
        gameDiscount = getResources().getStringArray(R.array.game_discount);
        gameDescription = getResources().getStringArray(R.array.game_desc);
        gameRelease = getResources().getStringArray(R.array.game_release);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static ArrayList<Game> getListGame(){
        for (int i = 0; i < gameNames.length; i++) {
            //int resourceId = this.getResources().getIdentifier(gamePhotos[i],"drawable",this.getPackageName());
            //String value = String.valueOf(resourceId);
            listGame.add(new Game(gameNames[i],gameDetails[i],gamePhotos[i],gameDiscount[i],gameDescription[i],gameRelease[i]));
        }
        return listGame;
    }
}
