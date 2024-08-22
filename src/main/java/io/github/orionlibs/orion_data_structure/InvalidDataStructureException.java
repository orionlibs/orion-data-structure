package io.github.orionlibs.orion_data_structure;

import io.github.orionlibs.orion_assert.OrionUncheckedException;

public class InvalidDataStructureException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "Invalid data structure.";


    public InvalidDataStructureException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidDataStructureException(String message)
    {
        super(message);
    }


    public InvalidDataStructureException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidDataStructureException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidDataStructureException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
