package com.team.stock.dbservice.resource;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import com.team.stock.dbservice.classes.Pilots;
import com.team.stock.dbservice.classes.Product;
import com.team.stock.dbservice.classes.Quote;
import com.team.stock.dbservice.classes.Quotes;
import com.team.stock.dbservice.repository.AccordionRepository;
import com.team.stock.dbservice.repository.ConversionTableRepository;
import com.team.stock.dbservice.repository.JDBCRepository;
import com.team.stock.dbservice.repository.PilotsRepository;
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
	@Autowired
	private ConversionTableRepository _ConversionTableRepository;
	@Autowired
	private PilotsRepository _PilotsRepository;
	

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
		//return _JDBCRepository.getAllBodyName();
		return null;
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
	@CrossOrigin(origins = "http://192.168.99.100:3000")
	@PostMapping("/postFieldsReturnTable")
	public ArrayList<ArrayList<String>> postFieldsReturnTable(@RequestBody final ArrayList<ArrayList<String>>fields) {
		for(int i=0;i<fields.size();i++)
		{
			System.out.println(fields.get(i));
			makeTableFromFieldsRow(fields.get(i));
		}
		List<List<String>> namesList =new ArrayList<List<String>>();
		 
		//ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
		//ArrayList<String> singleList = new ArrayList<String>();
		//singleList.add("משה");
		//singleList.add("מנחם");
		//singleList.add("2משה");
		//singleList.add("מנחם2");
		//listOLists.add(singleList);
	
		 return fields;
	}
	private List<List<String>>  makeTableFromFieldsRow(List<String> FieldsRow) {
		//List<String> last_names_all_pilots_name_ori= _PilotsRepository.find_last_name_ByName("אורי");
		//System.out.println(last_names_all_pilots_name_ori);
		List<String>ConvertNames= ConvertName(FieldsRow);
		List<List<String>>Part=new ArrayList<>();
		String[][]  PartRes=new String[2][];
		List<String>Part2=new ArrayList<>();
		for(int i=0;i<ConvertNames.size();i++)
		{
			Part.add(getPartsFromConvertName(ConvertNames.get(i)) );
		}
		
		System.out.println(Part);
		PartRes=convertRowsToColumns(Part);
		//System.out.println(PartRes[0][0]+" "+ PartRes[1][0]);
		System.out.println(Arrays.deepToString(PartRes));
		return null;
		
	}
	private String[][]  initStringArr(String[][]toInit,int rowsNum,int columnsNum) {
		 for(int i = 0; i < rowsNum; i++) {
		        for(int j = 0; j < columnsNum; j++) {

		        		toInit[i][j]=" ";
		        }
		    }
		 return toInit;
	}
	private String[][] convertRowsToColumns(List<List<String> >res){
		String[][] convertedTable=new String[2][9];
		convertedTable=initStringArr(convertedTable,2,9) ;
		 for(int i = 0; i < res.get(0).size(); i++) {
		        for(int j = 0; j < res.size(); j++) {
		        	convertedTable[i][j]=res.get(j).get(i)+"";
		        }
		    }
		return convertedTable;
	}
	private List<String> getcolumn(String column,String table,String condition) {
		return _JDBCRepository.getAllBodyName(column,table,condition);
	}
	private List<String> getPartsFromConvertName(String ConvertName) {
		String[]r= ConvertName.split("\\.");
		List<String> list = Arrays.asList(r);		
		List<String> res =	getcolumn(list.get(0),list.get(1),list.get(2));	
		//res =convertRowsToColumns(res);
		//System.out.println(res);
		return res;		
	}
	private List<String> ConvertName(List<String> FieldsRow){
		List<String> res=new ArrayList<String> ();
		for(int i=0;i<FieldsRow.size();i++)
		{
			res.add( _ConversionTableRepository.findDBName(FieldsRow.get(i)));			//System.out.println(_ConversionTableRepository.findDBName(FieldsRow.get(i)));
		}		
		System.out.println(FieldsRow);
		System.out.println(res);
		return res;
	}
	private String fillTable(ArrayList<ArrayList<String>>Table) {
		for(int i=0;i<Table.size();i++)
		{
			for(int j=0;j<Table.get(i).size();j++) {
				System.out.println(Table.get(i).get(j));
			}
			
		}
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
