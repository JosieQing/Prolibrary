package com.neusoft.mapping;

import java.util.HashMap;
import java.util.Map;

public class MappingFactory{
	
	/**
	 * 1.存储对象
	 * @return 
	 */
	private Map<String, EntityMapping> maps=new HashMap<String,EntityMapping>();
	/**
	 * 2.用户从工厂中获取对象时，提高效率(单例）第一：提供一个静态属性，第二提供一个私有构造器，第三提供一个静态方法
	 *
	 */ 
		private static MappingFactory mappingFactory=null;//提供一个静态属性
		
		private MappingFactory(){//提供一个私有构造器	
			
		}
		
		public static final String Admin_MAPPING = "AdminMAPPING";
		public static final String EmpEntry_MAPPING="EmpEntryMapping";
		public static final String Department_MAPPING="DepartmentMapping";
		public static final String Job_MAPPING="JobMapping";
		public static final String PROBATIONMAN_MAPPING = "ProbationManMapping";
		public static final String TRANSFERMAN_MAPPING = "TransferManMapping";
		public static final String FormNewEmployee_Mapping="FormNewEmployeeMapping";
		public static final String MoveDept_Mapping="MoveDeptMapping";
		public static final String MoveEmployee_Mapping="MoveEmployeeMapping";
		public static final String FormResign_Mapping="FormResignMapping";
		public static final String Turnover_Mapping="TurnoverMapping";
		
		public static MappingFactory getMappingFactory(){
			if(mappingFactory==null){
				mappingFactory=new MappingFactory();
				
				mappingFactory.maps.put(Admin_MAPPING, new AdminMapping());
				mappingFactory.maps.put(EmpEntry_MAPPING,new EmpEntryMapping());
				mappingFactory.maps.put(Department_MAPPING,new DepartmentMapping());
				mappingFactory.maps.put(Job_MAPPING,new JobMapping());
				mappingFactory.maps.put(PROBATIONMAN_MAPPING, new ProbationManMapping());
				mappingFactory.maps.put(TRANSFERMAN_MAPPING, new TransferManMapping());
				mappingFactory.maps.put(FormNewEmployee_Mapping, new FormNewEmployeeMapping());
				mappingFactory.maps.put(MoveDept_Mapping, new MoveDeptMapping());
				mappingFactory.maps.put(MoveEmployee_Mapping, new MoveEmployeeMapping());
				mappingFactory.maps.put(FormResign_Mapping, new FormResignMapping());
				mappingFactory.maps.put(Turnover_Mapping, new TurnoverMapping());
			}
			
		 return mappingFactory; 
	}
		/**
		 * 3.从集合中获取XXXmapping对象
		 * 
		 */
		public  EntityMapping getMapping(String name){
			return maps.get(name);
		}
	
	
	
}
	
	
	
	
	
	

