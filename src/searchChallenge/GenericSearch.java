package searchChallenge;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericSearch<T> implements ISearch {

	private String orderBy = null;

	protected Class<T> clazz = null;
        
        protected Class enumClazz = null;

	public GenericSearch(Class<T> clazz, Class enumClazz) {
		this.clazz = clazz;
                this.enumClazz = enumClazz;
	}
	
	// naive search
	public List<T> search() {
		List<String> criteriaArray = getCriteria();
		if (criteriaArray != null) {
			System.out.println("---Translated to---");
			System.out.println(" select * from "
					+ clazz.getSimpleName() + " where ");


			for (String criteria : criteriaArray) {
				if(criteria.equals(criteriaArray.get(criteriaArray.size()-1))) {
					System.out.println(criteria + " ");
				} else {
					System.out.println(criteria + ", ");
				}
			}
			System.out.println(" order by " + orderBy);
			System.out.println("---comments---");
			System.out
					.println("--Our framework would supply the real values for #{params}");

			// here would be database search
			List<T> out = new ArrayList<T>();
			return out;
		} else {
			return null;
		}
	}
	
	// I need this function for criteria
	protected abstract List<String> getCriteria();
        
	// I need this function for translation or the order
	protected BiMap<String, String> getAllowedOrder() {
            BiMap<String, String> allowedOrder = new BiMap<String, String>();
            
            for(Object o : enumClazz.getEnumConstants()) {
                if(o instanceof ICriteria) {
                    ICriteria crit = (ICriteria)o;
                    allowedOrder.put(crit.toString(), crit.getProp());
                }
            }
            
            return allowedOrder;
        }

	// this data go out of the system so we do translation
	public String getOrderBy() {
		return getAllowedOrder().getKey(orderBy);
	}

	// this data go back to the system so we do translation
	public void setOrderBy(String orderBy) {
		this.orderBy = getAllowedOrder().getValue(orderBy);
	}

}
