package com.team.stock.dbservice.resource;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.stock.dbservice.classes.Accordion;
import com.team.stock.dbservice.classes.JoinCitiesAccordion;
import com.team.stock.dbservice.classes.ObjectEnglishHebrew;
import com.team.stock.dbservice.classes.Product;
import com.team.stock.dbservice.classes.Quote;
import com.team.stock.dbservice.classes.Quotes;
import com.team.stock.dbservice.repository.AccordionRepository;
import com.team.stock.dbservice.repository.JDBCRepository;
import com.team.stock.dbservice.repository.QuoetsRepository;

import javassist.bytecode.SignatureAttribute.ClassType;

@RestController
@RequestMapping("/rest/Accordion")
public class AccordionDataResource {
	@Autowired
	private QuoetsRepository _QuoetsRepository;

	@Autowired
	private AccordionRepository _AccordionRepository;
	@Autowired
	private JDBCRepository _JDBCRepository;

	// return object jdbc -need doa
	@GetMapping("/getJoinCitiesAccordion")
	public List<JoinCitiesAccordion> getJoinCitiesAccordion() {
		return _JDBCRepository.getJoinCitiesAccordion();
	}

	// return object ? jdbc -need doa
	@GetMapping("/getobjJoinCitiesAccordion")
	public List<?> getobjJoinCitiesAccordion() {
		return _JDBCRepository.getobjJoinCitiesAccordion();
	}

	// http://localhost:7000/rest/Accordion/AllnamesJdbc
	@GetMapping("/getAllBodyName")
	public List<String> getAllBodyName() {
		return _JDBCRepository.getAllBodyName();
	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}



	//--------------------------------------
	/**
	 * Returns all Objects Names
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * GET
	 * url :http://localhost:7000/rest/Accordion/GetObjectsNames
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/GetObjectsNames")
	public List<?> GetObjectsNames() {

		List<?> res = Arrays.asList(
				new ObjectEnglishHebrew(1, "אקורדיון", "Accordion"),
				new ObjectEnglishHebrew(2, "מוצר", "Product"),
				new ObjectEnglishHebrew(2, "ציטוט", "Quote"));
				//Arrays.asList({"Product","Accordion","Quote");

		return res;
		
	}
	static  List<String> inspect(Class<?> klazz) {
		Field[] fields = klazz.getDeclaredFields();
		List<String>res=new ArrayList<>();
		System.out.printf("%d fields:%n", fields.length);
		for (Field field : fields) {
			res.add((String) field.getName());
			System.out.printf("%s %n", field.getName());
		}
		return res;
	}
	/**
	 * Get object name and Returns all Object Fields
	 *
	 * @param  one object name from object name list
	 * @return object fields
	 * @HTTP_request_method GET
	 * @URL :http://localhost:7000/rest/Accordion/Product
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/{objectname}")
	public List<String> getFieldsByObjectName(@PathVariable("objectname") final 
			String objectname) {
		List<String> res=new ArrayList<>();
		System.out.println(objectname);
		List<Class> ObjectsNames = Arrays.asList(Product.class, Accordion.class, Quote.class);
		try {
			 ClassLoader cl=getClass().getClassLoader();
			 Class c = cl.loadClass("com.team.stock.dbservice.classes."+objectname);
			 System.out.println(c.getName());
			 return inspect(c);
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * post tables Fields and Return Table data
	 *
	 * @param  one object name from object name list
	 * @return object fields
	 * @HTTP_request_method POST
	 * @URL :http://localhost:7000/rest/Accordion/postFieldsReturnTable
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/postFieldsReturnTable")
	public List<String> postFieldsReturnTable(@RequestBody final List<String>fields) {
		for(int i=0;i<fields.size();i++)
		{
			System.out.println(fields.get(i));
		}
		
		//_Quotes.getQuotes().stream().map(Quote -> new Quote(_Quotes.getUserName(), Quote))
		//		.forEach(Quote -> _QuoetsRepository.save(Quote));
		//return getQuoetsByUserName(_Quotes.getUserName());
		 return null;
	}
	//----------------------------
	// http://localhost:7000/rest/db/ggg
	/*@GetMapping("/{username}")
	public List<String> getQuoetsByUserName(@PathVariable("username") final String username) {
		return _QuoetsRepository.findByusername(username).stream().map(Quote::getQuote).collect(Collectors.toList());
	}*/

	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes _Quotes) {
		System.out.println(_Quotes.getQuotes());
		_Quotes.getQuotes().stream().map(Quote -> new Quote(_Quotes.getUserName(), Quote))
				.forEach(Quote -> _QuoetsRepository.save(Quote));
		//return getQuoetsByUserName(_Quotes.getUserName());
		 return null;
	}

}
