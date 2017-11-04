package houseInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qq.houseInfo.domain.City;
import com.qq.houseInfo.domain.House;
import com.qq.houseInfo.domain.HousePhoto;
import com.qq.houseInfo.domain.Province;
import com.qq.houseInfo.service.HouseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class AppTest01 {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private HouseService houseService;
	@Test
	public void testSave1() {
		Province province = new Province();
		province.setName("山东省");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(province);
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testSave2() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Province province = session.get(Province.class, 4);
		City city = new City();
		city.setName("hhh");
		city.setProvince(province);
		session.save(city);
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testSave3() {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		House house = session.get(House.class, 7);
		
		HousePhoto photo = new HousePhoto();
		photo.setHouse(house);
		photo.setName("123213213");
		houseService.saveOthersPhoto(photo);
		session.getTransaction().commit();
		session.close();
	}
	
}
