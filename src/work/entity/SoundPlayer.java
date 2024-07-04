package work.entity;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {
    private static final Media matchedSound = new Media(SoundPlayer.class.getResource("/work/gameResource/music/Matched.mp3").toString());
    private static final Media notMatchedSound=new Media(SoundPlayer.class.getResource("/work/gameResource/music/NotMatched.mp3").toString());
    private static final Media backGroundSound=new Media(SoundPlayer.class.getResource("/work/gameResource/music/abbandone.mp3").toString());
    private static MediaPlayer mediaPlayer;
    private static MediaPlayer backGroundSoundPlayer;

    public static void playMatchedSound() {
        mediaPlayer = new MediaPlayer(matchedSound);
        mediaPlayer.play();
    }

    public static void playNotMatchedSound(){
        mediaPlayer=new MediaPlayer(notMatchedSound);
        mediaPlayer.play();
    }

    public static void playerBackGroundSound(){
        if (backGroundSoundPlayer==null){
            backGroundSoundPlayer=new MediaPlayer(backGroundSound);
            backGroundSoundPlayer.play();
        }
    }

}
