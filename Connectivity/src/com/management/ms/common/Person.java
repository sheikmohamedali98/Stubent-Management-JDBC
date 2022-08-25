package com.management.ms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.course.cms.dto.Course;
import com.course.cms.dto.CourseDAOmysqlImpl;

public abstract class Person extends Course{
	private String emailid;
	private String contactnumber;
	private String birthdate;
	private String gender;
	private String state;
	private String city;
	private int sr_no;
	private boolean isactive;
	
	
	
	public void setEmailId(String emailid)
	{
		this.emailid=emailid;
	}
	public void setContactNumber(String contactnumber)
	{
		this.contactnumber=contactnumber;
	}
	public void setBirthDate(String birthdate)
	{
		this.birthdate=birthdate;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	
	public void setSrNo(int sr_no)
	{
		this.sr_no=sr_no;
	}

	public void setActiveStatus(boolean isactive)
	{
		this.isactive=isactive;
	}
	
	public String getCourceName()
	{
		return new CourseDAOmysqlImpl().getCoursename(this.getCourseCode());
	}

	public String getEmailId()
	{
		return emailid;
	}
	public String getContactNumber()
	{
		return contactnumber;
	}
	public String getBirthDate()
	{
		return birthdate;
	}
	public Date getBirthDateInDateFormat()
	{
		Date date=null;
		try {
			date=new SimpleDateFormat("dd-MM-yyyy").parse(this.birthdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public String getGender()
	{
		return gender;
	}
	public String getAddress()
	{
		return city+", "+state;
	}
	
	public String getState()
	{
		return state;
	}
	public String getCity()
	{
		return city;
	}

	public int getSrNo()
	{
		return sr_no;
	}
	public boolean getActiveStatus()
	{
		return isactive;
	}

}
