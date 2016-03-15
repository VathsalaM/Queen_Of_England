package Print;

import Person.Guest;

public class CompositeFormat implements Format{
    Format format ;

    public CompositeFormat(Format format) {
        this.format = format;
    }


    @Override
    public String value(Guest guest) {
        return format.value(guest);
    }


}
