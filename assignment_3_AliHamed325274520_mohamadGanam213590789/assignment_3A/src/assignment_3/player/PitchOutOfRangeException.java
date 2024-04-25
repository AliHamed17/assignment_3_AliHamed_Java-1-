package assignment_3.player;

public class PitchOutOfRangeException extends  SoundException
{
    public  PitchOutOfRangeException(int pitch)
    {

        super("Invalid pitch. Pitch value must be between 0 and 127, got "+ pitch+".");
    }
}
