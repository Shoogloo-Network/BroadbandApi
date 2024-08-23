package com.bb.comparator;

import java.util.Comparator;

import com.bb.controller.helper.BroadBandView;

public class BroadBandViewComparator implements Comparator<BroadBandView> {
	int sortBy = 1;

	public BroadBandViewComparator(String sortBy) {
		if (sortBy.equals("sortingOrder"))
			this.sortBy = 1;
		if (sortBy.equals("ott"))
			this.sortBy = 2;
		if (sortBy.equals("cost"))
			this.sortBy = 3;
	}

	@Override
	public int compare(BroadBandView s1, BroadBandView s2) {
		if (sortBy == 1)
			return compareBySortingOrder(s1, s2);
		if (sortBy == 2)
			return compareByOTTOrder(s1, s2);
		if (sortBy == 3)
			return compareByCostOrder(s1, s2);
		else
			return 0;
	}

	public int compareBySortingOrder(BroadBandView s1, BroadBandView s2) {

		return s1.getBroadBand().getSortingOrder().compareTo(s2.getBroadBand().getSortingOrder());
	}

	public int compareByCostOrder(BroadBandView s1, BroadBandView s2) {

		return s1.getBroadBand().getCost().compareTo(s2.getBroadBand().getCost());
	}

	public int compareByOTTOrder(BroadBandView s1, BroadBandView s2) {
		try {
			return s2.getCountOTT().compareTo(s1.getCountOTT());
		} catch (Exception e) {
			return 0;
		}
	}
}
