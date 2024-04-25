package assignment_3.player;

public class SoundSet
{

    private int duration;
    private int[] pitches;

    public SoundSet(int duration) throws SoundException
    {
        this.setDuration(duration);
        this.setPitches();
    }

    public SoundSet(int duration, int... pitches) throws SoundException
    {
        this.setDuration(duration);
        this.setPitches(pitches);
    }

    public SoundSet(int duration, String... notes) throws SoundDurationException, PitchOutOfRangeException
    {
        this.setDuration(duration);
        this.pitches = new int[notes.length];
        for (int i = 0; i < notes.length; i++) // המרה
        {
            pitches[i] = PitchHelper.nameToPitch(notes[i]);

        }
        this.setPitches(pitches); // בדיקה



    }

    public int getDuration()
    {

        return duration;
    }

    public void setDuration(int duration)throws SoundDurationException
    {
        if(duration<0)
        {
            throw new SoundDurationException(duration);
        }else
        {
            this.duration = duration;
        }
}

    public int[] getPitches()
    {
        return pitches;
    }

    public void setPitches(int... pitches) throws PitchOutOfRangeException {
        for (int pitch : pitches)
        {
            if (pitch < 0 || pitch > 127) {
                throw new PitchOutOfRangeException(pitch);
            }
        }
        this.pitches = pitches;
    }
    public String toString()
    {
        return "Duration: " + duration + "ms, notes: " + PitchHelper.pitchToName(pitches);

    }
}
