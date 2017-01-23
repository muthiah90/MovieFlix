package movieflix.restapi.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Muthiah
 * This is an entity class for USers
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Users.getAllUsers", query = "select u from Users u"),
	@NamedQuery(name = "Users.getUserDetailsbyId", query = "select u from Users u where u.userId = :pUserId"),
	@NamedQuery(name = "Users.validateUser", query = "select u from Users u where u.userName = :pUserName and u.password = :pPassword"),
	@NamedQuery(name = "Users.getUserByEmail", query = "select u from Users u where u.emailId = :pEmailId"),
	@NamedQuery(name = "Users.getUserByUserName", query = "select u from Users u where u.userName = :pUserName")
})
public class Users
{

	@Id
	private String userId;

	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String emailId;

	@Column(unique = true)
	private String userName;

	private String password;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dob;

	private String address;
	private Boolean adminFlag;
	private Date createdDate;
	private Date updatedDate;

	public Users()
	{
		this.userId = UUID.randomUUID().toString();
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Boolean getAdminFlag()
	{
		return adminFlag;
	}

	public void setAdminFlag(Boolean adminFlag)
	{
		this.adminFlag = adminFlag;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@PrePersist
	void setCreatedDate()
	{
		this.createdDate = this.updatedDate = new Date();
	}

	@PreUpdate
	void setUpdatedDate()
	{
		this.updatedDate = new Date();
	}

	public void copyUserFrom(Users user)
	{
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.emailId = user.getEmailId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.dob = user.getDob();
		this.address = user.getAddress();
		this.adminFlag = user.getAdminFlag();
	}
}
