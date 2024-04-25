package assignment_3.instruments;

import assignment_3.instruments.decorators.TempoScaledMusicalInstrument;
import assignment_3.player.Song;
import assignment_3.player.SoundException;
import assignment_3.player.SoundSet;

public interface MusicalInstrument
{
    void playSong(Song song);


    void play(SoundSet soundSet)throws SoundException;


    String getName();

    int getNSimultaneousSounds();

    String toString();
}
