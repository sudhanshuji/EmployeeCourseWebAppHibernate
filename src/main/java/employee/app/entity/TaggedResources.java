package employee.app.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Resources_Issued")
public class TaggedResources {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Resource_Type")
	private String resourceType;
	@Column(name = "Resource_Name")
	private String resourceName;
	@Column(name = "Date_Of_Purchase")
	private Date purchaseDate;
	@Column(name = "Date_Of_Allocation")
	private Date allocationDate;
	@Column(name = "Status")
	private boolean isActive;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;

	public TaggedResources() {
		// TODO Auto-generated constructor stub
	}

	public TaggedResources(int id, String resourceType, String resourceName, Date purchaseDate, Date allocationDate,
			boolean isActive) {
		super();
		this.id = id;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.purchaseDate = purchaseDate;
		this.allocationDate = allocationDate;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
