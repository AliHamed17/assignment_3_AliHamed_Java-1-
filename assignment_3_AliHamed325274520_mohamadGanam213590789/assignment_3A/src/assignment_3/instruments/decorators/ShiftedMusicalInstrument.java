package assignment_3.instruments.decorators;

import assignment_3.instruments.MusicalInstrument;
import assignment_3.instruments.MusicalInstrumentImpl;
import assignment_3.player.Song;
import assignment_3.player.SoundException;
import assignment_3.player.SoundSet;

public class ShiftedMusicalInstrument extends MusicalInstrumentDecorator
{
private  int shift;
    public ShiftedMusicalInstrument(MusicalInstrument instrument, int shift)
    {
        super(instrument);
        this.shift=shift;
    }


    @Override
    public void play(SoundSet soundSet) throws SoundException {
        int[] originalPitches = soundSet.getPitches();
        int[] shiftedPitches = new int[originalPitches.length];

        for (int i = 0; i < originalPitches.length; i++) {
            shiftedPitches[i] = originalPitches[i] + shift;
        }

        super.play(new SoundSet(soundSet.getDuration(), shiftedPitches));
    }

    @Override
    public String toString()
    {
        return this.shift +" shifted " + super.toString();
    }


}
