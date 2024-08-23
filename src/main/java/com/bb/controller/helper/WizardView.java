package com.bb.controller.helper;

import java.util.List;

import com.bb.primary.model.NewWizard;
import com.bb.primary.model.NewWizarditem;

public class WizardView {
NewWizard wizard;
List<NewWizarditem> wizardItem;
public NewWizard getWizard() {
	return wizard;
}
public void setWizard(NewWizard wizard) {
	this.wizard = wizard;
}
public List<NewWizarditem> getWizardItem() {
	return wizardItem;
}
public void setWizardItem(List<NewWizarditem> wizardItem) {
	this.wizardItem = wizardItem;
}
@Override
public String toString() {
	return "WizardView [wizard=" + wizard + ", wizardItem=" + wizardItem + "]";
}

}
