package com;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class ShowSound {

    /**
     *Initialize the sound
     * @param sound Sound filename
     */
    private Sound sound;

    public ShowSound(Sound sound) {
        this.setSound(sound);
    }

    /**
     * Get sound file
     * @return sound
     */
    public Sound getSound() {
        return this.sound;
    }

    public void setSound(Sound sound) {
        try {
            this.sound = new Sound(String.valueOf(sound));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * @param sound     Sound Filename
//     * @param looping   Loop
//     * @param pitch     Pitch
//     * @param volume    Volume
//     */
//    public final void play(String sound, boolean looping, float pitch, float volume) {
//        if (!looping)
//            this.getSound().play(pitch, volume);
//        else
//            this.getSound().loop(pitch, volume);
//    }

    /**
     * Play sound
     * @param looping	Loop
     */
    public final void play(boolean looping) {
        this.play(looping, 1f, 1f);
    }

    /**
     * @param looping Loop
     * @param pitch   Pitch
     * @param volume  Volume
     */
    public final void play(boolean looping, float pitch, float volume) {
        if (!looping)
            this.getSound().play(pitch, volume);
        else
            this.getSound().loop(pitch, volume);
    }

    public final void play() {
        this.play(false, 1f, 1f);
    }

    /**
     * @param sound     Sound Filename
     * @param looping   Loop
     * @param pitch     Pitch
     * @param volume    Volume
     */
    public static final void play(String sound, boolean looping, float pitch, float volume) {
        try {
            Sound snd = new Sound(sound);
            if (looping == true)
                snd.loop(pitch, volume);
            else
                snd.play(pitch, volume);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param sound     Sound filename
     * @param looping   Loop
     */
    public static final void play(String sound, boolean looping) {
        play(sound, looping, 1f, 1f);
    }

    /**
     * Stop the sound
     */
    public final void stop() {
        this.getSound().stop();
    }

}
