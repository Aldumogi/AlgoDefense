package edu.fiuba.algo3.view;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SoundUtils {
    public static final String HOME_MUSIC_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/8-Bit_Algo_defense_home_music.wav";
    public static final String BUTTON_SOUND_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/swords_clashing.wav";
    public static final String BUTTON_NEXT_SOUND_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/Castle-Wood-Door-Sound.wav";
    public static final String BUTTON_OPEN_SOUND_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/opening.wav";
    public static final String BUTTON_CLOSE_SOUND_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/close.wav";
    public static final String CLICK_DEFENSE_SOUND_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/hammer.wav";
    public static final String CLICK_DEFENSE_BUILDING_SOUND_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/building.wav";
    public static final String START_GAME_MUSIC_FILE_PATH = "src/main/java/edu/fiuba/algo3/view/sounds/8-Bit-Algo-defense-music_start_game.wav";

    public static void playSound(String url, float volume, Clip clipBase) {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(url)))) {
            Clip clip = AudioSystem.getClip();
            if (clipBase != null) {
                clip = clipBase;
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }

            clip.open(audioInputStream);
            adjustVolume(clip, volume);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void adjustVolume(Clip clip, float volume) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }

    public static void stopSound(Clip clip) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
