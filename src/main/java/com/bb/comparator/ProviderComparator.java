package com.bb.comparator;

import java.util.Comparator;

import com.bb.primary.model.Provider;

public class ProviderComparator implements Comparator<Provider> {
	int sortBy = 0;

	public ProviderComparator(String sortBy) {
		if (sortBy.equals("sortingOrder"))
			this.sortBy = 1;
	}

	@Override
	public int compare(Provider s1, Provider s2) {
		
			return compareBySortingOrder(s1, s2);
		
	}

	int compareBySortingOrder(Provider s1, Provider s2) {
	
			if (s1.getSortingOrder() == s1.getSortingOrder())
				return 0;
		//	else if (s1.getSortingOrder() == 0 && s1.getSortingOrder() != 0)
		//		return 1;
		//	else if (s1.getSortingOrder() != 0 && s1.getSortingOrder() == 0)
		//		return -1;

			else if (s1.getSortingOrder() < s1.getSortingOrder())
				return 1;
			else
				return -1;
		
	}
}
