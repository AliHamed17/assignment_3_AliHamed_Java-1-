package assignment_3.instruments.decorators;

import assignment_3.instruments.MusicalInstrument;
import assignment_3.instruments.MusicalInstrumentImpl;
import assignment_3.instruments.TooManySoundsException;
import assignment_3.player.*;

public class StaccatoMusicalInstrument extends MusicalInstrumentDecorator
{
private final int staccatoDuration = 20;


    public StaccatoMusicalInstrument(MusicalInstrument instrument)
    {
        super(instrument);
    }

    @Override
    public void play(SoundSet soundset) throws SoundException
    {

        int[] pitches = soundset.getPitches();
        int duration =soundset.getDuration();
         if(duration>staccatoDuration)
         {
             for (int pitch: pitches)
             {
                 super.play(new SoundSet(staccatoDuration,pitch));
                 super.play(new SoundSet(duration-staccatoDuration));

             }

         }


    }



    @Override
    public String toString()
    {
        return super.toString()+" with staccato";
    }


}
