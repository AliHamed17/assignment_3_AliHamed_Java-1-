package assignment_3.player;

public class SoundDurationException extends SoundException
{
    public  SoundDurationException(int duration)
    {

      super("Sound duration must be nonnegative, got " + duration + "ms.");


    }

    }


