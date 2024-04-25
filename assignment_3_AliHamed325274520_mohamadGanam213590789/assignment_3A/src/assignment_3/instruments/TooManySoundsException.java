package assignment_3.instruments;

import assignment_3.player.SoundException;

public class TooManySoundsException extends SoundException
{
    public TooManySoundsException(String instrumentName, int maxSimultaneous, int soundsToPlay)
    {
        super(instrumentName + " can play at most " + maxSimultaneous + " simultaneous notes, cannot play a sound set with " + soundsToPlay + " notes!");
    }
}
