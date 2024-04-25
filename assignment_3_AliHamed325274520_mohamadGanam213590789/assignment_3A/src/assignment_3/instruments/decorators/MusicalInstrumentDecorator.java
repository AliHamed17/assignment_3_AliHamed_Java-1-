package assignment_3.instruments.decorators;

import assignment_3.instruments.MusicalInstrument;
import assignment_3.player.Song;
import assignment_3.player.SoundException;
import assignment_3.player.SoundSet;


// הדקורטור אב שלנו שממנו שאר הדקורטורים יורשים
public class MusicalInstrumentDecorator  implements MusicalInstrument
{
    protected MusicalInstrument instrument;
    public  MusicalInstrumentDecorator(MusicalInstrument instrument)
    {
        this.instrument=instrument;
    }
   public void playSong(Song song)
    {
        song.reset();
        // אין צורך לממש playsong בבנים ניתן לזהות את כל דקורטור על ידי switch
        switch (this)
        {
            case ShiftedMusicalInstrument shiftedMusicalInstrument ->
                    System.out.println("Playing " + song.getTitle() + " on " + shiftedMusicalInstrument.toString());
            case StaccatoMusicalInstrument staccatoMusicalInstrument ->
                    System.out.println("Playing " + song.getTitle() + " on " + staccatoMusicalInstrument.toString());
            case TempoScaledMusicalInstrument tempoScaledMusicalInstrument ->
                    System.out.println("Playing " + song.getTitle() + " on " + tempoScaledMusicalInstrument.toString());
            default -> {
            }
        }



        while (song.hasNext()) {
            try {
               play(song.next());
            } catch (SoundException e) {
                System.out.println("Stopped playing " + song.getTitle() + " due to error: " + e.getMessage());
                return;
            }
        }

        System.out.println("Done playing " + song.getTitle());
    }
  public void play(SoundSet soundSet) throws SoundException
  {
      this.instrument.play(soundSet);
  }
   public String getName()
   {
       return this.instrument.getName();
   }

    @Override
    public int getNSimultaneousSounds() {
        return this.instrument.getNSimultaneousSounds();
    }

    public String toString()
    {
        return this.instrument.toString();
    }
}
