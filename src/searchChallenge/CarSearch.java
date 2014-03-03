package searchChallenge;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarSearch extends GenericSearch<Car> {

    // Restriction for Search
    private static final String[] RESTRICTIONS = {
        "lower(" + SortCriteria.BRAND.getProp() + ") like concat(lower(#{carSearch.car.brand}),'%')",
        "lower(" + SortCriteria.YEAR.getProp() + ") like concat(lower(#{carSearch.car.year}),'%')",};

    // instance of a person for search criteria data
    private Car car = new Car();

    private enum SortCriteria implements ICriteria {

        BRAND("car.brand"),
        YEAR("car.year");

        private final String prop;

        SortCriteria(String prop) {
            this.prop = prop;
        }

        public String getProp() {
            return prop;
        }
        
        
    }

    public CarSearch() {
        super(Car.class, SortCriteria.class);
    }

    @Override
    // Restriction for Search
    protected List<String> getCriteria() {
        return Arrays.asList(RESTRICTIONS);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
