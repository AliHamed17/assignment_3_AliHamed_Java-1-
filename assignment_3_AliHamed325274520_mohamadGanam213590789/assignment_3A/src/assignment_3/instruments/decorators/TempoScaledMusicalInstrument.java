package assignment_3.instruments.decorators;

import assignment_3.instruments.MusicalInstrument;
import assignment_3.instruments.MusicalInstrumentImpl;
import assignment_3.instruments.TooManySoundsException;
import assignment_3.player.Player;
import assignment_3.player.Song;
import assignment_3.player.SoundException;
import assignment_3.player.SoundSet;

import java.util.Arrays;


public class TempoScaledMusicalInstrument extends MusicalInstrumentDecorator {

 private double scaleFactor;

    public TempoScaledMusicalInstrument(MusicalInstrument instrument, double scaleFactor) {
        super(instrument);
        this.scaleFactor = scaleFactor;

    }


    @Override
    public void play(SoundSet soundSet) throws SoundException
    {

        int[] pitches = soundSet.getPitches();
        int scaledDurationForPitch = (int) (soundSet.getDuration() * this.scaleFactor);
        SoundSet copySoundSet= new SoundSet(scaledDurationForPitch,pitches);
        super.play(copySoundSet);

    }


    @Override
    public String toString()
    {
        return this.scaleFactor+" tempo scaled " + super.toString();
    }

}
