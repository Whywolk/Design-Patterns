package ru.WhyW0.pojo;

public abstract class Component implements IPrintable {
	protected String manufacturer;
	protected String name;
	public String type;
	
	public Component() {
		super();
	}
	
	public Component(String manufacturer, String name, String type) {
		super();
		this.manufacturer = manufacturer;
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Component [manufacturer=" + manufacturer + ", name=" + name + ", type=" + type + "]";
	}
	
	

}
