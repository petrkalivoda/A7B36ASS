package searchChallenge;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PersonSearch extends GenericSearch<Person> {

    // Restriction for Search
    private static final String[] RESTRICTIONS = {
        "lower(" + SortCriteria.FIRSTNAME.getProp() + ") like concat(lower(#{personSearch.person.firstName}),'%')",
        "lower(" + SortCriteria.LASTNAME.getProp() + ") like concat(lower(#{personSearch.person.lastName}),'%')",
        "lower(" + SortCriteria.AGE.getProp() + ") like concat(lower(#{personSearch.person.age}),'%')",};

    // instance of a person for search criteria data
    private Person person = new Person();

    private enum SortCriteria implements ICriteria {

        FIRSTNAME("person.firstName"),
        LASTNAME("person.lastName"),
        AGE("person.age");

        private final String prop;

        SortCriteria(String prop) {
            this.prop = prop;
        }

        public String getProp() {
            return prop;
        }
    }

    public PersonSearch() {
        super(Person.class, SortCriteria.class);
    }
    
    @Override
    // Restriction for Search
    protected List<String> getCriteria() {
        return Arrays.asList(RESTRICTIONS);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
