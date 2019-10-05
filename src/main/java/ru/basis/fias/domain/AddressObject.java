
package ru.basis.fias.domain;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "addrobj")
public class AddressObject {

	@Id
	@Column(name = "AOID")
	private String id;

	@Column(name = "AOGUID")
	private String guid;
        
        @Column(name = "AOLEVEL")
	private Integer level;

	@Column(name = "PARENTGUID")
	private String parentGuid;

	@Column(name = "OFFNAME")
	private String offName;

	@Column(name = "SHORTNAME")
	private String shortName;

	@Column(name = "ACTSTATUS")
	private int actStatus;

	@Column(name = "CODE")
	private String code;
        
        @Column(name = "POSTALCODE")
	private String postalCode;

	@Transient
	private boolean hasChildren;

	@Transient
	private List<AddressObject> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

	public String getParentGuid() {
		return parentGuid;
	}

	public void setParentGuid(String parentGuid) {
		this.parentGuid = parentGuid;
	}

	public String getOffName() {
		return offName;
	}

	public void setOffName(String offName) {
		this.offName = offName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getActStatus() {
		return actStatus;
	}

	public void setActStatus(int actStatus) {
		this.actStatus = actStatus;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

	public List<AddressObject> getChildren() {
		return children;
	}

	public void setChildren(List<AddressObject> children) {
		this.children = children;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
}

