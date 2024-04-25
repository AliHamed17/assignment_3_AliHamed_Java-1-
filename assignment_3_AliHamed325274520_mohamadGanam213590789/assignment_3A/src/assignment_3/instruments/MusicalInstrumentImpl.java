package assignment_3.instruments;

import assignment_3.player.*;

public abstract class MusicalInstrumentImpl implements MusicalInstrument {
    private String name;
    protected Player player;
    private int nSimultaneousSounds;

    public MusicalInstrumentImpl(String name, int nSimultaneousSounds) throws UnknownInstrumentException
    {
        this.name = name;
        this.nSimultaneousSounds = nSimultaneousSounds;
        player = new Player(name);
    }

    public MusicalInstrumentImpl(String name) throws  UnknownInstrumentException
    {
        this(name, 1);
    }

    @Override
    public void playSong(Song song)
    {
        System.out.println("Playing " + song.getTitle() + " on " + this.toString());
        song.reset();
        while (song.hasNext())
        {
            try
            {
                play(song.next());
            } catch (SoundException e)
            {
                System.out.println("Stopped playing " + song.getTitle() + " due to error: " + e.getMessage());
                return;  // סיום הפונקציה במקרה של שגיאה
            }
        }

        System.out.println("Done playing " + song.getTitle());
    }

    @Override
    public void play(SoundSet soundSet) throws TooManySoundsException
    {


        if(soundSet.getPitches().length>this.nSimultaneousSounds)
        {
        throw new  TooManySoundsException(this.name,this.nSimultaneousSounds,soundSet.getPitches().length);

        }

         System.out.println("Playing " + soundSet.toString());


        player.playSound(soundSet);

    }

    @Override
    public String getName()
    {
        return name;
    }


    @Override
    public int getNSimultaneousSounds()
    {
        return nSimultaneousSounds;
    }

    @Override
    public String toString()
    {
        return name;
    }

}

