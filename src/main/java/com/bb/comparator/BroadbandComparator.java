package com.bb.comparator;

import java.util.Comparator;

import com.bb.controller.helper.BroadBandView;
import com.bb.primary.model.Broadband;

public class BroadbandComparator implements Comparator<Broadband> {
	int sortBy = 1;

	public BroadbandComparator(String sortBy) {
		if (sortBy.equals("sortingOrder"))
			this.sortBy = 1;
	}

	@Override
	public int compare(Broadband s1, Broadband s2) {
		if (sortBy == 1)
			return compareBySortingOrder(s1, s2);
		else
			return 0;
	}

	public int compareBySortingOrder(Broadband s1, Broadband s2) {

		return s1.getSortingOrder().compareTo(s2.getSortingOrder());
	}
}
