package ru.WhyW0.pojo;

import java.util.ArrayList;

public class ComputerBuilder {
	private CPU[] cpuList;
	private GPU[] gpuList;
	private Motherboard[] mbList;
	
	public ComputerBuilder() {
		super();
	}

	public ComputerBuilder(CPU[] cpuList, GPU[] gpuList, Motherboard[] mbList) {
		super();
		this.cpuList = cpuList;
		this.gpuList = gpuList;
		this.mbList = mbList;
	}
	
	public SystemUnit[] run()
	{
		ArrayList<SystemUnit> uList = new ArrayList<>();
		for(Motherboard mb : mbList) {
			for(CPU cpu : cpuList) {
				SystemUnit uTemp = new SystemUnit();
				
				// Checking compatibility CPU and motherboard
				if(cpu.socket == mb.socket) {	
					uTemp.setCPU(cpu);
					uTemp.setMotherboard(mb);
				}
				
				// We can add GPU only if we have motherboard
				if(uTemp.getMotherboard() != null) {
					// Checking compatibility motherboard and GPU
					for(GPU gpu : gpuList) {
						if(mb.pci == gpu.pci) {
							uTemp.setGPU(gpu);
						}
					}
				}
				
				// TODO:
				// Probably we will change it later, but right let's
				// build only when we have all components
				if(uTemp.isFull()) {
					uList.add(uTemp);
				}
			}
		}
		
		// TODO:
		// Checking if we don't have all components
		// like we have only GPU etc
		///if(uList.get(uList.size() - 1).getCPU() == null)
		///	return null;
		
		SystemUnit[] uArr = new SystemUnit[uList.size()];
		uList.toArray(uArr);
		
		return uArr;
		
		/*ArrayList<SystemUnit> suList = new ArrayList<>();
		for(CPU cpu : cpuList)
		{	
			SystemUnit temp = new SystemUnit();
			temp.setCPU(cpu);
			suList.add(temp);
		}
		
		ArrayList<SystemUnit> tempList = new ArrayList<>();
		
		for(SystemUnit su : suList)
		{
			ArrayList<Motherboard> filteredMb = new ArrayList<>();
			for(Motherboard mb : mbList)
			{
				if(su.cpu.socket == mb.socket)
				{
					filteredMb.add(mb);
				}
			}
			
			for(Motherboard filMb : filteredMb)
			{
				SystemUnit temp = su;
				temp.setMotherboard(filMb);
				tempList.add(temp);
			}
		}
		
		// ���������� �������� ������, �.�. � ��� ���������� ����������
		// ������ ��� ��� ��� ���� ����� ���������
		// ����� �������� �� ������ ������, ������� ������
		//suList = tempList;
		
		suList = (ArrayList<SystemUnit>) tempList.clone();
		
		tempList.clear();
		
		for(SystemUnit su : suList)
		{
			ArrayList<GPU> filteredGPU = new ArrayList<>();
			for(GPU gpu : gpuList)
			{
				if(su.mb.pci == gpu.pci)
				{
					filteredGPU.add(gpu);
				}
			}
			
			for(GPU filGPU : filteredGPU)
			{
				SystemUnit temp = su;
				temp.setGPU(filGPU);
				tempList.add(temp);
			}
		}
		
		suList = tempList;
		
		
		SystemUnit[] suArray = new SystemUnit[suList.size()];
		suList.toArray(suArray);
		
		return suArray;*/
	}
	
	
	
	
	
	
	
	
	
	
}