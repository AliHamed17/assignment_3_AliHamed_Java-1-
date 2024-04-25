package assignment_3.instruments;

import assignment_3.player.SoundException;
import assignment_3.player.SoundSet;


public class Piano extends MusicalInstrumentImpl {


    public Piano() throws UnknownInstrumentException
    {
        super("Piano", 10);
    }

    public void playSlide(int from, int to, int duration) throws SoundException
    {
        int diff = 1;
        if (to < from) {
            diff = -1;
        }try
    {

        int slideSoundDuration = duration/10;
        play(new SoundSet(duration, from));
        for (int noteIx = from+diff; noteIx != to; noteIx += diff){
            play(new SoundSet(slideSoundDuration, noteIx));
        }
        play(new SoundSet(duration, to));
    }

       catch (TooManySoundsException ignore){}
    }

}
