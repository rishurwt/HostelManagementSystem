package com.knmodi.HostelManagementSystem.service;
import  com.knmodi.HostelManagementSystem.model.*;
//import java.util.ArrayList;
public interface FeesService 
{
	void registerFees(Fees fees);
	void showFees();
	void showFeesOne(int temp);
}