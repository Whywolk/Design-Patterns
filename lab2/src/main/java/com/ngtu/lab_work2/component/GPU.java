package com.ngtu.lab_work2.component;

public class GPU extends Component {
	protected String pci;

	public GPU(String manufacturer, String name, String type, String pci) {
		super(manufacturer, name, type);
		this.pci = pci;
	}

	@Override
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
				   " * PCI: " + pci;
	}
}