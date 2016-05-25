package DAO;

public interface dao {
	public interface DAO {
		
		public void addGuitar(String serialNumber, String builder, 
				String model, String type, String backWood, String topWood,	String price);
		
		public void delGuitar(String serialNumber);
		
		
		public void updateGuitar(String serialNumber, String builder, 
				String model, String type, String backWood, String topWood,	String price);
		
		public List<Guitar> guitars();
		
		
	}

}
