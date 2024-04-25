package assignment_3.instruments;

public class UnknownInstrumentException extends Exception
{
    public UnknownInstrumentException(String name)
    {
        super("Unknown instrument: " + name+".");
    }
}
