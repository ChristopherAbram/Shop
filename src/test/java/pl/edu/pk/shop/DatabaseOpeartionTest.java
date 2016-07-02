package pl.edu.pk.shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.edu.pk.shop.database.Database;
import pl.edu.pk.shop.elements.address.*;

public class DatabaseOpeartionTest {
	
	private AddressData data;
	private boolean p = false;
	
	@Test
	public void connectionTest() {
		Database db = Database.getInstance();
		db.connect();
		assertTrue("Missing connection!", db.connected());
	}
	
	@Before
	public void insertAddress(){
		data = new AddressData();
		data.cityname = "Kraków";
		data.flatnumber = "21";
		data.street = "Warszawska";
		data.zipcode = "31-012";
		p = data.insert();
	}
	
	@Test
	public void addressInsertionTest(){
		assertTrue("Address inserting failed!", p);
	}
	
	@Test
	public void addressSelectionTest(){
		Address address = new Address(data.id);
		
		assertSame("Inconsistent id!", data.id, address.data.id);
		assertTrue("Inconsistent cityname!", data.cityname.equals(address.data.cityname));
		assertTrue("Inconsistent flatnumber!", data.flatnumber.equals(address.data.flatnumber));
		assertTrue("Inconsistent street!", data.street.equals(address.data.street));
		assertTrue("Inconsistent zipcode!", data.zipcode.equals(address.data.zipcode));
	}
	
	@Test
	public void addressUpdateTest(){
		if(data != null){
			Address a = new Address(data.id);
			a.data.street = "Krakowska";
			assertTrue("", a.data.update());
		}
	}
	
	@Test
	public void addressDeletionTest(){
		if(data != null){
			Address a = new Address(data.id);
			assertTrue("", a.data.delete());
		}
	}

}
